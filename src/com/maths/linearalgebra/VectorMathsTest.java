package com.maths.linearalgebra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorMathsTest {
    @Test
    void testVector2Transformation() {
        var matrix = new Matrix2x2(
             1, 3,
            -2, 0
        );

        var vector = new Vector2(
            -1,
             2
        );

        // 1(i-hat) + 2(j-hat)
        var expected = new Vector2(
            5,
            2
        );

        var actual = VectorMaths.transform(vector, matrix);

        assertEquals(expected, actual);
    }

    @Test
    void testMatrix2x2Transformation() {
        var m2 = new Matrix2x2(
          2, 1,
          4, 3
        );

        var m1 = new Matrix2x2(
          -1, 3,
           8, 6
        );

        // m2    m1       result
        // [2 1] [-1 3] = [? ?]
        // [4 3] [ 8 6]   [? ?]
        //
        // m1  m2    m1 m2    result
        // [-1][2] + [8][1] = [6  ?]
        //     [4]      [3]   [20 ?]
        //
        // m1  m2   m1 m2    result
        // [3][2] + [6][1] = [?  12]
        //    [4]      [3]   [?  30]

        var expected = new Matrix2x2(
            6, 12,
            20, 30
        );

        var actual = VectorMaths.transform(m2, m1);

        assertEquals(expected, actual);
    }
}
