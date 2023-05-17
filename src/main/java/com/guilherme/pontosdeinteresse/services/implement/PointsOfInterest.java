package com.guilherme.pontosdeinteresse.services.implement;

import java.util.List;

import com.guilherme.pontosdeinteresse.entities.Coordinates;
import com.guilherme.pontosdeinteresse.entities.dto.CoordinatesDTO;

public interface PointsOfInterest {

	List<Coordinates> findAllPoints();

	Coordinates findById(Long id);

	Coordinates findByName(String name);

	List<Coordinates> findByParams(Float coordinateX, Float coordinateY, Float distance);

	CoordinatesDTO insert(CoordinatesDTO object);

	void deleteById(Long id);

	Coordinates update(Long id, Coordinates objeto);

	void updateDataDTO(Coordinates newObject, Coordinates object);
}
