/*
* Contenido de microTwitterUI generado por $author$
*/

package controllers.utils;

import controllers.security.logger;
import sources.api.repositoryApi;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public abstract class iController {
    
    public final logger ERRORES = new logger();
    protected String res = "";
    public repositoryApi source;
    
    protected iController(repositoryApi source){
        this.source = source;
    }
    
    public String getContent(){
        return res;
    }

}
