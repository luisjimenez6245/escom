/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;
import objects.File;
import objects.Language;
import objects.Phone;
import objects.Email;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class User extends object<User> {

    public Date creationDate;
public File photo;
public String password;
public int user_id;
public String surname;
public boolean isActive;
public Language language;
public UserType userType;
public String name;
public Phone[] phones;
public Email[] emails;

public User(int user_id){
this.user_id=user_id;
}

public/ User /build( Date creationDate, File photo, String password, String surname, boolean isActive, Language language, UserType userType, String name, Phone[] phones, Email[] emails){
this.creationDate=creationDate;
this.photo=photo;
this.password=password;
this.surname=surname;
this.isActive=isActive;
this.language=language;
this.userType=userType;
this.name=name;
this.phones=phones;
this.emails=emails;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"creationDate:"+this.creationDate
+"photo:"+this.photo
+"password:"+this.password
+"user_id:"+this.user_id
+"surname:"+this.surname
+"isActive:"+this.isActive
+"language:"+this.language
+"userType:"+this.userType
+"name:"+this.name
+"phones:"+this.phones
+"emails:"+this.emails

                + "}";
    }

}
