/*
* Contenido de microTwitterApi generado por $author$
 */
package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Relations;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
@WebServlet(name = "relations", urlPatterns = {"/relations/*"})
public class relations extends iServlet {

    private final Relations control = Factory.createRelations();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getRelation());
        } else {
            control.get(repository.getRelation());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getRelation());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getRelation());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getRelation());
        result = control.getContent();
    }

}
