/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Attribute extends Model {

    public AttributeKind attributeKind;
    public String name;
    public int tableId;
    public int attributeId;

    public Attribute(int attributeId) {
        this.attributeId = attributeId;
    }

    public Attribute build(AttributeKind attributeKind, String name, int tableId) {
        this.attributeKind = attributeKind;
        this.name = name;
        this.tableId = tableId;
        return this;
    }

}
