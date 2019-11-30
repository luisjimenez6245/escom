package presenters;

import models.Database;
import models.Query;
import models.User;
import sources.mysql.repositoryMysql;
import views.IndexView;

/**
 *
 * @author luis
 */
public class IndexPresenter {

    private final IndexView view;
    private final repositoryMysql source;

    public IndexPresenter(IndexView view, repositoryMysql source) {
        this.view = view;
        this.source = source;
    }

    public void loadView() {
        this.view.showLevels(this.source.getLevelList(null));
    }

    public void loadDatabases(User user, Database object) {
        if (user == null) {

        } else {

        }
    }

    private void getDatabases() {
    }

    private void getDatabases(User user) {
        if (user != null) {
            source.getDatabase(new Database(0).build(null, null, null, user.userId));
        } else {
            getDatabases();
        }
    }

    public void getTables(Database object) {

    }

    public void loadQueries(Query object) {

    }

    public void createSession(User user) {

    }

    public void createSession() {

    }

}
