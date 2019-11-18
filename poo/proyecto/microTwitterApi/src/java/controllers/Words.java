/*
* Contenido de microTwitterApi generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.Word;
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
        res = JSON.toJson(source.saveWord(object));
    }

    @Override
    public void delete(Word object) {
        res = "" + source.deleteWord(object.wordId);
    }

    @Override
    public void update(Word object) {
        res = JSON.toJson(source.setWord(object));
    }
    
}
