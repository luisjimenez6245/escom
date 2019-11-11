/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;
import objects.Country;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Phone extends object<Phone> {

    public boolean isPrincipal;
public Country country;
public boolean isValid;
public boolean isActive;
public String phone;
public int phone_id;

public Phone(int phone_id){
this.phone_id=phone_id;
}

public/ Phone /build( boolean isPrincipal, Country country, boolean isValid, boolean isActive, String phone){
this.isPrincipal=isPrincipal;
this.country=country;
this.isValid=isValid;
this.isActive=isActive;
this.phone=phone;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"isPrincipal:"+this.isPrincipal
+"country:"+this.country
+"isValid:"+this.isValid
+"isActive:"+this.isActive
+"phone:"+this.phone
+"phone_id:"+this.phone_id

                + "}";
    }

}
