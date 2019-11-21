/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import routes.utils.iServlet;

/**
 *
 * @author luis
 */
@WebServlet(name = "index", urlPatterns = {"/index/*"})
public class index extends iServlet {

    private int tabla = 0;
    private final String headers = ""
            + "<html>\n"
            + "    <head>\n"
            + "        <title>Tablas de multiplicar</title>\n"
            + "        <meta charset=\"UTF-8\">\n"
            + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
            + "    </head>\n"
            + "    <body>\n"
            + "        <form method='post' action='./index'>\n"
            + "          <label for='id_text'>Número:<label><br>"
            + "         <input id='id_text' type='number' name='number'>\n"
            + "         <input type='submit' value='obtener'>\n"
            + "         </form>\n<br><br><br><br>"
            + "     <div>$content$</div>"
            + "    </body>\n"
            + "</html>\n"
            + "";

    @Override
    protected void get(HttpServletRequest request) throws Exception {
        getNumber(request);
        result = headers.replace("$content$", "");

    }

    @Override
    protected void post(HttpServletRequest request) throws Exception {
        getNumber(request);
        result = headers.replace("$content$", generateTable());
    }

    private void getNumber(HttpServletRequest request) {
        if (request.getParameter("number") != null) {
            try {
                tabla = Integer.parseInt(request.getParameter("number"));
            } catch (NumberFormatException ex) {
                tabla = 1;
                System.out.println(ex.toString());
            }
        }
    }

    private String generateTable() {
        String res = "";
        for (int i = 0; i < 11; ++i) {
            res += "<div>" + tabla + " x " + i + " = \t" + (tabla * i) + "</div> <br>\n";
        }
        return res;
    }
}
