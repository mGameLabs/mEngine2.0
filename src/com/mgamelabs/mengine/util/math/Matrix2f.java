package com.mgamelabs.mengine.util.math;

public class Matrix2f {

    public float[] matrix;

    public Matrix2f() {

        matrix = new float[] {
                1, 0, 0,
                0, 1, 0,
                0, 0, 1
        };

    }

    public Matrix2f(float[] matrix) {

        if (matrix.length != 4) throw new IllegalArgumentException();

        this.matrix = matrix;

    }

    public Matrix2f(Matrix3f clone) {

        this.matrix = clone.matrix;

    }

    public Vector2f multiply(Vector2f vector) {

        return new Vector2f(
                vector.x * matrix[0] + vector.y * matrix[1],
                vector.x * matrix[2] + vector.y * matrix[3]
        );

    }

}
