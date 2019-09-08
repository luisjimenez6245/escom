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
    public double[] operateRow(double[] row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double[] solveMatrix(double[][] matrix, double[] dependent) {
        double[] res = new double[matrix[0].length];
        if (isSquareMatrix(matrix)) {
            res = dotMatrix(dependent, getInverseMatrix(matrix));
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
        throw new Error("Matriz no tiene inversa, el determinante es 0");

    }

    @Override
    public double[][] getInverseMatrixLargeBatch(double[][] matrix) {
        if (isSquareMatrix(matrix)) {
            int dimen = matrix.length;
            return getInverseMatrixLargeBatch(matrix, dimen);
        }
        throw new Error("Matriz no valida");
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
        throw new Error("Matrices no validas");
    }

    @Override
    public double[][] getAdjointMatrix(double[][] matrix) throws Error {
        if (isSquareMatrix(matrix)) {
            int dimen = matrix.length;
            double res[][] = new double[dimen][dimen];
            for (int i = 0; i < dimen; ++i) {
                for (int j = 0; j < dimen; ++j) {
                    res[j][i] = matrix[i][j];
                }
            }
            return res;
        }
        throw new Error("");
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

    public double[][] swapRows(double[][] matrix, int from, int to) {
        double res[][] = cloneMatrix(matrix);
        for (int i = 0; i < matrix[0].length; ++i) {
            res[to][i] = matrix[from][i];
            res[from][i] = matrix[to][i];
        }
        return res;
    }

    public double[][] swapRows(double[][] matrix, double[] row, int to) {
        double res[][] = cloneMatrix(matrix);
        res[to] = row;
        return res;
    }

    public double[][] swapCols(double[][] matrix, int from, int to) {
        double res[][] = cloneMatrix(matrix);
        for (int i = 0; i < matrix[0].length; ++i) {
            res[from][i] = matrix[i][to];
        }
        return res;
    }

    public double[][] swapCols(double[][] matrix, double[] col, int to) {
        double res[][] = cloneMatrix(matrix);
        for (int i = 0; i < matrix[0].length; ++i) {
            res[i][to] = col[i];
        }
        return res;
    }

    private boolean MatrixInfiniteSolutions(double[][] matrix, double[] dependent) {

        return false;
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
}

interface sol {

    void printMatrix(double[][] matrix);

    void printMatrix(double[] matrix);

    double[][] getInverseMatrixLargeBatch(double[][] matrix) throws Error;

    boolean isSquareMatrix(double[][] matrix);

    double[][] getAdjointMatrix(double[][] matrix) throws Error;

    double[] dotMatrix(double[] matrixA, double[][] matrixB) throws Error;

    double[] dotMatrix(double[][] matrixA, double[] matrixB) throws Error;

    double[] operateRow(double[] row);

    double determinant(double[][] matrix);

    double[][] getCofactorsMatrix(double[][] matrix) throws Error;

    double[] solveMatrix(double[][] matrix, double[] dependent) throws Error;

    double[][] dotMatrix(double[][] matrixA, double[][] matrixB) throws Error;

    double[][] getInverseMatrix(double[][] matrix) throws Error;
}
