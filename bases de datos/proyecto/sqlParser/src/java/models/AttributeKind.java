/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class AttributeKind extends Model {

    public int minValue;
    public int attributeKindId;
    public int maxValue;
    public String name;
    public String description;
    public String sqlSyntax;

    public AttributeKind(int attributeKindId) {
        this.attributeKindId = attributeKindId;
    }

    public AttributeKind build(int minValue, int maxValue, String name, String description, String sqlSyntax) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.name = name;
        this.description = description;
        this.sqlSyntax = sqlSyntax;
        return this;
    }

}
