package routes;

import controllers.IndexController;
import javax.servlet.annotation.WebServlet;
import routes.utils.iServlet;

/**
 *
 * @author luis
 */
@WebServlet(name = "index", urlPatterns = {"/index/*"})
public class Index extends iServlet {

    private IndexController controller;

    @Override
    protected void get() throws Exception {
        controller = new IndexController(repository);
        controller.main();
        controller.scripts += "<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n"
                + "        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.2.min.js\"><\\/script>')</script>\n";
        controller.scripts += "<script src=\"" + this.url + "JS/requestHandler.js\"></script>\n";
        controller.css = "<link rel=\"stylesheet\" href=\"" + this.url + "CSS/general.css\">\n";
        result = controller.createContent();
    }

    @Override
    protected void post() throws Exception {
        controller = new IndexController(repository);
        result = controller.getJson();
    }

}
