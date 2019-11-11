/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;
import objects.User;
import objects.Tweet;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Like extends object<Like> {

    public User user;
public Tweet tweet;
public Date date;
public int like_id;

public Like(int like_id){
this.like_id=like_id;
}

public/ Like /build( User user, Tweet tweet, Date date){
this.user=user;
this.tweet=tweet;
this.date=date;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"user:"+this.user
+"tweet:"+this.tweet
+"date:"+this.date
+"like_id:"+this.like_id

                + "}";
    }

}
