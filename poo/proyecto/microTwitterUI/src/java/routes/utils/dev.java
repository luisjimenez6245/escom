/*
* Contenido de microTwitterApi generado por $author$
*/
package routes.utils;

import controllers.security.manager;
import javax.servlet.annotation.WebServlet;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "dev", urlPatterns = {"/dev/*"})
public class dev extends iServlet {

    @Override
    protected void get() throws Exception {
      result =  manager.getInstance().getProperty("dbName");
    }

    @Override
    protected void post() throws Exception {
        
    }
    
}
