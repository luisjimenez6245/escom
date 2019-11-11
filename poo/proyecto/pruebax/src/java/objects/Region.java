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

public class Region extends object<Region> {

    public Country country;
public boolean isActive;
public String name;
public int region_id;

public Region(int region_id){
this.region_id=region_id;
}

public/ Region /build( Country country, boolean isActive, String name){
this.country=country;
this.isActive=isActive;
this.name=name;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"country:"+this.country
+"isActive:"+this.isActive
+"name:"+this.name
+"region_id:"+this.region_id

                + "}";
    }

}
