package com.maths.linearalgebra.tests;

import com.maths.linearalgebra.Matrix2x2;
import com.maths.linearalgebra.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2Tests {
    @Test
    void transform_identityMatrix_returnsSameVector() {
        /*
        Vector:
        x: 12
        y: 42

        Matrix:
           i j
        x: 1 0
        y: 0 1

        x(i-hat) + y(j-hat)
        ...
        x = xa + yb = ?
        y = xc + yd = ?
        ...
        x = (12 * 1) + (42 * 0) = 12
        y = (42 * 0) + (42 * 1) = 42
        */

        var input = new Vector2(12, 42);
        var expected = new Vector2(12, 42);
        var actual = input.transform(new Matrix2x2(
            1, 0,
            0, 1));

        assertEquals(expected, actual);
    }

    @Test
    void transform_90DegreesCounterClockwise_returnsRotatedVector() {
        /*
        Vector:
        x: 1
        y: 2

        Matrix:
           i  j
        x: 0 -1
        y: 1  0

        x(i-hat) + y(j-hat)
        ...
        x = xa + yb = ?
        y = xc + yd = ?
        ...
        x = (1 * 0) + (2 * -1) = -2
        y = (1 * 1) + (2 *  0) =  1
        */

        var input = new Vector2(1, 2);
        var expected = new Vector2(-2, 1);
        var actual = input.transform(new Matrix2x2(
           0, -1,
           1, 0
        ));

        assertEquals(expected, actual);
    }

    @Test
    void transform_someMatrix_returnsTransformedVector() {
        /*
        Vector:
        x: 453
        y: 245

        Matrix:
           i  j
        x: 4  12
        y: 8  -3

        x(i-hat) + y(j-hat)
        ...
        x = xa + yb = ?
        y = xc + yd = ?
        ...
        x = (453 * 4) + (245 * 12) = 4752
        y = (453 * 8) + (245 * -3) = 2889
        */

        var input = new Vector2(453, 245);
        var expected = new Vector2(4752, 2889);
        var actual = input.transform(new Matrix2x2(
           4, 12,
           8, -3
        ));

        assertEquals(expected, actual);
    }
}
