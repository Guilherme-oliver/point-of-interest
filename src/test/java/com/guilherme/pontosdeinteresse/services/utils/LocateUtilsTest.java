package com.guilherme.pontosdeinteresse.services.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocateUtilsTest {

    private LocateUtils locateUtils;

    @Test
    void calculateDistance() {
        double resultado = locateUtils.distanceCalculation(2.2, 3.1, 5, 5);

        Assertions.assertThat(resultado).isPositive();
    }
}
