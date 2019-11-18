/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Phone extends Model {

    public boolean isValid;
    public String phone;
    public boolean isPrincipal;
    public boolean isActive;
    public int phoneId;
    public int userId;
    public Country country;

    public Phone(int phoneId) {
        this.phoneId = phoneId;
    }

    public Phone build(int userId, boolean isValid, String phone, boolean isPrincipal, boolean isActive, Country country) {
        this.userId = userId;
        this.isValid = isValid;
        this.phone = phone;
        this.isPrincipal = isPrincipal;
        this.isActive = isActive;
        this.country = country;
        return this;
    }

}
