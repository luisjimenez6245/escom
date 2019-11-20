/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Attributes;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "attributes", urlPatterns = {"/attributes/*"})
public class attributes extends iServlet {

    private Attributes control;

    @Override
    protected void get() throws Exception {
        control = Factory.createAttributes();
        control.get(repository.getAttribute());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createAttributes();
        control.save(repository.getAttribute());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createAttributes();
        control.update(repository.getAttribute());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createAttributes();
        control.delete(repository.getAttribute());
        result = control.getContent();
    }

}
