package com.guilherme.pontosdeinteresse.controller;

import com.guilherme.pontosdeinteresse.entities.dto.CoordinatesDTO;
import com.guilherme.pontosdeinteresse.entities.Coordinates;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.guilherme.pontosdeinteresse.services.CoordinatesService;

import java.util.List;

@RestController
@RequestMapping(value = "/ponto-de-interesse")
public class CoordinatesController {

    @Autowired
    private CoordinatesService coordinatesService;

    @GetMapping
    public ResponseEntity<List<Coordinates>> findAll() {
        List<Coordinates> list = coordinatesService.findAllPoints();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Coordinates> findById(@PathVariable Long id) {
        Coordinates objeto = coordinatesService.findById(id);
        return ResponseEntity.ok().body(objeto);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Coordinates> findByNome(@PathVariable String name) {
        Coordinates object = coordinatesService.findByName(name);
        return ResponseEntity.ok().body(object);
    }

    @GetMapping(value = "/params")
    public ResponseEntity<List<Coordinates>> findByParams(@RequestParam float coordX,
                                                          @RequestParam float coordY,
                                                          @RequestParam float distance) {
        List<Coordinates> nextPoint = coordinatesService.findByParams(coordX, coordY, distance);
        return ResponseEntity.ok(nextPoint);
    }

    @PostMapping
    public ResponseEntity<CoordinatesDTO> insert(@RequestBody @Valid CoordinatesDTO objeto) {
        return new ResponseEntity<>(coordinatesService.insert(objeto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        coordinatesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coordinates> update(@PathVariable Long id, @RequestBody Coordinates object) {
        object = coordinatesService.update(id, object);
        return ResponseEntity.ok().body(object);
    }
}