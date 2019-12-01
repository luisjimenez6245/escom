package controllers;

import controllers.utils.iViewController;
import models.Database;
import models.Level;
import models.Query;
import models.Table;
import models.User;
import presenters.IndexPresenter;
import routes.utils.Factory;
import views.IndexView;
import sources.requests.RepositoryRequests;

/**
 *
 * @author luis
 */
public class IndexController extends iViewController implements IndexView {

    private final IndexPresenter presenter;

    private String CONTENT = ""
            + "      <div class=\"main-body\">\n"
            + "        <div class=\"container\">\n"
            + "          <div class=\"title\">\n"
            + "            SQL Helper\n"
            + "          </div>\n"
            + "          <div class=\"subtitle\">\n"
            + "            Escribe tu sentencia a revisar\n"
            + "          </div>\n"
            + "          <div class=\"main\">\n"
            + "            <div class=\"right\">\n"
            + "              <div class=\"container-items\">\n"
            + "                <div class=\"subtitle\">\n"
            + "                  Palabras sugeridas\n"
            + "                </div>\n"
            + "                <div class=\"container-content\" id='query-helper-container'>\n"
            + "                     $helper-items$"
            + "                </div>\n"
            + "              </div>\n"
            + "            </div>\n"
            + "            <div class=\"left\">\n"
            + "              <div class=\"text-area\">\n"
            + "                <textarea id=\"code-content\"></textarea>\n"
            + "              </div>\n"
            + "              <div>\n"
            + "                <input type=\"button\" value=\"checar\" onclick=\"onClickCheckSyntax()\"/>\n"
            + "              </div>\n"
            + "            </div>\n"
            + "          </div>\n"
            + "        </div>"
            + "      </div>\n"
            + "      <footer class=\"footer\">\n"
            + "        <div class=\"\">Proyecto Bases</div>\n"
            + "      </footer>\n";

    private String LEFTNAV = ""
            + "      <div class=\"container-hidden\" id='left-container'>\n"
            + "        <span class=\"close fas fa-times\" onclick=\"hideLeft()\"></span>\n"
            + "        <div class=\"container\">\n"
            + "          $content$\n"
            + "        </div>\n"
            + "      </div>\n";

    public IndexController(RepositoryRequests rSource) {
        super(rSource);
        presenter = Factory.createIndexPresenter(this);
    }

    @Override
    public void main() {
        String action = rSource.getAction();
        user = rSource.getUser();
        if (action.equals("")) {
            this.presenter.loadView(user);
        } else {
            if (action.equals("get_databases")) {
                this.presenter.loadDatabases(user, rSource.getDatabase());
            } else {
                if (action.equals("check_syntax")) {
                    this.presenter.onClickCheckQuery(rSource.getQuery(), user, rSource.getDatabase());
                } else {
                    if (action.equals("auto_complete")) {
                        this.presenter.onGetQuery(rSource.getQuery(), user, rSource.getDatabase());
                    } else {
                        content = "hola";
                    }
                }
            }
        }
    }

    @Override
    public void view() {
        content = LEFTNAV + CONTENT;
        scriptsFinal += ""
                + " <script>\n "
                + "   $(function() {\n"
                + "      let container = document.getElementById(\"code-content\");\n"
                + "      codemirror = CodeMirror.fromTextArea(container, {\n"
                + "        lineNumbers: true,\n"
                + "        mode: \"text/x-mysql\",\n"
                + "        indentWithTabs: true,\n"
                + "        smartIndent: true,\n"
                + "        matchBrackets: true,\n"
                + "        autofocus: true,\n"
                + "        extraKeys: {\n"
                + "          \"Ctrl-Space\": function(m) {\n"
                + "              let q = $(\".CodeMirror\")[0].CodeMirror.getValue();\n"
                + "              let params = {\n"
                + "                c_action: \"auto_complete\",\n"
                + "                query: q\n"
                + "              };\n"
                + "              requestHandler(\"/\", \"POST\", params, false);\n"
                + "          }\n"
                + "        }\n"
                + "      });\n"
                + "    });"
                + "</script>\n";
    }

    @Override
    public void showLevels(Level[] levels) {
    }

    @Override
    public void showDatabases(Database[] databases) {
        String res = "";
        for (Database d : databases) {
            res += "<div class=\"child\">" + d.name + "</div>\n";
        }
        LEFTNAV = LEFTNAV.replace("$content$", res);
        content = LEFTNAV;
    }

    @Override
    public void showTables(Table[] Table) {

    }

    @Override
    public void showQuerys(Query[] queries) {
        String res = "";
        for (Query t : queries) {
            res += "<div class=\"item\" onclick=\"onClickAutoComplete('" + t.name + "')\">" + t.name + "</div>\n";
        }
        CONTENT = CONTENT.replace("$helper-items$", res);
        content = CONTENT;
    }

    @Override
    public void showError(String message) {
    }

    @Override
    public void setUser(User user) {

    }

    @Override
    public void clickCheckQuery(Query query, boolean isValid) {
        content = "";
        modal = ""
                + "  <div class='blur'></div>\n"
                + "            <div class='container-form'>\n"
                + "                <div class='header'>\n"
                + "                    <span class='fas fa-times' onclick='hideModal()'></span>\n"
                + "                    <div class='title'>" + String.valueOf(isValid) + "</div>\n"
                + "                    <div>" + query.name + "</div>\n"
                + "                </div>\n"
                + "                <div class='content container-form form form-control'>\n"
                + "                    <div clasS='container'>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full' style='text-align: center'>\n"
                + "                           Ocurrió un error interno, favor de verificar tus datos y volverlo a intentar\n"
                + "                        </div>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <div class='button button-middle'  onclick='succesRegister()'>\n"
                + "                                <label>Aceptar</label>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'></div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>";
        scriptsFinal += "<script>"
                + "showModal();"
                + "</script>";

    }

}
