/*
* Contenido de microTwitterApi generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.Dictonary;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Dictonaries extends iController<Dictonary>{

    public Dictonaries(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Dictonary object) {
        res = JSON.toJson(source.getDictonary(object));
    }

    @Override
    public void getList(Dictonary object) {
        res = JSON.toJson(source.getDictonaryList(object));
    }

    @Override
    public void save(Dictonary object) {
        res = JSON.toJson(source.getDictonary(object));
    }

    @Override
    public void delete(Dictonary object) {
        res = "" + source.deleteDictonary(object.dictonaryId);
    }

    @Override
    public void update(Dictonary object) {
        res = JSON.toJson(source.setDictonary(object));
    }
    
}
