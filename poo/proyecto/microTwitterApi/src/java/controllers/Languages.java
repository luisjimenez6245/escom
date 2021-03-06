/*
* Contenido de microTwitterApi generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.Language;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Languages extends iController<Language>{

    public Languages(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Language object) {
        res = JSON.toJson(source.getLanguage(object));
    }

    @Override
    public void getList(Language object) {
        res = JSON.toJson(source.getLanguageList(object));
    }

    @Override
    public void save(Language object) {
        res = JSON.toJson(source.saveLanguage(object));
    }

    @Override
    public void delete(Language object) {
        res = "" + source.deleteLanguage(object.languageId);
    }

    @Override
    public void update(Language object) {
        res = JSON.toJson(source.setLanguage(object));
    }
    
}
