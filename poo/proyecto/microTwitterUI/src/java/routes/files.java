/*
* Contenido de microTwitterApi generado por $author$
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

    private final Files control = Factory.createFiles();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getFile());
        } else {
            control.get(repository.getFile());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getFile());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getFile());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getFile());
        result = control.getContent();
    }

}
