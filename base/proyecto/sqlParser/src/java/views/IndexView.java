package views;

import models.Database;
import models.Level;
import models.Query;
import models.Table;
import models.User;

/**
 *
 * @author luis
 */
public interface IndexView extends iView {

    public void showLevels(Level[] levels);

    public void showDatabases(Database[] databases);

    public void showTables(Table[] tables);

    public void showQueries(Query[] queries);

    public void showError(String message);

    public void setUser(User user);

    public void clickCheckQuery(Query query, boolean isValid, String error);

    public void showProbableQueries(Query[] queries);

    public void clickCreateDatabase();

}
