/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Language extends Model {

    public boolean isActive;
    public int languageId;
    public String name;

    public Language(int languageId) {
        this.languageId = languageId;
    }

    public Language build(boolean isActive, String name) {
        this.isActive = isActive;
        this.name = name;
        return this;
    }

}
