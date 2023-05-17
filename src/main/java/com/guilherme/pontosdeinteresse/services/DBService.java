package com.guilherme.pontosdeinteresse.services;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

import com.guilherme.pontosdeinteresse.entities.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.pontosdeinteresse.repositories.CoordinatesRepository;

@Service
public class DBService {
	
    @Autowired
    private CoordinatesRepository coordinatesRepository;

    public void instantiateTestDatabase() throws ParseException {

        Locale.setDefault(Locale.US);

        Coordinates coor1 = new Coordinates("Northeast", 15.148F, -37.898F);
        coor1.setName("North");
        coor1.setCoordinateX(16.148F);
        coor1.setCoordinateY(-38.898F);

        Coordinates coor2 = new Coordinates("Southeast", -42.666F, 84.007F);
        coor2.setName("South");
        coor2.setCoordinateX(-43.666F);
        coor2.setCoordinateY(85.007F);

        Coordinates coor3 = new Coordinates("South-west", 20.205F, 10.704F);
        coor3.setName("East");
        coor3.setCoordinateX(21.205F);
        coor3.setCoordinateY(11.704F);

        Coordinates coor4 = new Coordinates("Midwest", -87.888F, -76.777F);
        coor4.setName("West");
        coor4.setCoordinateX(-88.888F);
        coor4.setCoordinateY(-77.777F);

        coordinatesRepository.saveAll(Arrays.asList(coor1, coor2, coor3, coor4));
    }
}
