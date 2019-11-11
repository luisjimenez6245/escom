/*
* Contenido de microTwitterUI generado por $author$
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Regions;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "regions", urlPatterns = {"/regions/*"})
public class regions extends iServlet {

    private Regions control;

    @Override
    protected void get() throws Exception {
        control = Factory.createRegions();
        control.get(repository.getRegion());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createRegions();
        control.save(repository.getRegion());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createRegions();
        control.update(repository.getRegion());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createRegions();
        control.delete(repository.getRegion());
        result = control.getContent();
    }

}
