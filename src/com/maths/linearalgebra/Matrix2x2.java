package com.maths.linearalgebra;

/**
 * A 2D transformation matrix
 *
 * @param a The x component of the right basis vector (i-hat)
 * @param c The y component of the right basis vector (i-hat)
 * @param b The x component of the up basis vector (j-hat)
 * @param d The y component of the up basis vector (j-hat)
 */
public record Matrix2x2(double a, double b, double c, double d) {
    /**
     *
     * @param right The right basis vector
     * @param up The up basis vector
     */
    public Matrix2x2(Vector2 right, Vector2 up) {
        this(
            right.x(), up.x(),
            right.y(), up.y()
        );
    }
}
