/*
* Contenido de microTwitterApi generado por $author$
 */
package models;

import models.utils.Model;
import models.enums.FileType;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class File extends Model {

    public int fileId;
    public String name;
    public FileType fileType;
    public String extension;

    public File(int fileId) {
        this.fileId = fileId;
    }

    public File build(String name, FileType fileType, String extension) {
        this.name = name;
        this.fileType = fileType;
        this.extension = extension;
        return this;
    }

}
