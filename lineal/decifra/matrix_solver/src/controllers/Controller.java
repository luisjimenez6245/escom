/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class Controller {

    private final double[][] MAINMATRIX = {{2, 4, 6, 8, 1, 3}, {-7, 9, 2, 2, 6, 8}, {6, 9, 2, 3, -2, -4}, {-6, 1, -9, 8, 7, -3}, {-1, 5, 2, 7, 2, 6}, {4, 2, 1, 4, -3, -9}};
    private final double[][] INVERSEMATRIX;
    private final int[] NUMBERDIC = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
    private final char[] LETTERDIC = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

    private final MatrixController control;

    public Controller() throws Exception {
        control = new MatrixController();
        this.INVERSEMATRIX = control.getInverseMatrix(MAINMATRIX);
    }

    public String encrypt(String toEncrypt){
        return matrixToString(encryptString(toEncrypt));
    }
    
    public String decrypt(String toDecrypt){
        return decryptString(stringToMatrix(toDecrypt));
    }
    
    private String matrixToString(double[][] arrDouble) {
        String res = "";
        for (double[] arr : arrDouble) {
            res += "(";
            for (double d : arr) {
                res += d + ",";
            }
            res = res.substring(0, res.length() - 1) + "),";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }

    private double[][] stringToMatrix(String st) {
        st = st.replace("(", "");
        st = st.replace("),", "&&");
        String [] aux = st.split("&&");
        double[][] res = new double[aux.length][];
        int j = 0;
        for(String item: aux){
            item = item.replace(")", "");
            String [] auxItem = item.split(",");
            double[] auxRes = new double[auxItem.length];
            int i = 0;
            for(String s : auxItem){
                auxRes[i] = Double.parseDouble(s);
                ++i;
            }
            res[j] = (auxRes);
            ++j;
        }
        return res;
    }

    private double[][] encryptString(String toEncrypt) {
        String[] stringArr = splitString(toEncrypt.toLowerCase());
        double[][] matrixArr = new double[stringArr.length][6];
        int i = 0;
        for (String s : stringArr) {
            matrixArr[i] = toMatrix(s);
            matrixArr[i] = control.dotMatrix(MAINMATRIX, matrixArr[i]);
            ++i;
        }
        return matrixArr;
    }

    private String decryptString(double[][] arrDouble) {
        String res = "";
        for (double[] a : arrDouble) {
            res += decryptMatrix(control.dotMatrix(INVERSEMATRIX, a));
        }
        return res;
    }

    private String decryptMatrix(double[] arr) {
        String res = " ";
        for (double a : arr) {
            int aux = (int) Math.round(a);
            if (aux != 0) {
                res += LETTERDIC[(int) aux - 1];
            }
        }
        res = res.substring(1, res.length());
        return res;
    }

    private double[] toMatrix(String toEncrypt) {
        double[] res = new double[6];
        int i = 0;
        for (char c : toEncrypt.toCharArray()) {
            int aux_c = (int) c;
            if (aux_c == 32) {
                res[i] = 27;
            } else {
                res[i] = NUMBERDIC[(int) c - 97];
            }
            ++i;
        }
        return res;
    }

    private String[] splitString(String toSplit) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        while (!toSplit.equals("")) {
            if (toSplit.length() > 5) {
                res.add(toSplit.substring(6 * i, 6 * (i + 1)));
                toSplit = toSplit.substring(6 * (i + 1), toSplit.length());
            } else {
                res.add(toSplit);
                toSplit = "";
            }
            ++i;
        }
        return res.toArray(new String[res.size()]);
    }

}
