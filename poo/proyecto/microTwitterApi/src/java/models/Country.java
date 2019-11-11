/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Country extends Model {

    public Language language;
    public boolean isActive;
    public int countryId;
    public String extension;
    public String name;

    public Country(int countryId) {
        this.countryId = countryId;
    }

    public Country build(Language language, boolean isActive, String extension, String name) {
        this.language = language;
        this.isActive = isActive;
        this.extension = extension;
        this.name = name;
        return this;
    }

}
