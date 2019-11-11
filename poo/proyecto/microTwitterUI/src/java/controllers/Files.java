/*
* Contenido de microTwitterUI generado por $author$
*/

package controllers;

import controllers.utils.iController;
import models.File;
import sources.api.sourceApi;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class Files extends iController<File>{

    public Files(sourceApi source){
        super(source);
    }

    @Override
    public void get(File object) {
        res = JSON.toJson(source.getFile(object));
    }

    @Override
    public void getList(File object) {
        res = JSON.toJson(source.getFileList(object));
    }

    @Override
    public void save(File object) {
        res = JSON.toJson(source.getFile(object));
    }

    @Override
    public void delete(File object) {
        res = "" + source.deleteFile(object.fileId);
    }

    @Override
    public void update(File object) {
        res = JSON.toJson(source.setFile(object));
    }
    
}
