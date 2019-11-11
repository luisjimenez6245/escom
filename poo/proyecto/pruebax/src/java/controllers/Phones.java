/*
* Contenido generado de pruebax
*/

package controllers;

import controllers.utils.iController;
import objects.Phone;
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
        res = JSON.toJson(source.getPhone(object));
    }

    @Override
    public void delete(Phone object) {
        res = "" + source.deletePhone(object.phone_id);
    }

    @Override
    public void update(Phone object) {
        res = JSON.toJson(source.setPhone(object));
    }
    
}
