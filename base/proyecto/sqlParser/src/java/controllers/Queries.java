/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package controllers;

import controllers.utils.iController;
import models.Query;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Queries extends iController<Query>{

    public Queries(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Query object) {
        res = JSON.toJson(source.getQuery(object));
    }

    @Override
    public void getList(Query object) {
        res = JSON.toJson(source.getQueryList(object));
    }

    @Override
    public void save(Query object) {
        res = JSON.toJson(source.saveQuery(object));
    }

    @Override
    public void delete(Query object) {
        res = "" + source.deleteQuery(object.queryId);
    }

    @Override
    public void update(Query object) {
        res = JSON.toJson(source.setQuery(object));
    }
    
}
