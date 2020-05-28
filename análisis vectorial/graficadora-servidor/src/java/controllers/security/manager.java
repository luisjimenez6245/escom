/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.security;

import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import objects.User;

/**
 *
 * @author luis
 */
public class manager {

    public static String APPNAME =  "grapher";
    public static String DOMAIN = "http://localhost";
   // public static String DOMAIN = "http://192.168.1.72";
    public static String URL = DOMAIN + ":8080/grapher";
    

    public User getUser(HttpServletRequest request) {
        Base64.Decoder d = Base64.getDecoder();
        HttpSession session = request.getSession(true);
        String aux;
        if (request.getParameter("x") != null && request.getParameter("r") != null && request.getParameter("a") != null && request.getParameter("token") != null && request.getParameter("t") != null) {
            aux = new String(d.decode(request.getParameter("x").getBytes()));
            try {
                return new User(Long.parseLong(aux)).build(
                        request.getParameter("r"),
                        "",
                        request.getParameter("a"),
                        request.getParameter("token"),
                        true,
                        request.getParameter("t"));
            } catch (Exception e) {
            }
        }
        if (!session.isNew()) {
            if (session.getAttribute("x") != null && session.getAttribute("r") != null && session.getAttribute("t") != null && session.getAttribute("a") != null && session.getAttribute("t") != null) {
                try {
                    aux = ("" + session.getAttribute("x"));
                    return new User(Long.parseLong(aux)).build(
                            "" + session.getAttribute("r"),
                            "",
                            "" + session.getAttribute("a"),
                            "" + session.getAttribute("token"),
                            true,
                            "" + session.getAttribute("t"));
                } catch (Exception e) {
                }
            }
            session.invalidate();
        }
        return null;

    }

    public User getEncryptedUser(HttpServletRequest request) {
        if (request.getParameter("x") != null) {
            Base64.Decoder d = Base64.getDecoder();

            /* System.out.println("x" + request.getParameter("x"));
            System.out.println("t" + request.getParameter("t"));
            System.out.println("a" + new String(d.decode(request.getParameter("a").getBytes())));
            System.out.println("token" + request.getParameter("token"));
             */
            String aux = new String(d.decode(request.getParameter("x").getBytes()));
            try {
                return new User(Long.parseLong(aux)).build(
                        request.getParameter("r") == null ? "" : new String(d.decode(request.getParameter("r").getBytes())),
                        "",
                        request.getParameter("a") == null ? "" : new String(d.decode(request.getParameter("a").getBytes())),
                        request.getParameter("token") == null ? "" : request.getParameter("token"),
                        true,
                        request.getParameter("t") == null ? "" : new String(d.decode(request.getParameter("t").getBytes())));
            } catch (NumberFormatException e) {
                System.out.println("ora que paso");
            }
        }
        return null;

    }

}
