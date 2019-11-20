/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package controllers;

import controllers.utils.iController;
import models.User;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Users extends iController<User>{

    public Users(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(User object) {
        res = JSON.toJson(source.getUser(object));
    }

    @Override
    public void getList(User object) {
        res = JSON.toJson(source.getUserList(object));
    }

    @Override
    public void save(User object) {
        res = JSON.toJson(source.saveUser(object));
    }

    @Override
    public void delete(User object) {
        res = "" + source.deleteUser(object.userId);
    }

    @Override
    public void update(User object) {
        res = JSON.toJson(source.setUser(object));
    }
    
}
