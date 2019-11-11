/*
* Contenido generado de pruebax
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Phones;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "phones", urlPatterns = {"/phones/*"})
public class phones extends iServlet {

    private Phones control;

    @Override
    protected void get() throws Exception {
        control = Factory.createPhones();
        control.get(repository.getPhone());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createPhones();
        control.save(repository.getPhone());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createPhones();
        control.update(repository.getPhone());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createPhones();
        control.delete(repository.getPhone());
        result = control.getContent();
    }

}
