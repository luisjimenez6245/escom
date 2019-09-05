/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

/**
 *
 * @author lusi
 */
public final class a {

    private int limit;
    private char[][][] dic;
    private int items = 0;

    a() {
        items = 0;
        limit = 27;
        dic =  new char [limit][][];
        for(int i = 0; i < limit; ++i ){
            System.out.println(i);
            execute(i);
            
        }
        System.out.println(items);
    }

    public void execute(int n) {
        int limit = (int) Math.pow(2, n + 1);
        dic[n] = new char[limit][];
        for(int i = 0; i < limit; ++i){
            dic[n][i] = getNumber(i, n + 1);
            //System.out.println(dic[n][i]);
            ++items;
        }
        
    }
    
    

    char[] getNumber(int number, int length) {
        return fillBinaryString(Integer.toBinaryString(number), length).toCharArray();
    }

    private String fillBinaryString(String binary, int length) {
        if(binary.length() > length){
            return "";
        }
        while (binary.length() < length) {
            binary = "0" + binary;
        }
       
        return binary;
    }
    
}
