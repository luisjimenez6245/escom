/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources.requests;

import controllers.security.logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import objects.Nav;

/**
 *
 * @author luis
 */
public class mapperRequest {
    
    
    public Nav nav(HttpServletRequest request) {
        return new Nav(
                request.getParameter("id_nav") == null ? 0 : Long.parseLong(request.getParameter("id_nav")),
                request.getParameter("nombreMenu") == null ? "" : request.getParameter("nombreMenu"),
                request.getParameter("direccion") == null ? "" : request.getParameter("direccion"),
                request.getParameter("accion") == null ? "" : request.getParameter("accion"),
                request.getParameter("posicion") == null ? 0 : Integer.parseInt(request.getParameter("posicion")),
                request.getParameter("status") == null ? 0 : Integer.parseInt(request.getParameter("status"))
        );
    }

    public Nav listNav(ResultSet res) {
        
        try {
            if (res.next()) {
                return new Nav(res.getLong("idMenu"), res.getString("nombreMenu"), res.getString("direccion"), res.getString("accion"), res.getInt("posicion"), res.getInt("status"));
            } else {
                return new Nav(0L, "", "", "", 0, 0);
            }
        } catch (SQLException ex) {
            new logger().error(ex);
            return null;
        }
    }
    
    
    
    
}
