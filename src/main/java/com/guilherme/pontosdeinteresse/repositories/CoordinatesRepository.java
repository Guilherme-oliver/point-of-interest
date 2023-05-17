package com.guilherme.pontosdeinteresse.repositories;

import java.util.List;
import java.util.Optional;

import com.guilherme.pontosdeinteresse.entities.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CoordinatesRepository extends JpaRepository<Coordinates, Long> {

    Optional<Coordinates> findByName(String name);

    @Query("SELECT u FROM Coordinates u WHERE u.coordinateX = ?1 and u.coordinateY = ?2")
    List<Coordinates> findByParams(Float coordinateX, Float coordinateY);
}