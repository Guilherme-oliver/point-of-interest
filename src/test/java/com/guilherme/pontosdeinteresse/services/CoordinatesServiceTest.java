package com.guilherme.pontosdeinteresse.services;

import com.guilherme.pontosdeinteresse.entities.Coordinates;
import com.guilherme.pontosdeinteresse.repositories.CoordinatesRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CoordinatesServiceTest {

    @InjectMocks
    private CoordinatesService coordinatesService;

    @Mock
    private CoordinatesRepository coordinatesRepository;

    @Test
    void whenFindAllPoints_shouldReturnCoordinates() {

        List<Coordinates> mockedList = List.of(new Coordinates("Coord1", 2f, 6f));

        Mockito.when(coordinatesRepository.findAll()).thenReturn(mockedList);

        List<Coordinates> coordinatesList = coordinatesService.findAllPoints();

        Assertions.assertThat(coordinatesList).isNotEmpty();
        //Assertions.assertThat(coordinatesList.get(0).getName()).isEqualTo("Coord1");
    }

}
