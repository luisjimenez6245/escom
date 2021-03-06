/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import com.google.gson.Gson;
import controllers.security.manager;
import objects.User;
import repositories.repositoryRequest;

/**
 *
 * @author luis
 */
public abstract class iViewController {

    protected final repositoryRequest rSource;

    public User user;

    protected iViewController(repositoryRequest rSource) {
        this.rSource = rSource;
    }

    public String scripts = "";

    public String titulo = "";

    public String alertas = "";

    public String scriptsFinal = "";

    public String content = "";

    public String nav = "";

    public String css = "";

    public String modal = "";

    public String createContent() {
        String resultado
                = "<!DOCTYPE html>"
                + "\n"
                + "<html>"
                + "\n";
        if (titulo.equals("")) {
            resultado += head();
        } else {
            resultado += head(titulo);
        }
        resultado
                += "<body>"
                + nav
                + "\n<div class='container-hidden' id='modal-loading'>\n"
                + " <div class=\"lds-ellipsis\"><div></div><div></div><div></div><div></div></div>"
                + "</div>\n"
                + "\n<div class='container-hidden' id='modal-container'>\n"
                + modal
                + "</div>\n"
                + "<div id='js-handler' class='container-hidden'></div>"
                + "<div id='main-container' class='main module row'>"
                + content
                + "</div>"
                + "\n"
                //      + "<div class='noJS' id='no-js'>\n"
                //    + "    Se requiere de JavaScript para poder usar la plataforma.\n"
                //  + "</div> "
                + "\n"
                + "</body>"
                + "\n"
                + scriptsFinal
                + "\n"
                + "</html>";
        return resultado;
    }

    protected String head() {
        String resultado = ""
                + "<head>"
                + "\n "
                + "<title>Plataforma</title> "
                + "\n "
                + css
                + "\n"
                + "<script>let DOMAIN = \"" + manager.DOMAIN + "\";</script>\n"
                + "\n"
                + scripts
                + "<meta charset='utf-8'>\n"
                + "<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'>"
                + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n"
                + "<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.8.1/css/all.css' integrity='sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf' crossorigin='anonymous'>"
                + "<meta charset='UTF-8'>"
                + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                + "\n"
                + ""
                + "</head>"
                + "\n";
        return resultado;
    }

    protected String head(String titulo) {
        String resultado = ""
                + "<head>"
                + "\n "
                + "<title>" + titulo + "</title> "
                + "\n "
                + css
                + scripts
                + "<meta charset='UTF-8'>"
                + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                + "\n"
                + "</head>"
                + "\n";
        return resultado;
    }

    public String getJson() {
        return new Gson().toJson(new html(content, scriptsFinal, modal));
    }

    public String getErrorJson() {
        return new Gson().toJson(new html("", "<script>exit();</script>", ""));
    }

    public abstract void main();

}

class html {

    public String content;
    public String script;
    public String modal;

    public html(String content, String script, String modal) {
        this.content = content;
        this.script = script;
        this.modal = modal;
    }
}
