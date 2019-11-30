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
