/*
* Contenido de microTwitterApi generado por $author$
 */
package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Likes;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
@WebServlet(name = "likes", urlPatterns = {"/likes/*"})
public class likes extends iServlet {

    private final Likes control = Factory.createLikes();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getLike());
        } else {
            control.get(repository.getLike());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getLike());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getLike());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getLike());
        result = control.getContent();
    }

}
