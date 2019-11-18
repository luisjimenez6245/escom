package presenters;

import sources.api.repositoryApi;
import views.LoginView;

/**
 *
 * @author luis
 */
public class LoginPresenter {

    private final LoginView view;
    private final repositoryApi source;

    public LoginPresenter(LoginView view, repositoryApi source) {
        this.view = view;
        this.source = source;
    }

}
