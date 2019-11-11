/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;
import objects.Language;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Country extends object<Country> {

    public String extension;
public boolean isActive;
public Language language;
public String name;
public int country_id;

public Country(int country_id){
this.country_id=country_id;
}

public/ Country /build( String extension, boolean isActive, Language language, String name){
this.extension=extension;
this.isActive=isActive;
this.language=language;
this.name=name;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"extension:"+this.extension
+"isActive:"+this.isActive
+"language:"+this.language
+"name:"+this.name
+"country_id:"+this.country_id

                + "}";
    }

}
