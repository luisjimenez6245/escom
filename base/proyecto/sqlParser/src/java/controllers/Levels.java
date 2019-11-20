/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package controllers;

import controllers.utils.iController;
import models.Level;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Levels extends iController<Level>{

    public Levels(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Level object) {
        res = JSON.toJson(source.getLevel(object));
    }

    @Override
    public void getList(Level object) {
        res = JSON.toJson(source.getLevelList(object));
    }

    @Override
    public void save(Level object) {
        res = JSON.toJson(source.saveLevel(object));
    }

    @Override
    public void delete(Level object) {
        res = "" + source.deleteLevel(object.levelId);
    }

    @Override
    public void update(Level object) {
        res = JSON.toJson(source.setLevel(object));
    }
    
}
