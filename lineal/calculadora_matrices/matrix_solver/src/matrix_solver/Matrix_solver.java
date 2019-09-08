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
        /* 
        double matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double matrixA[][] = {{3, 4, 2}};
        double matrixAL[] = {3, 4, 2};
        double matrixB[][] = {{13, 9, 7, 15}, {8, 7, 4, 6}, {6, 4, 0, 3}};
        s.printMatrix(s.dotMatrix(matrixA, matrixB));
        s.printMatrix(s.dotMatrix(matrixAL, matrixB));

        System.out.println("");
        System.out.println("Inversa");

        double test[][] = {{6, 1, 1, 3}, {4, -2, 5, 3}, {2, 8, 7, 4}, {6, 7, 8, 8}};
        s.printMatrix(s.getInverseMatrix(test));

        System.out.println("");*/
        System.out.println("res");

        double test[][] = {{6, 1, 1, 3}, {4, -2, 5, 3}, {2, 8, 7, 4}, {6, 7, 8, 8}};

        double test2[][] = {{3, 3.5}, {3.2, 3.6}};

        double d[] = {118.4, 135.2, 2, 3.2};

        
        
        double dependent[] = {118.4, 135.2};
        double res[][] = new double[4][4];
       // s.printMatrix(test);
        System.out.println("resaaa");
        

      //  s.printMatrix(s.swapRows(test, 1, 2));
        System.out.println("res");

     //   s.printMatrix(s.swapRows(test, d, 1));

        s.printMatrix(s.solveMatrix(test2, dependent));
    }

}
