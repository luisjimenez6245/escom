/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package controllers;

import controllers.utils.iController;
import models.AttributeKind;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class AttributesKind extends iController<AttributeKind>{

    public AttributesKind(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(AttributeKind object) {
        res = JSON.toJson(source.getAttributeKind(object));
    }

    @Override
    public void getList(AttributeKind object) {
        res = JSON.toJson(source.getAttributeKindList(object));
    }

    @Override
    public void save(AttributeKind object) {
        res = JSON.toJson(source.saveAttributeKind(object));
    }

    @Override
    public void delete(AttributeKind object) {
        res = "" + source.deleteAttributeKind(object.attributeKindId);
    }

    @Override
    public void update(AttributeKind object) {
        res = JSON.toJson(source.setAttributeKind(object));
    }
    
}
