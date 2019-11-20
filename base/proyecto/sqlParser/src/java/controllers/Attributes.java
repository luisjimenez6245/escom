/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package controllers;

import controllers.utils.iController;
import models.Attribute;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Attributes extends iController<Attribute>{

    public Attributes(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Attribute object) {
        res = JSON.toJson(source.getAttribute(object));
    }

    @Override
    public void getList(Attribute object) {
        res = JSON.toJson(source.getAttributeList(object));
    }

    @Override
    public void save(Attribute object) {
        res = JSON.toJson(source.saveAttribute(object));
    }

    @Override
    public void delete(Attribute object) {
        res = "" + source.deleteAttribute(object.attributeId);
    }

    @Override
    public void update(Attribute object) {
        res = JSON.toJson(source.setAttribute(object));
    }
    
}
