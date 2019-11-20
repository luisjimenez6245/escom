/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Levels;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "levels", urlPatterns = {"/levels/*"})
public class levels extends iServlet {

    private Levels control;

    @Override
    protected void get() throws Exception {
        control = Factory.createLevels();
        control.get(repository.getLevel());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createLevels();
        control.save(repository.getLevel());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createLevels();
        control.update(repository.getLevel());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createLevels();
        control.delete(repository.getLevel());
        result = control.getContent();
    }

}
