/*
* Contenido de microTwitterUI generado por $author$
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

    private Dictonaries control;

    @Override
    protected void get() throws Exception {
        control = Factory.createDictonaries();
        control.get(repository.getDictonary());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createDictonaries();
        control.save(repository.getDictonary());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createDictonaries();
        control.update(repository.getDictonary());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createDictonaries();
        control.delete(repository.getDictonary());
        result = control.getContent();
    }

}
