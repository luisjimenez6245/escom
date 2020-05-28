/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Table extends Model {

    public Attribute[] attributes;
    public int databaseId;
    public String name;
    public int tableId;

    public Table(int tableId) {
        this.tableId = tableId;
    }

    public Table build(Attribute[] attributes, int databaseId, String name) {
        this.attributes = attributes;
        this.databaseId = databaseId;
        this.name = name;
        return this;
    }

}
