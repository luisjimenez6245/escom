/*
* Contenido de microTwitterUI generado por $author$
*/

package controllers.utils;

import com.google.gson.Gson;
import controllers.security.logger;
import sources.api.repositoryApi;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public abstract class iController <T> {
    
    public final Gson JSON = new Gson();
    public final logger ERRORES = new logger();
    protected String res = "";
    public repositoryApi source;
    
    protected iController(repositoryApi source){
        this.source = source;
    }
    
    public abstract void get(T object);
    public abstract void getList(T object);
    public abstract void save(T object);
    public abstract void delete(T object);
    public abstract void update(T object);
    
    public String getContent(){
        return res;
    }

}
