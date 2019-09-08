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
public class Matrix_solver {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        solver s = new solver();
        float matrixA[][] = {{1, 2, 3}, {4, 5, 6}};
        float matrixB[][] = {{7, 8}, {9, 10}, {11, 12}};
        s.printMatrix(s.dotMatrix(matrixA, matrixB));
    }

}
