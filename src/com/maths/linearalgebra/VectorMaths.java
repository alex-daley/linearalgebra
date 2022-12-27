package com.maths.linearalgebra;

public class VectorMaths {
    /**
     * Figure out where a vector ends up after transforming it by the specified matrix.
     */
    public static Vector2 transform(Vector2 vector, Matrix2x2 matrix) {
        // x(i-hat) + y(j-hat)
        // ...so
        // [a b] [x] = [x][a] + [y][b] = (x * a) + (y * b)
        // [c d] [y]      [c]      [d]   (x * c) + (y * d)

        var x = vector.x();
        var y = vector.y();
        var a = matrix.a();
        var b = matrix.b();
        var c = matrix.c();
        var d = matrix.d();

        return new Vector2(
            (x * a) + (y * b),
            (x * c) + (y * d)
        );
    }

    /**
     * Figure out the basis vectors of a new matrix after applying a transformation on a transformation.
     * Imagine like, rotating a grid once, and then scaling it.
     */
    @SuppressWarnings("GrazieInspection")
    public static Matrix2x2 transform(Matrix2x2 original, Matrix2x2 transformation) {
        // The first column is i-hat and the second is j-hat.

        // ...to get the new right basis vector "i-hat" (a and c - the first column of the new matrix).
        // m2    m1    m1 m2    m1 m2
        // [a b] [a] = [a][a] + [c][b]
        // [c d] [c]      [c]      [d]

        // ...to get the new up basis vector "j-hat" (b and d - the second column of the new matrix).
        // m2    m1    m1 m2    m1 m2
        // [a b] [b] = [b][a] + [d][b]
        // [c d] [d]      [c]      [d]
        //

        var m2 = original;
        var m1 = transformation;

        // "i-hat"
        var m3a = (m1.a() * m2.a()) + (m1.c() * m2.b());
        var m3c = (m1.a() * m2.c()) + (m1.c() * m2.d());

        // "j-hat"
        var m3b = (m1.b() * m2.a()) + (m1.d() * m2.b());
        var m3d = (m1.b() * m2.c()) + (m1.d() * m2.d());

        return new Matrix2x2(
            m3a, m3b,
            m3c, m3d
        );
    }
}
