/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Word extends object<Word> {

    public String name;
public int word_id;

public Word(int word_id){
this.word_id=word_id;
}

public/ Word /build( String name){
this.name=name;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"name:"+this.name
+"word_id:"+this.word_id

                + "}";
    }

}
