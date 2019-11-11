/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class Dictonary extends Model {

    public int dictonaryId;
    public String translate;
    public Language language;
    public Word word;

    public Dictonary(int dictonaryId) {
        this.dictonaryId = dictonaryId;
    }

    public Dictonary build(String translate, Language language, Word word) {
        this.translate = translate;
        this.language = language;
        this.word = word;
        return this;
    }

}
