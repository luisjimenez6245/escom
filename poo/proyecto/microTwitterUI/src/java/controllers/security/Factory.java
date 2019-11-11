/*
* Contenido de microTwitterUI generado por $author$
*/

package controllers.security;

import sources.api.sourceApi;
import controllers.Languages;
import controllers.Countries;
import controllers.Files;
import controllers.Emails;
import controllers.Phones;
import controllers.Words;
import controllers.Dictonaries;
import controllers.Regions;
import controllers.Users;
import controllers.Tweets;
import controllers.Likes;
import controllers.Relations;
import controllers.Notifications;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Factory{

    private static sourceApi source = new sourceApi();

    public static Languages createLanguages(){
return new Languages(source);
}

public static Countries createCountries(){
return new Countries(source);
}

public static Files createFiles(){
return new Files(source);
}

public static Emails createEmails(){
return new Emails(source);
}

public static Phones createPhones(){
return new Phones(source);
}

public static Words createWords(){
return new Words(source);
}

public static Dictonaries createDictonaries(){
return new Dictonaries(source);
}

public static Regions createRegions(){
return new Regions(source);
}

public static Users createUsers(){
return new Users(source);
}

public static Tweets createTweets(){
return new Tweets(source);
}

public static Likes createLikes(){
return new Likes(source);
}

public static Relations createRelations(){
return new Relations(source);
}

public static Notifications createNotifications(){
return new Notifications(source);
}


}
