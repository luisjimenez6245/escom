/*
* Contenido de microTwitterApi generado por $author$
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

    private final Regions control = Factory.createRegions();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getRegion());
        } else {
            control.get(repository.getRegion());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getRegion());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getRegion());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getRegion());
        result = control.getContent();
    }

}
