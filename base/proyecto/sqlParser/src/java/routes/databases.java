/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Databases;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "databases", urlPatterns = {"/databases/*"})
public class databases extends iServlet {

    private Databases control;

    @Override
    protected void get() throws Exception {
        control = Factory.createDatabases();
        control.get(repository.getDatabase());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createDatabases();
        control.save(repository.getDatabase());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createDatabases();
        control.update(repository.getDatabase());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createDatabases();
        control.delete(repository.getDatabase());
        result = control.getContent();
    }

}
