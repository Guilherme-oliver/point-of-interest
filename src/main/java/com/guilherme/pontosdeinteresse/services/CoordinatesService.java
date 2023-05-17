package com.guilherme.pontosdeinteresse.services;

import com.guilherme.pontosdeinteresse.entities.Coordinates;
import com.guilherme.pontosdeinteresse.entities.dto.CoordinatesDTO;
import com.guilherme.pontosdeinteresse.repositories.CoordinatesRepository;
import com.guilherme.pontosdeinteresse.services.exceptions.DatabaseException;
import com.guilherme.pontosdeinteresse.services.exceptions.ObjectNotFoundException;
import com.guilherme.pontosdeinteresse.services.exceptions.ResourceNotFoundException;
import com.guilherme.pontosdeinteresse.services.implement.PointsOfInterest;
import com.guilherme.pontosdeinteresse.services.utils.LocateUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoordinatesService implements PointsOfInterest {

    @Autowired
    private CoordinatesRepository coordinatesRepository;

	@Override
    public List<Coordinates> findAllPoints() {
        return coordinatesRepository.findAll();
    }

	@Override
    public Coordinates findById(Long id) {
        Optional<Coordinates> object = coordinatesRepository.findById(id);
        return object.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Coordinates.class.getName()));
    }

	@Override
    public Coordinates findByName(String name) {
        Optional<Coordinates> object = coordinatesRepository.findByName(name);
        return object.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Nome: " + name + ", Tipo: " + Coordinates.class.getName()));
    }

	@Override
    public List<Coordinates> findByParams(Float coordinateX, Float coordinateY, Float distance) {
        List<Coordinates> pointsOfInterest = new ArrayList<>();

        List<Coordinates> points = findAllPoints();

        for (Coordinates point : points) {
            double check = LocateUtils.distanceCalculation(coordinateX, coordinateY, point.getCoordinateX(),
                    point.getCoordinateY());
            if (Double.compare(check, distance.doubleValue()) < 0) {
                pointsOfInterest.add(point);
            }
        }
        return pointsOfInterest;
    }

	@Override
    public CoordinatesDTO insert(CoordinatesDTO object) {
        Coordinates coordinate = new Coordinates(object.getName(), object.getCoordinateX(), object.getCoordinateY());

        coordinatesRepository.save(coordinate);

        CoordinatesDTO coordinatesDTO = new CoordinatesDTO();
        coordinatesDTO.convert(coordinate);
        return coordinatesDTO;
    }

	@Override
    public void deleteById(Long id) {
        try {
            coordinatesRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

	@Override
    public Coordinates update(Long id, Coordinates objeto) {
        try {
            Coordinates entity = coordinatesRepository.getReferenceById(id);
            updateDataDTO(entity, objeto);
            return coordinatesRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

	@Override
	public void updateDataDTO(Coordinates newObject, Coordinates object) {
        newObject.setName(object.getName());
        newObject.setCoordinateX(object.getCoordinateX());
        newObject.setCoordinateY(object.getCoordinateY());
    }
}