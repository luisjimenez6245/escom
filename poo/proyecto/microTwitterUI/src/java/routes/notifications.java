/*
* Contenido de microTwitterUI generado por $author$
*/

package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Notifications;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

@WebServlet(name = "notifications", urlPatterns = {"/notifications/*"})
public class notifications extends iServlet {

    private Notifications control;

    @Override
    protected void get() throws Exception {
        control = Factory.createNotifications();
        control.get(repository.getNotification());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createNotifications();
        control.save(repository.getNotification());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createNotifications();
        control.update(repository.getNotification());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createNotifications();
        control.delete(repository.getNotification());
        result = control.getContent();
    }

}
