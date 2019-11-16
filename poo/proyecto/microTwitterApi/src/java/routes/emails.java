/*
* Contenido de microTwitterApi generado por $author$
 */
package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Emails;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
@WebServlet(name = "emails", urlPatterns = {"/emails/*"})
public class emails extends iServlet {

    private final Emails control = Factory.createEmails();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getEmail());
        } else {
            control.get(repository.getEmail());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getEmail());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getEmail());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getEmail());
        result = control.getContent();
    }

}
