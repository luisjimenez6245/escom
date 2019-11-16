/*
* Contenido de microTwitterApi generado por $author$
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

    private final Phones control = Factory.createPhones();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getPhone());
        } else {
            control.get(repository.getPhone());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getPhone());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getPhone());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getPhone());
        result = control.getContent();
    }

}
