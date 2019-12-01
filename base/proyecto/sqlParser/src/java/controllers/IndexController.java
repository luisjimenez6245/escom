package controllers;

import controllers.utils.iViewController;
import models.Database;
import models.Level;
import models.Query;
import models.Table;
import presenters.IndexPresenter;
import routes.utils.Factory;
import sources.requests.repositoryRequests;
import views.IndexView;

/**
 *
 * @author luis
 */
public class IndexController extends iViewController implements IndexView {

    private final IndexPresenter presenter;

    private final String CONTENT = ""
            + "      <div class=\"main-body\">\n"
            + "        <div class=\"nav-rigth\"></div>\n"
            + "      </div>\n"
            + "      <footer class=\"footer\">\n"
            + "        <div class=\"\"></div>\n"
            + "      </footer>\n";

    private final String LEFTNAV = ""
            + "      <div class=\"left-container\" id='left-container'>\n"
            + "        <span class=\"close fas fa-times\" onclick=\"hideLeft()\"></span>\n"
            + "        <div class=\"container\">\n"
            + "          a\n"
            + "        </div>\n"
            + "      </div>\n";

    public IndexController(repositoryRequests rSource) {
        super(rSource);
        presenter = Factory.createIndexPresenter(this);
    }

    @Override
    public void main() {
        String action = rSource.getAction();
        if (action.equals("")) {
            this.presenter.loadView();
        } else {
            if (action.equals("getDatabases")) {
                this.presenter.loadDatabases(user, rSource.getDatabase());
            } else {
                content = "hola";
            }
        }
    }

    @Override
    public void view() {
        content = LEFTNAV+ CONTENT;
    }

    @Override
    public void showLevels(Level[] levels) {
    }

    @Override
    public void showDatabases(Database[] databases) {

    }

    @Override
    public void showTables(Table[] tables) {
    }

    @Override
    public void showQuerys(Query[] queries) {
    }

    @Override
    public void showError(String message) {
    }

}
