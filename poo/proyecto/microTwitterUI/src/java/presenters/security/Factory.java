/*
* Contenido de microTwitterUI generado por $author$
 */
package presenters.security;

import presenters.IndexPresenter;
import presenters.LoginPresenter;
import sources.api.sourceApi;
import sources.api.repositoryApi;
import views.IndexView;
import views.LoginView;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Factory {

    private static final repositoryApi SOURCE = new sourceApi();

    public static LoginPresenter createLoginPresenter(LoginView view) {
        return new LoginPresenter(view, SOURCE);
    }

    public static IndexPresenter createIndexPresenter(IndexView view) {
        return new IndexPresenter(view, SOURCE);
    }

}
