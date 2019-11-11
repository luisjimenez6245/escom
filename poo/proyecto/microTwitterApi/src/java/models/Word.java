/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Word extends Model {

    public int wordId;
    public String name;

    public Word(int wordId) {
        this.wordId = wordId;
    }

    public Word build(String name) {
        this.name = name;
        return this;
    }

}
