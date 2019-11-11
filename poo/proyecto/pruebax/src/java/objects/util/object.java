/*
* Contenido generado de pruebax
*/

package objects.util;

/**
 *
 * @author Luis Diego Jiménez Delgado
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
    
}
