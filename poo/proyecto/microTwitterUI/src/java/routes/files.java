/*
* Contenido de microTwitterUI generado por $author$
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Files;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "files", urlPatterns = {"/files/*"})
public class files extends iServlet {

    private Files control;

    @Override
    protected void get() throws Exception {
        control = Factory.createFiles();
        control.get(repository.getFile());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createFiles();
        control.save(repository.getFile());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createFiles();
        control.update(repository.getFile());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createFiles();
        control.delete(repository.getFile());
        result = control.getContent();
    }

}
