/*
* Contenido de microTwitterUI generado por $author$
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

    private Likes control;

    @Override
    protected void get() throws Exception {
        control = Factory.createLikes();
        control.get(repository.getLike());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createLikes();
        control.save(repository.getLike());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createLikes();
        control.update(repository.getLike());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createLikes();
        control.delete(repository.getLike());
        result = control.getContent();
    }

}
