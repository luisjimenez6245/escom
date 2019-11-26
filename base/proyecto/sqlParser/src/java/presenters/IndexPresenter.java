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
    
    private void getDatabases(){
    }

    public void loadQueries(Query object) {
    }

}
