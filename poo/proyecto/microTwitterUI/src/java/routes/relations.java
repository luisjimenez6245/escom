/*
* Contenido de microTwitterUI generado por $author$
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

    private Relations control;

    @Override
    protected void get() throws Exception {
        control = Factory.createRelations();
        control.get(repository.getRelation());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createRelations();
        control.save(repository.getRelation());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createRelations();
        control.update(repository.getRelation());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createRelations();
        control.delete(repository.getRelation());
        result = control.getContent();
    }

}
