package presenters;

import models.Database;
import models.Query;
import models.User;
import models.enums.QueryType;
import models.enums.UserType;
import sources.mysql.SubSource;
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

    public void loadView(User user) {
        if (user == null || user.userId == 0) {
            user = source.getUser(new User(0).build(null, null, null, false, null, UserType.PUBLIC, null, null));
            this.view.showQueries(source.getQueryList(new Query(0).build(null, QueryType.INITAL, null)));
            loadDatabases(user, null);
        }
        this.view.view();
        this.view.setUser(user);
    }

    public void loadView() {
        this.view.view();
    }

    public void loadDatabases(User user, Database object) {
        if (user != null) {
            this.view.showDatabases(source.getDatabaseList(new Database(0).build(null, null, null, user.userId)));
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

    public void onGetQuery(Query query, User user, Database database) {
        if (user == null || user.userType.equals(UserType.PUBLIC) || user.userId == 0) {
        }
        System.out.println(query.name);
        this.view.showProbableQueries(source.getQueryList(new Query(0).build(null, query.queryType, null)));
    }

    public void onClickCheckQuery(Query query, User user, Database database) {
        SubSource sub = new SubSource();
        if (user == null || user.userType.equals(UserType.PUBLIC) || user.userId == 0) {
            user = source.getUser(new User(0).build(null, null, null, false, null, UserType.PUBLIC, null, null));
            database = source.getDatabase(new Database(0).build(null, null, null, user.userId));
        }
        this.view.clickCheckQuery(query, sub.check(query.name, database.name, database.url), sub.res);

    }

    public void createSession(User user) {

    }

    public void createSession() {

    }

}
