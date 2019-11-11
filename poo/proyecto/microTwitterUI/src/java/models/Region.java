/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Region extends Model {

    public boolean isActive;
    public int regionId;
    public String name;
    public Country country;

    public Region(int regionId) {
        this.regionId = regionId;
    }

    public Region build(boolean isActive, String name, Country country) {
        this.isActive = isActive;
        this.name = name;
        this.country = country;
        return this;
    }

}
