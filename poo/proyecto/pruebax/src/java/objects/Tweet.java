/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;
import objects.User;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Tweet extends object<Tweet> {

    public IsComent isComent;
public User user;
public boolean isRetweet;
public String content;
public Long parent;
public Date creationDate;
public int tweet_id;

public Tweet(int tweet_id){
this.tweet_id=tweet_id;
}

public/ Tweet /build( IsComent isComent, User user, boolean isRetweet, String content, Long parent, Date creationDate){
this.isComent=isComent;
this.user=user;
this.isRetweet=isRetweet;
this.content=content;
this.parent=parent;
this.creationDate=creationDate;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"isComent:"+this.isComent
+"user:"+this.user
+"isRetweet:"+this.isRetweet
+"content:"+this.content
+"parent:"+this.parent
+"creationDate:"+this.creationDate
+"tweet_id:"+this.tweet_id

                + "}";
    }

}
