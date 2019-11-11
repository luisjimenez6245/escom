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
public class Tweet extends Model {

    public File media;
    public User user;
    public Date creationDate;
    public int tweetId;
    public boolean isRetweet;
    public String content;
    public Long parent;
    public boolean isComent;

    public Tweet(int tweetId) {
        this.tweetId = tweetId;
    }

    public Tweet build(File media, User user, Date creationDate, boolean isRetweet, String content, Long parent, boolean isComent) {
        this.media = media;
        this.user = user;
        this.creationDate = creationDate;
        this.isRetweet = isRetweet;
        this.content = content;
        this.parent = parent;
        this.isComent = isComent;
        return this;
    }

}
