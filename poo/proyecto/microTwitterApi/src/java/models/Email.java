/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Email extends Model {

    public boolean isValid;
    public boolean isPrincipal;
    public boolean isActive;
    public int emailId;
    public int userId;
    public String email;

    public Email(int emailId) {
        this.emailId = emailId;
    }

    public Email build(int userId, boolean isValid, boolean isPrincipal, boolean isActive, String email) {
        this.userId =  userId;
        this.isValid = isValid;
        this.isPrincipal = isPrincipal;
        this.isActive = isActive;
        this.email = email;
        return this;
    }

}
