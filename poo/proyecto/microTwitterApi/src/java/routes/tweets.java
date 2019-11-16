/*
* Contenido de microTwitterApi generado por $author$
 */
package routes;

import javax.servlet.annotation.WebServlet;
import controllers.security.Factory;
import controllers.Tweets;
import routes.utils.iServlet;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
@WebServlet(name = "tweets", urlPatterns = {"/tweets/*"})
public class tweets extends iServlet {

    private final Tweets control = Factory.createTweets();

    @Override
    protected void get() throws Exception {
        if (page.equals("list")) {
            control.getList(repository.getTweet());
        } else {
            control.get(repository.getTweet());
        }
        control.get(repository.getTweet());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control.save(repository.getTweet());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control.update(repository.getTweet());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control.delete(repository.getTweet());
        result = control.getContent();
    }

}
