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

    public Table[] table;
    public String url;
    public String name;
    public int databaseId;

    public Database(int databaseId) {
        this.databaseId = databaseId;
    }

    public Database build(Table[] table, String url, String name) {
        this.table = table;
        this.url = url;
        this.name = name;
        return this;
    }

}
