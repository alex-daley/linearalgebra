package com.maths.linearalgebra.tests;

import com.maths.linearalgebra.Matrix3x3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix3x3Tests {

    @Test
    void transform_twoDifferentMatrices_returnsCorrectProduct() {
        var m1 = new Matrix3x3(
            0, 2, 4,
            1, 0, 1,
            0, 1, 2
        );

        var m2 = new Matrix3x3(
            1, -2, 3,
            1, 0, 1,
            2, 3, 2
        );

        var result = m1.transform(m2);

        // (0 * 1) + (1 * -2) + (0 * 3) = -2
        assertEquals(-2, result.a());

        // (0 * 1) + (1 * 0) + (0 * 1) = 0
        assertEquals(0, result.d());

        // (0 * 2) + (1 * 3) + (0 * 2) = 3
        assertEquals(3, result.g());

        // (2 * 1) + (0 * -2) + (1 * 3) = 5
        assertEquals(5, result.b());

        // (2 * 1) + (0 * 0) + (1 * 1) = 3
        assertEquals(3, result.e());

        // (2 * 2) + (0 * 3) + (1 * 2) = 6
        assertEquals(6, result.h());

        // (4 * 1) + (1 * -2) + (2 * 3) = 8
        assertEquals(8, result.c());

        // (4 * 1) + (1 * 0) + (2 * 1) = 6
        assertEquals(6, result.f());

        // (4 * 2) + (1 * 3) + (2 * 2) = 15
        assertEquals(15, result.i());
    }
}
