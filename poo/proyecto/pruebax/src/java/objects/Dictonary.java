/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;
import objects.Word;
import objects.Language;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Dictonary extends object<Dictonary> {

    public String translate;
public Word word;
public Language language;
public int dictonary_id;

public Dictonary(int dictonary_id){
this.dictonary_id=dictonary_id;
}

public/ Dictonary /build( String translate, Word word, Language language){
this.translate=translate;
this.word=word;
this.language=language;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"translate:"+this.translate
+"word:"+this.word
+"language:"+this.language
+"dictonary_id:"+this.dictonary_id

                + "}";
    }

}
