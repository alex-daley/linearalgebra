package com.maths.linearalgebra.tests;

import com.maths.linearalgebra.Matrix2x2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix2x2Tests {

    @Test
    void transform_twoDifferentMatrices_returnsCorrectProduct() {
        Matrix2x2 m1 = new Matrix2x2(
            1, -2,
            1, 0
        );

        Matrix2x2 m2 = new Matrix2x2(
          0, 2,
          1, 0
        );

        Matrix2x2 composition = m1.transform(m2);

        // (1 * 0) + (1 * 2) == 2
        assertEquals(2, composition.a());

        // (1 * 1) + (1 * 0) == 1
        assertEquals(1, composition.c());

        // (-2 * 0) + (0 * 2) == 0
        assertEquals(0, composition.b());

        // (-2 * 1) + (0 * 0) == -2
        assertEquals(-2, composition.d());
    }
}
