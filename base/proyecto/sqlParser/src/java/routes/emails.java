/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
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

    private Emails control;

    @Override
    protected void get() throws Exception {
        control = Factory.createEmails();
        control.get(repository.getEmail());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createEmails();
        control.save(repository.getEmail());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createEmails();
        control.update(repository.getEmail());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createEmails();
        control.delete(repository.getEmail());
        result = control.getContent();
    }

}
