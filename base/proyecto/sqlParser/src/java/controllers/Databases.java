/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package controllers;

import controllers.utils.iController;
import models.Database;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Databases extends iController<Database>{

    public Databases(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Database object) {
        res = JSON.toJson(source.getDatabase(object));
    }

    @Override
    public void getList(Database object) {
        res = JSON.toJson(source.getDatabaseList(object));
    }

    @Override
    public void save(Database object) {
        res = JSON.toJson(source.saveDatabase(object));
    }

    @Override
    public void delete(Database object) {
        res = "" + source.deleteDatabase(object.databaseId);
    }

    @Override
    public void update(Database object) {
        res = JSON.toJson(source.setDatabase(object));
    }
    
}
