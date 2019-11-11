/*
* Contenido de microTwitterUI generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.Phone;
import sources.api.sourceApi;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Phones extends iController<Phone>{

    public Phones(sourceApi source){
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
        res = "" + source.deletePhone(object.phoneId);
    }

    @Override
    public void update(Phone object) {
        res = JSON.toJson(source.setPhone(object));
    }
    
}
