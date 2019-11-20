/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Queries;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "queries", urlPatterns = {"/queries/*"})
public class queries extends iServlet {

    private Queries control;

    @Override
    protected void get() throws Exception {
        control = Factory.createQueries();
        control.get(repository.getQuery());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createQueries();
        control.save(repository.getQuery());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createQueries();
        control.update(repository.getQuery());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createQueries();
        control.delete(repository.getQuery());
        result = control.getContent();
    }

}
