package com.maths.linearalgebra;

public record Matrix2x2(double a, double b, double c, double d) {

    public Matrix2x2 transform(Matrix2x2 transformation) {
        Matrix2x2 m2 = this;

        @SuppressWarnings("UnnecessaryLocalVariable")
        Matrix2x2 m1 = transformation;

        double a = (m1.a * m2.a) + (m1.c * m2.b);
        double c = (m1.a * m2.c) + (m1.c * m2.d);
        double b = (m1.b * m2.a) + (m1.d * m2.b);
        double d = (m1.b * m2.c) + (m1.d * m2.d);

        return new Matrix2x2(
            a, b,
            c, d
        );
    }
}
