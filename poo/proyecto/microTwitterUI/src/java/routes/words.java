/*
* Contenido de microTwitterUI generado por $author$
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Words;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "words", urlPatterns = {"/words/*"})
public class words extends iServlet {

    private Words control;

    @Override
    protected void get() throws Exception {
        control = Factory.createWords();
        control.get(repository.getWord());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createWords();
        control.save(repository.getWord());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createWords();
        control.update(repository.getWord());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createWords();
        control.delete(repository.getWord());
        result = control.getContent();
    }

}
