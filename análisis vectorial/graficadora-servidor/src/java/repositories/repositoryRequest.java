/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import objects.Parametrics;
import objects.User;

/**
 *
 * @author luis
 */
public interface repositoryRequest {

    public User getUser();

    public String getAction();

    public String getOption();
    
    public Parametrics getParametrics();

}
