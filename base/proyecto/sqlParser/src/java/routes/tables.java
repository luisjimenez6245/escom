/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Tables;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "tables", urlPatterns = {"/tables/*"})
public class tables extends iServlet {

    private Tables control;

    @Override
    protected void get() throws Exception {
        control = Factory.createTables();
        control.get(repository.getTable());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createTables();
        control.save(repository.getTable());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createTables();
        control.update(repository.getTable());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createTables();
        control.delete(repository.getTable());
        result = control.getContent();
    }

}
