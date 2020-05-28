/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ui.controllers.grapherController;
import ui.controllers.iViewController;

/**
 *
 * @author luis
 */
public class dev extends iServlet {

    private iViewController controller;

    @Override
    protected void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        controller = new grapherController(repository);
        controller.css = ""
                + "<!-- load stylesheets -->\n"
                + "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,400\">  <!-- Google web font \"Open Sans\" -->\n";
        controller.scripts += ""
                + "<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n"
                + "<script src=\"" + this.MAN.URL + "/JS/requestHandler.js\"></script>\n";
        // controller.css = "<link rel=\"stylesheet\" href=\"" + this.MAN.URL + "/CSS/general.css\">\n";
        controller.scriptsFinal += ""
                + "        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.2.min.js\"><\\/script>')</script>\n";
        controller.main();
        result = controller.createContent();

    }

    @Override
    protected void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        controller = new grapherController(repository);
        controller.main();
        result = controller.getJson();
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
