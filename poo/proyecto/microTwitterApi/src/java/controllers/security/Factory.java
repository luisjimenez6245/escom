/*
* Contenido de microTwitterApi generado por $author$
 */
package controllers.security;

import sources.mysql.sourceMysql;
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
public class Factory {

    private static final manager MAN = manager.getInstance();
    private static final sourceMysql SOURCE = new sourceMysql(MAN.getProperty("dbUser"),MAN.getProperty("dbPassword"), MAN.getProperty("dbName"), MAN.getProperty("dbUrl"), MAN.getProperty("dbPort"));

    public static Languages createLanguages() {
        return new Languages(SOURCE);
    }

    public static Countries createCountries() {
        return new Countries(SOURCE);
    }

    public static Files createFiles() {
        return new Files(SOURCE);
    }

    public static Emails createEmails() {
        return new Emails(SOURCE);
    }

    public static Phones createPhones() {
        return new Phones(SOURCE);
    }

    public static Words createWords() {
        return new Words(SOURCE);
    }

    public static Dictonaries createDictonaries() {
        return new Dictonaries(SOURCE);
    }

    public static Regions createRegions() {
        return new Regions(SOURCE);
    }

    public static Users createUsers() {
        return new Users(SOURCE);
    }

    public static Tweets createTweets() {
        return new Tweets(SOURCE);
    }

    public static Likes createLikes() {
        return new Likes(SOURCE);
    }

    public static Relations createRelations() {
        return new Relations(SOURCE);
    }

    public static Notifications createNotifications() {
        return new Notifications(SOURCE);
    }

}
