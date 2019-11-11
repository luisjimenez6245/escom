/*
* Contenido generado de pruebax
*/

package controllers;

import controllers.utils.iController;
import objects.Country;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Countries extends iController<Country>{

    public Countries(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Country object) {
        res = JSON.toJson(source.getCountry(object));
    }

    @Override
    public void getList(Country object) {
        res = JSON.toJson(source.getCountryList(object));
    }

    @Override
    public void save(Country object) {
        res = JSON.toJson(source.getCountry(object));
    }

    @Override
    public void delete(Country object) {
        res = "" + source.deleteCountry(object.country_id);
    }

    @Override
    public void update(Country object) {
        res = JSON.toJson(source.setCountry(object));
    }
    
}
