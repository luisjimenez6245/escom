/*
* Contenido de microTwitterApi generado por $author$
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

    private final Users control = Factory.createUsers();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getUser());
        } else {
            control.get(repository.getUser());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getUser());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getUser());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getUser());
        result = control.getContent();
    }

}
