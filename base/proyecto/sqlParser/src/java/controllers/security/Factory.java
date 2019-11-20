/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package controllers.security;

import sources.mysql.repositoryMysql;
import sources.mysql.sourceMysql;
import controllers.Emails;
import controllers.Phones;
import controllers.Users;
import controllers.Levels;
import controllers.Queries;
import controllers.AttributesKind;
import controllers.Attributes;
import controllers.Tables;
import controllers.Databases;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Factory {

    private static final manager MAN = manager.getInstance();
    private static final repositoryMysql SOURCE = new sourceMysql(MAN.getProperty("dbUser"),MAN.getProperty("dbPassword"), MAN.getProperty("dbName"), MAN.getProperty("dbUrl"), MAN.getProperty("dbPort"));


    public static Emails createEmails() {
        return new Emails(SOURCE);
    }

    public static Phones createPhones() {
        return new Phones(SOURCE);
    }

    public static Users createUsers() {
        return new Users(SOURCE);
    }

    public static Levels createLevels() {
        return new Levels(SOURCE);
    }

    public static Queries createQueries() {
        return new Queries(SOURCE);
    }

    public static AttributesKind createAttributesKind() {
        return new AttributesKind(SOURCE);
    }

    public static Attributes createAttributes() {
        return new Attributes(SOURCE);
    }

    public static Tables createTables() {
        return new Tables(SOURCE);
    }

    public static Databases createDatabases() {
        return new Databases(SOURCE);
    }

}
