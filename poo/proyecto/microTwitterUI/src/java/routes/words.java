/*
* Contenido de microTwitterApi generado por $author$
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

    private final Words control = Factory.createWords();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getWord());
        } else {
            control.get(repository.getWord());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getWord());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getWord());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getWord());
        result = control.getContent();
    }

}
