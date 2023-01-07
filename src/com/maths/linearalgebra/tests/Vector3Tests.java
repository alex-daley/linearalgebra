package com.maths.linearalgebra.tests;

import com.maths.linearalgebra.Matrix3x3;
import com.maths.linearalgebra.Vector3;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector3Tests {
    @Test
    void transform_someMatrix_returnsTransformedVector() {
        var m = new Matrix3x3(
          0, 1, 2,
          3, 4, 5,
          6, 7, 8
        );

        var v = new Vector3(
          2,
          10,
          4
        );

        var result = v.transform(m);

        // (2 * 0) + (10 * 1) + (4 * 2) = 18
        assertEquals(18, result.x());

        // (2 * 3) + (10 * 4) + (4 * 5) = 66
        assertEquals(66, result.y());

        // (2 * 6) + (10 * 7) + (4 * 8) = 114
        assertEquals(114, result.z());
    }
}
