package com.maths.linearalgebra;

public record Vector3(double x, double y, double z) {
    public Vector3 transform(Matrix3x3 transformation) {
        Vector3 v = this;

        //noinspection UnnecessaryLocalVariable
        Matrix3x3 m = transformation;

        return new Vector3(
            (v.x * m.a()) + (v.y * m.b()) + (v.z * m.c()),
            (v.x * m.d()) + (v.y * m.e()) + (v.z * m.f()),
            (v.x * m.g()) + (v.y * m.h()) + (v.z * m.i())
        );
    }
}
