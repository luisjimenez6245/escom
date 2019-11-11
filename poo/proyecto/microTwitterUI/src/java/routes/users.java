/*
* Contenido de microTwitterUI generado por $author$
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Users;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "users", urlPatterns = {"/users/*"})
public class users extends iServlet {

    private Users control;

    @Override
    protected void get() throws Exception {
        control = Factory.createUsers();
        control.get(repository.getUser());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createUsers();
        control.save(repository.getUser());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createUsers();
        control.update(repository.getUser());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createUsers();
        control.delete(repository.getUser());
        result = control.getContent();
    }

}
