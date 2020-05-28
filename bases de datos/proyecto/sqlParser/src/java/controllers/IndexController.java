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
            + "                <input type=\"button\" value=\"checar\" class=\"button\" onclick=\"onClickCheckSyntax()\"/>\n"
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
            + "          <div class=\"option\" onclick='onClickNewDatabase()'>Nueva base de datos <span class='fas fa-plus'></span></div>\n"
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
                        if (action.equals("click_create_database")) {
                            this.presenter.onClickNewDatabase();
                        } else {
                            if (action.equals("click_save_database")) {
                                this.presenter.onClickNewDatabase();
                            } else {
                                content = "";
                            }
                        }
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
            res += "<div class=\"child\" id='database-item-" + d.databaseId + "' onclick=\"onClickUseDatabase('item-" + d.databaseId + "')\">" + d.name + "<span class='fas fa-info-circle'></span></div>\n";
        }
        LEFTNAV = LEFTNAV.replace("$content$", res);
        content = LEFTNAV;
    }

    @Override
    public void showTables(Table[] Table) {

    }

    @Override
    public void showQueries(Query[] queries) {
        String res = createQueries(queries);
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
    public void clickCheckQuery(Query query, boolean isValid, String error) {
        content = "";
        if (isValid) {
            modal = ""
                    + "  <div class='blur'></div>\n"
                    + "            <div class='container-form'>\n"
                    + "                <div class='header'>\n"
                    + "                    <span class='fas fa-times' onclick='hideModal()'></span>\n"
                    + "                    <div class='title'>Éxito</div>\n"
                    + "                    <div>Tu sentencia es valida</div>\n"
                    + "                </div>\n"
                    + "                <div class='content container-form form form-control'>\n"
                    + "                    <div clasS='container'>\n"
                    + "                        <div class='container-full'></div>\n"
                    + "                        <div class='container-full' style='text-align: center'>\n"
                    + "                           La sentencia que escribiste es valida sintácticamente\n"
                    + "                        </div>\n"
                    + "                        <div class='container-full'></div>\n"
                    + "                        <div class='container-full'>\n"
                    + "                            <div class='button button-middle'  onclick='hideModal()'>\n"
                    + "                                <label>Aceptar</label>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class='container-full'></div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>";
        } else {
            modal = ""
                    + "  <div class='blur' onclick='hideModal()'></div>\n"
                    + "            <div class='container-form'>\n"
                    + "                <div class='header'>\n"
                    + "                    <span class='fas fa-times' onclick='hideModal()'></span>\n"
                    + "                    <div class='title'>Error</div>\n"
                    + "                    <div>Tu sentencia no es valida</div>\n"
                    + "                </div>\n"
                    + "                <div class='content container-form form form-control'>\n"
                    + "                    <div clasS='container'>\n"
                    + "                        <div class='container-full'></div>\n"
                    + "                        <div class='container-full' style='text-align: center'>\n"
                    + "                           La sentencia que escribiste nor es valida sintácticamente, revisala e intenta de nuevo.<br> El error esta " + error.replace("You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use", "").replace("near", "cerca de").replace("at line", "de la linea")
                    + "                        </div>\n"
                    + "                        <div class='container-full'></div>\n"
                    + "                        <div class='container-full'>\n"
                    + "                            <div class='button button-middle'  onclick='hideModal()'>\n"
                    + "                                <label>Aceptar</label>\n"
                    + "                            </div>\n"
                    + "                        </div>\n"
                    + "                        <div class='container-full'></div>\n"
                    + "                    </div>\n"
                    + "                </div>\n"
                    + "            </div>";

        }
        scriptsFinal += "<script>"
                + "showModal();"
                + "</script>";
    }

    @Override
    public void showProbableQueries(Query[] queries) {
        String res = createQueries(queries);
        modal = "#query-helper-container";
        content = res;
        scriptsFinal = "<script>\n"
                + "\n"
                + " $('#query-helper-container').empty();\n\n"
                + "</script>\n";
    }

    private String createQueries(Query[] queries) {
        String res = "";
        for (Query t : queries) {
            res += "<div class=\"item\" onclick=\"onClickAutoComplete('" + t.name + "')\"> " + t.name + "</div>\n";
        }
        return res;
    }

    @Override
    public void clickCreateDatabase() {
        content = "";
        modal = ""
                + "  <div class='blur' onclick='hideModal()'></div>\n"
                + "            <div class='container-form'>\n"
                + "                <div class='header'>\n"
                + "                    <span class='fas fa-times' onclick='hideModal()'></span>\n"
                + "                    <div class='title'>Nueva base de datos</div>\n"
                + "                    <div>Estas apunto de crear una nueva base de datos.</div>\n"
                + "                </div>\n"
                + "                <div class='content container-form form form-control'>\n"
                + "                    <div clasS='container'>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full' style='text-align: center'>\n"
                + "                           Se generará el código sql para que se ejecute, ejecutalo para crear la base de datos.\n"
                + "                        </div>\n"
                + "                        <div class='container-full'></div>"
                + "                        <div class='container-full'>"
                + "                            <input type='text' placeholder='Nombre'  id='db_name' value=''/>\n"
                + "                        </div>\n"
                + "                        <div class='container-full'></div>\n"
                + "                        <div class='container-full'>\n"
                + "                            <div class='button button-middle'  onclick='onClickSaveDatabase()'>\n"
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
