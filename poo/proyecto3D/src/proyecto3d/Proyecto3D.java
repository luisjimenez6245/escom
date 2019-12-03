/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3d;

import java.util.Random;

/**
 *
 * @author luis
 */
public class Proyecto3D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        new Container(Math.abs(r.nextInt() % 5) + 1);
       // new Container(6);
    }

}
