/*
* Contenido generado de pruebax
*/

package controllers;

import controllers.utils.iController;
import objects.Word;
import sources.mysql.repositoryMysql;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Words extends iController<Word>{

    public Words(repositoryMysql source){
        super(source);
    }

    @Override
    public void get(Word object) {
        res = JSON.toJson(source.getWord(object));
    }

    @Override
    public void getList(Word object) {
        res = JSON.toJson(source.getWordList(object));
    }

    @Override
    public void save(Word object) {
        res = JSON.toJson(source.getWord(object));
    }

    @Override
    public void delete(Word object) {
        res = "" + source.deleteWord(object.word_id);
    }

    @Override
    public void update(Word object) {
        res = JSON.toJson(source.setWord(object));
    }
    
}
