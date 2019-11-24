/*
* Contenido de sqlParser generado por $author$
 */
package presenters.security;

import controllers.security.manager;
import presenters.IndexPresenter;
import presenters.LoginPresenter;
import sources.mysql.repositoryMysql;
import sources.mysql.sourceMysql;
import views.IndexView;
import views.LoginView;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Factory {

    private static final manager MAN = manager.getInstance();
    private static final repositoryMysql SOURCE = new sourceMysql(MAN.getProperty("dbUser"),MAN.getProperty("dbPassword"), MAN.getProperty("dbName"), MAN.getProperty("dbUrl"), MAN.getProperty("dbPort"));

    public static LoginPresenter createLoginPresenter(LoginView view) {
        return new LoginPresenter(view, SOURCE);
    }

    public static IndexPresenter createIndexPresenter(IndexView view) {
        return new IndexPresenter(view, SOURCE);
    }

}
