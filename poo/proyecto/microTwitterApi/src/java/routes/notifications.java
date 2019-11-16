/*
* Contenido de microTwitterApi generado por $author$
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

    private final Notifications control = Factory.createNotifications();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getNotification());
        } else {
            control.get(repository.getNotification());
        }
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getNotification());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getNotification());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getNotification());
        result = control.getContent();
    }

}
