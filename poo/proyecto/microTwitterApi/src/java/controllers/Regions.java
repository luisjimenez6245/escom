/*
* Contenido de microTwitterApi generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.Region;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Regions extends iController<Region>{

    public Regions(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Region object) {
        res = JSON.toJson(source.getRegion(object));
    }

    @Override
    public void getList(Region object) {
        res = JSON.toJson(source.getRegionList(object));
    }

    @Override
    public void save(Region object) {
        res = JSON.toJson(source.saveRegion(object));
    }

    @Override
    public void delete(Region object) {
        res = "" + source.deleteRegion(object.regionId);
    }

    @Override
    public void update(Region object) {
        res = JSON.toJson(source.setRegion(object));
    }
    
}
