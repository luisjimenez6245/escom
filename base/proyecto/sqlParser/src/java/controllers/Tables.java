/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package controllers;

import controllers.utils.iController;
import models.Table;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Tables extends iController<Table>{

    public Tables(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Table object) {
        res = JSON.toJson(source.getTable(object));
    }

    @Override
    public void getList(Table object) {
        res = JSON.toJson(source.getTableList(object));
    }

    @Override
    public void save(Table object) {
        res = JSON.toJson(source.saveTable(object));
    }

    @Override
    public void delete(Table object) {
        res = "" + source.deleteTable(object.tableId);
    }

    @Override
    public void update(Table object) {
        res = JSON.toJson(source.setTable(object));
    }
    
}
