/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ui.controllers.loginController;

/**
 *
 * @author luis
 */
public class login extends iServlet {

    private loginController control;

    @Override
    protected void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        control = new loginController(repository);
        control.user = getUser(request);
        if (control.user == null) {
            control.main();
            control.scriptsFinal = "<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n"
                    + "        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.2.min.js\"><\\/script>')</script>\n";
            control.scripts = "<script src=\"" + this.url + "JS/requestHandler.js\"></script>\n";
            control.css = "<link rel=\"stylesheet\" href=\"" + this.url + "CSS/general.css\">\n";
            result = control.createContent();
        } else {
            resStatus = -2;
        }
    }

    @Override
    protected void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        control = new loginController(repository);
        control.user = getUser(request);
        if (control.user == null) {
            control.main();
            result = control.getJson();
        } else {
            resStatus = -2;
        }
    }

    @Override
    protected void put(HttpServletRequest request, HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
