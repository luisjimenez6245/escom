/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_solver;

import controllers.MatrixController;

/**
 *
 * @author lusi
 */
public class Matrix_solver {

    private static final double EPSILON = 1e-10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        solver s = new solver();
        double[][] AT = {{3, 0, 2}, {2, 0, -2}, {0, 1, 1}};
        double[][] A = {{0, 1, 1}, {2, 4, -2}, {0, 3, 15}};
        double[] b = {4, 2, 36};
        MatrixController control = new MatrixController();
        s.printMatrix(control.solveMatrix(A, b));
        s.printMatrix(lsolve(A, b));

    }

    public static double[] lsolve(double[][] A, double[] b) {
        int n = b.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;
            double t = b[p];
            b[p] = b[max];
            b[max] = t;

            // singular or nearly singular
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new ArithmeticException("Matrix is singular or nearly singular");
            }

            // pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }
}
