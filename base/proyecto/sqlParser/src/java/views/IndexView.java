package views;

import models.Database;
import models.Level;
import models.Query;
import models.Table;

/**
 *
 * @author luis
 */
public interface IndexView extends iView {

    public void showLevels(Level[] levels);

    public void showDatabases(Database[] databases);

    public void showTables(Table[] tables);

    public void showQuerys(Query[] queries);

    public void showError(String message);

}
