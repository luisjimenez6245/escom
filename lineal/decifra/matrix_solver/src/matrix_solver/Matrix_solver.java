/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_solver;

import UI.MainController;
import controllers.Controller;
import controllers.MatrixController;

/**
 *
 * @author lusi
 */
public class Matrix_solver {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Controller c = new Controller();
        System.out.println(c.decryptString(c.encryptString("fab iola")));
        
    }
}
