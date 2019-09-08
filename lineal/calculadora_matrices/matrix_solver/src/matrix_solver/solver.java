/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_solver;

/**
 *
 * @author lusi
 */
public class solver implements sol {

    @Override
    public boolean isMultiple(float[] rowA, float[] rowB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSquareMatrix(float[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    @Override
    public float[] operateRow(float[] row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float[] resolveMatrix(float[][] matrix, float[] dependent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float[][] getInverseMatrix(float[][] matrix) {
        if (isSquareMatrix(matrix)) {
            float res[][] = new float[matrix.length][matrix[0].length];
            return res;
        }
        return null;
    }

    @Override
    public void printMatrix(float[][] matrix) {
        for (float[] arr : matrix) {
            for (float n : arr) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public void printMatrix(float[] matrix) {
        for (float n : matrix) {
            System.out.print(n + "\t");
        }
    }

    @Override
    public float[][] dotMatrix(float[][] matrixA, float[][] matrixB) {
        if (matrixA.length == matrixB[0].length) {
            float res[][] = new float[matrixA.length][matrixB[0].length];
            float toWork[] = new float[matrixB.length];
            for (int i = 0; i < res.length; ++i) {
                for (int j = 0; j < res[0].length; ++j) {
                    for (int k = 0; k < toWork.length; ++k) {
                        toWork[k] = matrixB[i][k];
                    }
                    res[i][j] = dotMatrix(matrixA[i], toWork);
                }
            }
        }
        return null;
    }

    @Override
    public float[] dotMatrix(float[][] matrixA, float[] matrixB) {
        float toWork[][] = new float[1][matrixB.length];
        for (int i = 0; i < matrixB.length; ++i) {
            toWork[0][i] = matrixB[i];
        }
        return dotMatrix(matrixA, toWork)[0];
    }

    private float dotMatrix(float[] matrixA, float[] matrixB) {
        float res = 0;
        for (int i = 0; i < matrixA.length; ++i) {
            res += matrixA[i] * matrixB[i];
        }
        return res;
    }

}

interface sol {

    void printMatrix(float[][] matrix);

    void printMatrix(float[] matrix);

    boolean isMultiple(float[] rowA, float[] rowB);

    boolean isSquareMatrix(float[][] matrix);

    float[] dotMatrix(float[][] matrixA, float[] matrixB);

    float[] operateRow(float[] row);

    float[] resolveMatrix(float[][] matrix, float[] dependent);

    float[][] dotMatrix(float[][] matrixA, float[][] matrixB);

    float[][] getInverseMatrix(float[][] matrix);
}
