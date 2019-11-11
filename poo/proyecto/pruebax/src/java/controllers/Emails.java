/*
* Contenido generado de pruebax
*/

package controllers;

import controllers.utils.iController;
import objects.Email;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Emails extends iController<Email>{

    public Emails(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Email object) {
        res = JSON.toJson(source.getEmail(object));
    }

    @Override
    public void getList(Email object) {
        res = JSON.toJson(source.getEmailList(object));
    }

    @Override
    public void save(Email object) {
        res = JSON.toJson(source.getEmail(object));
    }

    @Override
    public void delete(Email object) {
        res = "" + source.deleteEmail(object.email_id);
    }

    @Override
    public void update(Email object) {
        res = JSON.toJson(source.setEmail(object));
    }
    
}
