/*
* Contenido generado de pruebax
*/

package controllers;

import controllers.utils.iController;
import objects.Like;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Likes extends iController<Like>{

    public Likes(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Like object) {
        res = JSON.toJson(source.getLike(object));
    }

    @Override
    public void getList(Like object) {
        res = JSON.toJson(source.getLikeList(object));
    }

    @Override
    public void save(Like object) {
        res = JSON.toJson(source.getLike(object));
    }

    @Override
    public void delete(Like object) {
        res = "" + source.deleteLike(object.like_id);
    }

    @Override
    public void update(Like object) {
        res = JSON.toJson(source.setLike(object));
    }
    
}
