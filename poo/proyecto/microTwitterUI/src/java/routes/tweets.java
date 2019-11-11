/*
* Contenido de microTwitterUI generado por $author$
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

    private Tweets control;

    @Override
    protected void get() throws Exception {
        control = Factory.createTweets();
        control.get(repository.getTweet());
        result = control.getContent();
    }

    @Override
    protected void post() throws Exception {
        control = Factory.createTweets();
        control.save(repository.getTweet());
        result = control.getContent();
    }

    @Override
    protected void put() throws Exception {
        control = Factory.createTweets();
        control.update(repository.getTweet());
        result = control.getContent();
    }

    @Override
    protected void delete() throws Exception {
        control = Factory.createTweets();
        control.delete(repository.getTweet());
        result = control.getContent();
    }

}
