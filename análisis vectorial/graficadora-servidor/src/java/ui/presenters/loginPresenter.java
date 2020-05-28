/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.presenters;

import objects.User;
import repositories.repositoryAPI;
import ui.view.loginView;

/**
 *
 * @author luis
 */
public class loginPresenter {

    private final loginView view;
    private final repositoryAPI source;

    public loginPresenter(loginView view, repositoryAPI source) {
        this.view = view;
        this.source = source;
    }

    public void onLoginClick(User user) {
        if (!user.email.equals("")) {
            if (!user.password.equals("")) {
                user = source.authUser(user);
                if (user != null) {
                    if (user.id > 0) {
                        if (user.isActive) {
                            view.submit(user);
                        } else {
                            view.showDisableAccount();
                        }
                    } else {
                        view.showError();
                    }
                } else {
                    view.showNoAccount();
                }
            } else {
                view.showPasswordError();
            }
        } else {
            view.showEmailError();
        }
    }

    public void onNewAccountClick() {
        view.newAccount();
    }

    public void onRegisterClick(User user) {
        user.type = "Type2";
        user = source.saveUser(user);
        if (user.id > 0) {
            view.showDisableAccount();
        } else {
            view.showError();
        }
    }

    public void onOldAccountClik() {
        view.view("");
    }

}
