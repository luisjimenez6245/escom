/*
* Contenido generado de pruebax
*/

package controllers.security;

import sources.mysql.sourceMysql;
import/ controllersLanguages;
import/ controllersCountries;
import/ controllersFiles;
import/ controllersEmails;
import/ controllersPhones;
import/ controllersWords;
import/ controllersDictonaries;
import/ controllersRegions;
import/ controllersUsers;
import/ controllersTweets;
import/ controllersLikes;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Factory{

    private static sourceMysql source = new sourceMysql();
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


}
