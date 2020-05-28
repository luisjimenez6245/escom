/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.sql.ResultSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author luis
 * @param <T>
 */
public abstract class object<T> {

    public abstract String toJSON();
    
    public String toJSON(object[] arr){
        String res = "";
        for (object obj : arr) {
            res +=  obj.toJSON();
        }
        return res;
    }

    /*public abstract T parse(HttpServletRequest request);

    public abstract T parse(ResultSet res);

    public abstract List<T> parseList(HttpServletRequest request);

    public abstract List<T> parseList(ResultSet res);*/
}
