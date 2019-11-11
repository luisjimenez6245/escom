/*
* Contenido generado de pruebax
*/

package controllers;

import controllers.utils.iController;
import objects.Tweet;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Tweets extends iController<Tweet>{

    public Tweets(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Tweet object) {
        res = JSON.toJson(source.getTweet(object));
    }

    @Override
    public void getList(Tweet object) {
        res = JSON.toJson(source.getTweetList(object));
    }

    @Override
    public void save(Tweet object) {
        res = JSON.toJson(source.getTweet(object));
    }

    @Override
    public void delete(Tweet object) {
        res = "" + source.deleteTweet(object.tweet_id);
    }

    @Override
    public void update(Tweet object) {
        res = JSON.toJson(source.setTweet(object));
    }
    
}
