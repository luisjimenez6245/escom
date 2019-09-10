/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_solver;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lusi
 */
public class solver implements sol {

    private static final double EPSILON = 1e-10;

    @Override
    public boolean isSquareMatrix(double[][] matrix) {
        int dimen = matrix.length;
        for (double[] r : matrix) {
            if (r.length != dimen) {
                return false;
            }
        }
        return true;
    }

    @Override
    public double[] solveMatrix(double[][] matrix, double[] dependent) {
        double[] res = new double[matrix[0].length];
        if (isSquareMatrix(matrix)) {
            double determinant = determinant(matrix);
            if (determinant == 0) {
                
            } else {
                res = dotMatrix(dependent, getInverseMatrix(matrix, determinant, matrix.length));
            }
        } else {

        }
        return res;
    }

    @Override
    public double[][] getInverseMatrix(double[][] matrix) {
        if (isSquareMatrix(matrix)) {
            int dimen = matrix.length;
            double determinant = determinant(matrix);
            return getInverseMatrix(matrix, determinant, dimen);
        }
        throw new Error("Matriz no valida");
    }

    private double[][] getInverseMatrix(double[][] matrix, double determinant, int dimen) {
        if (determinant != 0) {
            if (dimen == 2) {
                return getInverseMatrixLargeBatch(matrix, dimen);
            } else {
                double res[][] = new double[dimen][dimen];
                for (int i = 0; i < dimen; ++i) {
                    for (int j = 0; j < dimen; ++j) {
                        res[i][j] = determinant(getMatrix(matrix, i, j)) / determinant;
                    }
                }
                return res;
            }
        }
        throw new UnsupportedOperationException("Matriz no tiene inversa, el determinante es 0");
    }

    @Override
    public double[][] getInverseMatrixLargeBatch(double[][] matrix) {
        if (isSquareMatrix(matrix)) {
            int dimen = matrix.length;
            return getInverseMatrixLargeBatch(matrix, dimen);
        }
        throw new UnsupportedOperationException("Matriz no valida");
    }

    private double[][] getInverseMatrixLargeBatch(double[][] matrix, int dimen) {
        matrix = getMinorsMatrix(matrix);
        matrix = getCofactorsMatrix(matrix);
        matrix = getAdjointMatrix(matrix);
        double determinant = determinant(matrix);
        double res[][] = new double[dimen][dimen];
        for (int i = 0; i < dimen; ++i) {
            for (int j = 0; j < dimen; ++j) {
                res[i][j] = matrix[i][j] / determinant;
            }
        }
        return res;
    }

    @Override
    public void printMatrix(double[][] matrix) {
        for (double[] arr : matrix) {
            for (double n : arr) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public void printMatrix(double[] matrix) {
        for (double n : matrix) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }

    @Override
    public double[][] dotMatrix(double[][] matrixA, double[][] matrixB) throws Error {
        if (matrixA[0].length == matrixB.length) {
            double res[][] = new double[matrixA.length][matrixB[0].length];
            double toWork[] = new double[matrixB.length];
            for (int i = 0; i < res[0].length; ++i) {
                for (int j = 0; j < res.length; ++j) {
                    for (int k = 0; k < toWork.length; ++k) {
                        toWork[k] = matrixB[k][i];
                    }
                    res[j][i] = dotMatrix(matrixA[j], toWork);
                }
            }
            return res;
        }
        throw new UnsupportedOperationException("Matrices no validas");
    }

    @Override
    public double[][] getAdjointMatrix(double[][] matrix) {
        double res[][] = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    @Override
    public double[][] getCofactorsMatrix(double[][] matrix) throws Error {
        double res[][] = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                res[j][i] = (Math.pow(-1, i + j) * matrix[i][j]);
            }
        }
        return res;
    }

    @Override
    public double[] dotMatrix(double[][] matrixA, double[] matrixB) throws Error {
        double toWork[][] = new double[1][matrixB.length];
        for (int i = 0; i < matrixB.length; ++i) {
            toWork[0][i] = matrixB[i];
        }
        return dotMatrix(matrixA, toWork)[0];
    }

    @Override
    public double[] dotMatrix(double[] matrixA, double[][] matrixB) throws Error {
        double toWork[][] = new double[1][matrixA.length];
        for (int i = 0; i < matrixA.length; ++i) {
            toWork[0][i] = matrixA[i];
        }
        return dotMatrix(toWork, matrixB)[0];
    }

    @Override
    public double determinant(double[][] matrix) throws Error {
        if (isSquareMatrix(matrix)) {
            int dimen = matrix.length;
            double res = 0;
            if (dimen > 2) {
                for (int i = 0; i < dimen; ++i) {
                    double toWork[][] = getMatrix(matrix, i, 0);
                    res += Math.pow(-1, i) * matrix[0][i] * (determinant(toWork));
                }
            } else {
                if (dimen == 2) {
                    res = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
                } else {
                    res = matrix[0][0];
                }
            }
            return res;
        }
        throw new Error("La matriz no es valida.");
    }

    private boolean isMultiple(double[] rowA, double[] rowB) {
        for (int i = 0; i < rowA.length; ++i) {
            if (!isMultiple(rowA[i], rowB[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isMultiple(double a, double b) {
        if (a <= b) {
            return a % b == 0;
        } else {
            return b % a == 0;
        }
    }

    private int searchForZeros(double[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            if (isZeroRow(matrix[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean isZeroRow(double[] row) {
        for (double d : row) {
            if (d != 0) {
                return false;
            }
        }
        return true;
    }

    private double[][] cloneMatrix(double[][] matrix) {
        double res[][] = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                res[i][j] = matrix[i][j];
            }
        }
        return res;
    }

    private double[] cloneMatrix(double[] matrix) {
        double res[] = new double[matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            res[i] = matrix[i];
        }
        return res;
    }

    private double[][] getMinorsMatrix(double[][] matrix) {
        int dimen = matrix.length;
        double res[][] = new double[dimen][dimen];
        for (int i = 0; i < dimen; ++i) {
            for (int j = 0; j < dimen; ++j) {
                res[i][j] = determinant(getMatrix(matrix, i, j));
            }
        }
        return res;
    }

    private double dotMatrix(double[] matrixA, double[] matrixB) {
        double res = 0;
        for (int i = 0; i < matrixA.length; ++i) {
            res += matrixA[i] * matrixB[i];
        }
        return res;
    }

    private double[][] getMatrix(double[][] matrix, int col, int row) {
        int dimen = matrix.length;
        double res[][] = new double[dimen - 1][dimen - 1];
        int iIterator = 0, jIterator;
        for (int i = 0; i < dimen; ++i) {
            if (i != row) {
                jIterator = 0;
                for (int j = 0; j < dimen; ++j) {
                    if (j != col) {
                        res[iIterator][jIterator] = matrix[i][j];
                        ++jIterator;
                    }
                }
                ++iIterator;
            }
        }
        return res;
    }

    private double[] swapItem(double[] dependent, int to, int from) {
        double[] res = cloneMatrix(dependent);
        res[to] = dependent[from];
        res[from] = dependent[to];
        return res;
    }
    


    private double[][] swapRows(double[][] matrix, int from, int to) {
        double res[][] = cloneMatrix(matrix);
        for (int i = 0; i < matrix[0].length; ++i) {
            res[to][i] = matrix[from][i];
            res[from][i] = matrix[to][i];
        }
        return res;
    }

    public double[][] swapCols(double[][] matrix, int from, int to) {
        double res[][] = cloneMatrix(matrix);
        for (int i = 0; i < matrix[0].length; ++i) {
            res[from][i] = matrix[i][to];
        }
        return res;
    }

    public Equation operateMatrix(Equation eq) {
        Equation res = new Equation();
        int n = eq.dependent.length;
        for (int p = 0; p < n; p++) {
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(eq.matrix[i][p]) > Math.abs(eq.matrix[max][p])) {
                    max = i;
                }
            }
            eq.matrix = swapRows(eq.matrix, p, max);
            eq.dependent = swapItem(eq.dependent, p, max);

            if (Math.abs(eq.matrix[p][p]) <= EPSILON) {
                throw new ArithmeticException("Matrix is singular or nearly singular");
            }
            for (int i = p + 1; i < n; i++) {
                double alpha = eq.matrix[i][p] / eq.matrix[p][p];
                eq.dependent[i] -= alpha * eq.dependent[p];
                for (int j = p; j < n; j++) {
                    eq.matrix[i][j] -= alpha * eq.matrix[p][j];
                }
            }
            printEquation(eq);
        }
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += eq.matrix[i][j] * x[j];
            }
            x[i] = (eq.dependent[i] - sum) / eq.matrix[i][i];
        }
        eq.dependent = x;
        printEquation(eq);

        return res;
    }

    @Override
    public double[] solveMatrixLargeBacth(double[][] matrix, double[] dependent) throws Error {
        operateMatrix(Equation.build(matrix, dependent));
        return dependent;
    }

    private void printEquation(Equation eq) {
        System.out.println("dependent:");
        printMatrix(eq.dependent);
        System.out.println("matrix:");
        printMatrix(eq.matrix);

    }

    public boolean isScalonadeMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            if ((i - 1) >= 0) {
                for (int j = 0; j < i; ++j) {
                    if (matrix[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

class Equation {

    double[][] matrix;
    double[] dependent;

    public Equation() {
    }

    public static Equation build(double[][] matrix, double[] dependent) {
        Equation res = new Equation();
        res.matrix = matrix;
        res.dependent = dependent;
        return res;
    }
;

}

class Operation {

    boolean isTranslation = false;
    boolean isSum = false;
    double operator = 0;
    int row = 0;
    int to = 0;
}

interface sol {

    void printMatrix(double[][] matrix);

    void printMatrix(double[] matrix);

    double[][] getInverseMatrixLargeBatch(double[][] matrix) throws Error;

    double[] solveMatrixLargeBacth(double[][] matrix, double[] dependent) throws Error;

    boolean isSquareMatrix(double[][] matrix);

    double[][] getAdjointMatrix(double[][] matrix) throws Error;

    double[] dotMatrix(double[] matrixA, double[][] matrixB) throws Error;

    double[] dotMatrix(double[][] matrixA, double[] matrixB) throws Error;

    double determinant(double[][] matrix);

    double[][] getCofactorsMatrix(double[][] matrix) throws Error;

    double[] solveMatrix(double[][] matrix, double[] dependent) throws Error;

    double[][] dotMatrix(double[][] matrixA, double[][] matrixB) throws Error;

    double[][] getInverseMatrix(double[][] matrix) throws Error;
}
