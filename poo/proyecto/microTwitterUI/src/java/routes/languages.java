/*
* Contenido de microTwitterApi generado por $author$
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Languages;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "languages", urlPatterns = {"/languages/*"})
public class languages extends iServlet {

    private Languages control;

    @Override
    protected void get() throws Exception {
        control = Factory.createLanguages();
        control.get(repository.getLanguage());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createLanguages();
        control.save(repository.getLanguage());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createLanguages();
        control.update(repository.getLanguage());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createLanguages();
        control.delete(repository.getLanguage());
        result = control.getContent();
    }

}
