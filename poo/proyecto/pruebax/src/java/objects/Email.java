/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Email extends object<Email> {

    public boolean isPrincipal;
public boolean isValid;
public String email;
public boolean isActive;
public int email_id;

public Email(int email_id){
this.email_id=email_id;
}

public/ Email /build( boolean isPrincipal, boolean isValid, String email, boolean isActive){
this.isPrincipal=isPrincipal;
this.isValid=isValid;
this.email=email;
this.isActive=isActive;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"isPrincipal:"+this.isPrincipal
+"isValid:"+this.isValid
+"email:"+this.email
+"isActive:"+this.isActive
+"email_id:"+this.email_id

                + "}";
    }

}
