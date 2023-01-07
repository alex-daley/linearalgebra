package com.maths.linearalgebra;

public record Matrix3x3(
    double a, double b, double c,
    double d, double e, double f,
    double g, double h, double i
) {
    public Matrix3x3 transform(Matrix3x3 transformation) {
        Matrix3x3 m1 = this;

        //noinspection UnnecessaryLocalVariable
        Matrix3x3 m2 = transformation;

        // Figure out where m1's right basis vector ends up after transforming by m2.
        Vector3 iHat = new Vector3(
            (m1.a() * m2.a()) + (m1.d() * m2.b()) + (m1.g() * m2.c()),
            (m1.a() * m2.d()) + (m1.d() * m2.e()) + (m1.g() * m2.f()),
            (m1.a() * m2.g()) + (m1.d() * m2.h()) + (m1.g() * m2.i())
        );

        // Figure out where m1's up basis vector ends up after transforming by m2.
        Vector3 jHat = new Vector3(
            (m1.b() * m2.a()) + (m1.e() * m2.b()) + (m1.h() * m2.c()),
            (m1.b() * m2.d()) + (m1.e() * m2.e()) + (m1.h() * m2.f()),
            (m1.b() * m2.g()) + (m1.e() * m2.h()) + (m1.h() * m2.i())
        );

        // Figure out where m1's forward basis vector ends up after transforming by m2.
        Vector3 kHat = new Vector3(
            (m1.c() * m2.a()) + (m1.f() * m2.b()) + (m1.i() * m2.c()),
            (m1.c() * m2.d()) + (m1.f() * m2.e()) + (m1.i() * m2.f()),
            (m1.c() * m2.g()) + (m1.f() * m2.h()) + (m1.i() * m2.i())
        );

        return new Matrix3x3(
            iHat.x(), jHat.x(), kHat.x(),
            iHat.y(), jHat.y(), kHat.y(),
            iHat.z(), jHat.z(), kHat.z()
        );
    }
}
