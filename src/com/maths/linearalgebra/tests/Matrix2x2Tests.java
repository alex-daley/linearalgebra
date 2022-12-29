package com.maths.linearalgebra.tests;

import com.maths.linearalgebra.Matrix2x2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Matrix2x2Tests {

    @Test
    void transform_twoDifferentMatrices_returnsCorrectProduct() {
        /*
        m2 m1 (right to left)

        m2 (the original matrix)
           i j
        x: 2 0
        y: 0 1

        m1 (the transformation)
           i j
        x: 4 2
        y: 1 1

        m2    m1       i j
        [a b] [e f] = [ea + gb, fa + hb]
        [c d] [g h] = [ec + gd, fc + hd]

        m2    m1
        [2 0] [4 2] = [4(2) + 1(0), 2(2) + 1(0)] = [8 4]
        [0 1] [1 1] = [4(0) + 1(1), 2(0) + 1(1)] = [1 1]

        ...to get i-hat
        [2 0] [4] = [4][2] + [1][0]
        [0 1] [1] = [4][0] + [1][1]

        ...to get j-hat
        [2 0] [2] = [2][2] + [1][0]
        [0 1] [1] = [2][0] + [1][1]
        */

        var m2 = new Matrix2x2(
          2, 0,
          0, 1
        );

        var m1 = new Matrix2x2(
          4, 2,
          1, 1
        );

        var expected = new Matrix2x2(
            8, 4,
            1, 1
        );

        var result = m2.transform(m1);

        assertEquals(expected, result);
    }
}
