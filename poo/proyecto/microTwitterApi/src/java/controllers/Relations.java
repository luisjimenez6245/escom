/*
* Contenido de microTwitterApi generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.Relation;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Relations extends iController<Relation>{

    public Relations(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Relation object) {
        res = JSON.toJson(source.getRelation(object));
    }

    @Override
    public void getList(Relation object) {
        res = JSON.toJson(source.getRelationList(object));
    }

    @Override
    public void save(Relation object) {
        res = JSON.toJson(source.getRelation(object));
    }

    @Override
    public void delete(Relation object) {
        res = "" + source.deleteRelation(object.relationId);
    }

    @Override
    public void update(Relation object) {
        res = JSON.toJson(source.setRelation(object));
    }
    
}
