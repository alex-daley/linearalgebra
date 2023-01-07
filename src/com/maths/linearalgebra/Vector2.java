package com.maths.linearalgebra;

/**
 * Represents a magnitude/length and a 2D direction.
 * Think of this as an arrow starting at the origin on a 2D cartesian grid (or at the tip of another vector
 * on such a grid).
 */
public record Vector2(double x, double y) {
    /**
     * Figure out where a vector ends up after transforming it by the specified 2D matrix.
     *
     * A way to think about this is we're scaling the x and y components of the vector by the matrix's basis vectors.
     * Here i-hat refers to the "right" basis vector and j-hat refers to the "up" basis vector.
     *
     *     i-hat j-hat    v
     * x: [  a     b  ] [ x ]
     * y: [  c     d  ] [ y ]
     *
     * ... So to get the scaled i-hat, multiply i-hat by the vector's x component.
     * Transformed i-hat x = xa
     * Transformed i-hat y = xc
     *
     * ... So to get the scaled j-hat, multiply j-hat by the vector's y component.
     * Transformed j-hat x = yb
     * Transformed j-hat y = yd
     *
     * ... We can then sum i-hat and j-hat to get the x and y components of the transformed vector.
     *     i-hat   j-hat
     * x: [  xa  +  yb  ]
     * y: [  xc  +  yd  ]
     *
     * ... In short:
     * x(i-hat) + y(j-hat)
     */
    public Vector2 transform(Matrix2x2 transformation) {
        Vector2 v = this;
        @SuppressWarnings("UnnecessaryLocalVariable") Matrix2x2 m = transformation;

        double x = (v.x * m.a()) + (v.y * m.b());
        double y = (v.x * m.c()) + (v.y * m.d());

        return new Vector2(x, y);
    }
}
