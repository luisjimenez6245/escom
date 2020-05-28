/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.view;

import objects.User;

/**
 *
 * @author luis
 */
public interface loginView extends iView {

    public abstract void newAccount();

    public abstract void showPasswordError();

    public abstract void showEmailError();
    
    public abstract void showError();
    
    public abstract void submit(User user);

    public abstract void showDisableAccount();
    
    public abstract void showNoAccount();

}
