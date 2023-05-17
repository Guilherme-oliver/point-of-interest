package com.guilherme.pontosdeinteresse.entities.dto;

import com.guilherme.pontosdeinteresse.entities.Coordinates;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoordinatesDTO {

    @NotBlank
    private String name;

    @NotNull
    private Float coordinateX, coordinateY;

    public CoordinatesDTO convert(Coordinates coordinates) {
        this.name = coordinates.getName();
        this.coordinateX = coordinates.getCoordinateX();
        this.coordinateY = coordinates.getCoordinateY();
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Float coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Float getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Float coordinateY) {
        this.coordinateY = coordinateY;
    }
}
