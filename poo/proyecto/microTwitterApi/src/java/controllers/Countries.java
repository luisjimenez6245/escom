/*
* Contenido de microTwitterApi generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.Country;
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
        res = JSON.toJson(source.saveCountry(object));
    }

    @Override
    public void delete(Country object) {
        res = "" + source.deleteCountry(object.countryId);
    }

    @Override
    public void update(Country object) {
        res = JSON.toJson(source.setCountry(object));
    }
    
}
