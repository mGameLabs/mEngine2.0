package com.mgamelabs.mengine.util.math;

public class Matrix3f {

    public float[] matrix;

    public Matrix3f() {

        matrix = new float[] {
                1, 0, 0,
                0, 1, 0,
                0, 0, 1
        };

    }

    public Matrix3f(float[] matrix) {

        if (matrix.length != 9) throw new IllegalArgumentException();

        this.matrix = matrix;

    }

    public Matrix3f(Matrix3f clone) {

        this.matrix = clone.matrix;

    }

    public Vector3f multiply(Vector3f vector) {

        return new Vector3f(
                vector.x * matrix[0] + vector.y * matrix[1] + vector.z * matrix[2],
                vector.x * matrix[3] + vector.y * matrix[4] + vector.z * matrix[5],
                vector.x * matrix[6] + vector.y * matrix[7] + vector.z * matrix[8]
        );

    }

}
