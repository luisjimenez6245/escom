/*
* Contenido generado de pruebax
*/

package objects;

import objects.util.object;
import objects.enums.FileType;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class File extends object<File> {

    public FileType fileType;
public String extension;
public String name;
public int file_id;

public File(int file_id){
this.file_id=file_id;
}

public/ File /build( FileType fileType, String extension, String name){
this.fileType=fileType;
this.extension=extension;
this.name=name;
return this;
}



    @Override
    public String toJSON() {
        return "{"
    +"fileType:"+this.fileType
+"extension:"+this.extension
+"name:"+this.name
+"file_id:"+this.file_id

                + "}";
    }

}
