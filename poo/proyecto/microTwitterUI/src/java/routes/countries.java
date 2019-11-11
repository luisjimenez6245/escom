/*
* Contenido de microTwitterUI generado por $author$
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

    private Countries control;

    @Override
    protected void get() throws Exception {
        control = Factory.createCountries();
        control.get(repository.getCountry());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createCountries();
        control.save(repository.getCountry());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createCountries();
        control.update(repository.getCountry());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createCountries();
        control.delete(repository.getCountry());
        result = control.getContent();
    }

}
