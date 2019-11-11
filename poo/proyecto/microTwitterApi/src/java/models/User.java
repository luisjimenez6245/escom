/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;
import models.enums.UserType;
import java.util.Date;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class User extends Model {

    public UserType userType;
    public Date creationDate;
    public Language language;
    public Email[] emails;
    public boolean isActive;
    public int userId;
    public File photo;
    public String password;
    public String surname;
    public String name;
    public Phone[] phones;

    public User(int userId) {
        this.userId = userId;
    }

    public User build(UserType userType, Date creationDate, Language language, Email[] emails, boolean isActive, File photo, String password, String surname, String name, Phone[] phones) {
        this.userType = userType;
        this.creationDate = creationDate;
        this.language = language;
        this.emails = emails;
        this.isActive = isActive;
        this.photo = photo;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.phones = phones;
        return this;
    }

}
