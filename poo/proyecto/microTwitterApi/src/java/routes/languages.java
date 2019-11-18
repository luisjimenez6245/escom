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

    private final Languages control = Factory.createLanguages();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getLanguage());
        } else {
            control.get(repository.getLanguage());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        System.out.println("fui");
        control.save(repository.getLanguage());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getLanguage());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getLanguage());
        result = control.getContent();
    }

}
