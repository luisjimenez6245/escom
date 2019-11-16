/*
* Contenido de microTwitterApi generado por $author$
 */
package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Dictonaries;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
@WebServlet(name = "dictonaries", urlPatterns = {"/dictonaries/*"})
public class dictonaries extends iServlet {

    private final Dictonaries control = Factory.createDictonaries();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getDictonary());
        } else {
            control.get(repository.getDictonary());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getDictonary());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getDictonary());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getDictonary());
        result = control.getContent();
    }

}
