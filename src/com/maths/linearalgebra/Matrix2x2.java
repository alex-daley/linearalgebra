package com.maths.linearalgebra;

/**
 * A matrix with two columns and two rows.
 *
 * @param a The x component of the right basis vector (i-hat)
 * @param c The y component of the right basis vector (i-hat)
 * @param b The x component of the up basis vector (j-hat)
 * @param d The y component of the up basis vector (j-hat)
 */
public record Matrix2x2(double a, double b, double c, double d) {
    /**
     * Figure out the basis vectors of a new matrix after applying a transformation on a transformation.
     * Imagine like, rotating a grid once, and then scaling it.
     *
     * We have two matrices - both of which describe a grid's basis vectors.
     * Here i-hat refers to the "right" basis vector and j-hat refers to the "up" basis vector.
     *
     *     m2             m1
     *     i-hat j-hat    i-hat j-hat
     * x: [  a     b  ]  [  e     f  ]
     * y: [  c     d  ]  [  g     h  ]
     *
     * m1 is the first transformation, and m2 is the second (what we want to apply on top of m1).
     * Note that we read from right-to-left.
     *
     * Because these matrices just store basis vectors, to figure out where the new basis vectors will
     * end up can be calculated by multiplying each basis vector by another matrix which represents the transformation.
     *
     * ... So the get the new i-hat, multiply m1's i-hat by m2.
     *     m2             m1         composition
     *     i-hat j-hat    i-hat      `i-hat
     * x: [  a     b  ]  [  e  ] = [ ea + gb ]
     * y: [  c     d  ]  [  g  ] = [ ec + gd ]
     *
     * ... So to get the new j-hat, multiply m1's j-hat by m2.
     *     m2             m1         composition
     *     i-hat j-hat   `j-hat      `j-hat
     * x: [  a     b  ]  [  f  ] = [ fa + hb ]
     * y: [  c     d  ]  [  h  ] = [ fc + hd ]
     *
     * ... We can then put the transformed i-hat and j-hat into a new matrix.
     *     m2             m1            composition
     *     i-hat j-hat    i-hat j-hat      i-hat     j-hat
     * x: [  a     b  ]  [  e     f  ] = [ ea + gb, fa + hb ]
     * y: [  c     d  ]  [  g     h  ] = [ ec + gd, fc + hd ]
     */
    public Matrix2x2 transform(Matrix2x2 transformation) {
        Matrix2x2 m1 = this;
        @SuppressWarnings("UnnecessaryLocalVariable")  Matrix2x2 m2 = transformation;

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
