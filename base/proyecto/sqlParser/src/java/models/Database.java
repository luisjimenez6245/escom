/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Database extends Model {

    public Tables[] tables;
    public String url;
    public String name;
    public int databaseId;

    public Database(int databaseId) {
        this.databaseId = databaseId;
    }

    public Database build(Tables[] tables, String url, String name) {
        this.tables = tables;
        this.url = url;
        this.name = name;
        return this;
    }

}
