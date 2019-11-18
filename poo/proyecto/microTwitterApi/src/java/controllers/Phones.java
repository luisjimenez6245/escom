/*
* Contenido de microTwitterApi generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.Phone;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Phones extends iController<Phone>{

    public Phones(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Phone object) {
        res = JSON.toJson(source.getPhone(object));
    }

    @Override
    public void getList(Phone object) {
        res = JSON.toJson(source.getPhoneList(object));
    }

    @Override
    public void save(Phone object) {
        res = JSON.toJson(source.savePhone(object));
    }

    @Override
    public void delete(Phone object) {
        res = "" + source.deletePhone(object.phoneId);
    }

    @Override
    public void update(Phone object) {
        res = JSON.toJson(source.setPhone(object));
    }
    
}
