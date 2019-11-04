/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.math.BigDecimal;

/**
 *
 * @author lusi
 */
public class MatrixController {

    private static final double EPSILON = 1e-10;
    public String pasos = "";

    public double[] solveMatrix(double[][] matrix, double[] dependent) {
        int n = dependent.length;
        pasos += "Matriz original: \n\n";
        pasos += textMatrix(joinMatrix(matrix, dependent));
        for (int p = 0; p < n; p++) {
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(matrix[i][p]) > Math.abs(matrix[max][p])) {
                    max = i;
                }
            }
            pasos += "Se cambian filas " + p + " a la fila: " + max + " \n\n";
            double[] temp = matrix[p];
            matrix[p] = matrix[max];
            matrix[max] = temp;
            double t = dependent[p];
            dependent[p] = dependent[max];
            dependent[max] = t;
            pasos += textMatrix(joinMatrix(matrix, dependent));
            if (Math.abs(matrix[p][p]) <= EPSILON) {
                throw new ArithmeticException("Los resultados son incalculables.");
            }
            for (int i = p + 1; i < n; i++) {
                double alpha = matrix[i][p] / matrix[p][p];
                dependent[i] -= alpha * dependent[p];
                for (int j = p; j < n; j++) {
                    matrix[i][j] -= alpha * matrix[p][j];
                }
                pasos += "Se opera la matriz: \n\n";
                pasos += textMatrix(joinMatrix(matrix, dependent));
            }
        }
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += matrix[i][j] * x[j];
            }
            x[i] = (dependent[i] - sum) / matrix[i][i];
        }
        return x;

    }

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

    public double[] dotMatrix(double[][] matrixA, double[] matrixB) throws Error {
        double toWork[][] = new double[1][matrixB.length];
        toWork[0] = matrixB;
        return dotMatrix(toWork, matrixA)[0];
    }

    public double[] dotMatrix(double[] matrixA, double[][] matrixB) throws Error {
        double toWork[][] = new double[1][matrixA.length];
        for (int i = 0; i < matrixA.length; ++i) {
            toWork[0][i] = matrixA[i];
        }
        return dotMatrix(toWork, matrixB)[0];
    }

    public double[][] getInverseMatrix(double[][] matrix) throws Exception {
        if (isSquareMatrix(matrix)) {
            int dimen = matrix.length;
            return getInverseMatrixLargeBatch(matrix, dimen);
        }
        throw new UnsupportedOperationException("Matriz no valida");
    }

    public boolean isSquareMatrix(double[][] matrix) {
        int dimen = matrix.length;
        for (double[] r : matrix) {
            if (r.length != dimen) {
                return false;
            }
        }
        return true;
    }

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

    private double[][] getInverseMatrixLargeBatch(double[][] matrix, int dimen) throws Exception {
        double determinant = determinant(matrix);
        if (determinant != 0) {
            matrix = getCofactorMatrix(matrix);
            matrix = getAdjointMatrix(matrix);
            double res[][] = new double[dimen][dimen];
            for (int i = 0; i < dimen; ++i) {
                for (int j = 0; j < dimen; ++j) {
                    res[i][j] = matrix[i][j] / determinant;
                }
            }
            return res;
        }
        throw new Exception("La matriz no es tiene inversa.");
    }

    public double[][] getAdjointMatrix(double[][] matrix) {
        double res[][] = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

    private double[][] getCofactorMatrix(double[][] matrix) {
        int dimen = matrix.length;
        double res[][] = new double[dimen][dimen];
        for (int i = 0; i < dimen; ++i) {
            for (int j = 0; j < dimen; ++j) {
                res[i][j] = (Math.pow(-1, i + j) * determinant(getMatrix(matrix, j, i)));
            }
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

    private double dotMatrix(double[] matrixA, double[] matrixB) {
        double res = 0;
        for (int i = 0; i < matrixA.length; ++i) {
            res += workDecimals(matrixA[i] * matrixB[i]);
        }
        if (res <= 1e-15) {
            res = workDecimals(res);
        }
        return res;
    }

    private double workDecimals(double res) {
        BigDecimal toWork = BigDecimal.valueOf(res);
        return (double) toWork.floatValue();
    }

    public double[][] getIdentityMatrix(int dimen) {
        double res[][] = new double[dimen][dimen];
        for (int i = 0; i < dimen; ++i) {
            res[i][i] = 1;
        }
        return res;
    }

    public String textMatrix(double[][] matrix) {
        String res = "";
        for (double[] arr : matrix) {
            for (double n : arr) {
                res += (n + "\t");
            }
            res += "\n";
        }
        return res;
    }

    public double[][] joinMatrix(double[][] matrixA, double[] matrixB) {
        double[][] res = new double[matrixA.length][matrixA[0].length + 1];
        for (int i = 0; i < matrixA.length; ++i) {
            for (int j = 0; j < matrixA[0].length; ++j) {
                res[i][j] = matrixA[i][j];
            }
        }
        for (int j = 0; j < matrixA[0].length; ++j) {
            res[j][matrixA[0].length] = matrixB[j];
        }
        return res;
    }

    public void printMatrix(double[][] matrix) {
        for (double[] arr : matrix) {
            for (double n : arr) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }

    public void printMatrix(double[] matrix) {
        for (double n : matrix) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }

}
