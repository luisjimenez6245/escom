/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;
import java.util.Date;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Like extends Model {

    public int likeId;
    public User user;
    public Date date;
    public Tweet tweet;

    public Like(int likeId) {
        this.likeId = likeId;
    }

    public Like build(User user, Date date, Tweet tweet) {
        this.user = user;
        this.date = date;
        this.tweet = tweet;
        return this;
    }

}
