/*
* Contenido de microTwitterApi generado por $author$
 */
package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Countries;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
@WebServlet(name = "countries", urlPatterns = {"/countries/*"})
public class countries extends iServlet {

    private final Countries control = Factory.createCountries();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getCountry());
        } else {
            control.get(repository.getCountry());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getCountry());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getCountry());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getCountry());
        result = control.getContent();
    }

}
