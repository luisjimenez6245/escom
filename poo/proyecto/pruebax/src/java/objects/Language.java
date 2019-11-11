/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Language extends object<Language> {

    public boolean isActive;
public String name;
public int language_id;

public Language(int language_id){
this.language_id=language_id;
}

public/ Language /build( boolean isActive, String name){
this.isActive=isActive;
this.name=name;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"isActive:"+this.isActive
+"name:"+this.name
+"language_id:"+this.language_id

                + "}";
    }

}
