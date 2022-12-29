package com.maths.linearalgebra;

public record Vector2(double x, double y) {

    public Vector2 transform(Matrix2x2 transformation) {
        Vector2 v = this;

        @SuppressWarnings("UnnecessaryLocalVariable")
        Matrix2x2 m = transformation;

        double x = (v.x * m.a()) + (v.y * m.b());
        double y = (v.x * m.c()) + (v.y * m.d());

        return new Vector2(x, y);
    }
}
