package routes;

import controllers.LoginController;
import javax.servlet.annotation.WebServlet;
import routes.utils.iServlet;

/**
 *
 * @author luis
 */
@WebServlet(name = "login", urlPatterns = {"/login/*"})
public class login extends iServlet {

    private LoginController control;

    @Override
    protected void get() throws Exception {
        control = new LoginController(repository);
        control.user = user;
        if (control.user == null) {
            control.scriptsFinal += "<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n"
                    + "        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.2.min.js\"><\\/script>')</script>\n";
            control.scripts += "<script src=\"" + this.url + "JS/requestHandler.js\"></script>\n";
            control.css = "<link rel=\"stylesheet\" href=\"" + this.url + "CSS/general.css\">\n";
            control.main();
            result = control.createContent();
        } else {
            if (page.equals("auth")) {

            } else {
                resStatus = -2;
            }
        }
    }

    @Override
    protected void post() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
