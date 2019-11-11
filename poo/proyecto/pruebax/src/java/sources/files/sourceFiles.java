/*
* Contenido generado de pruebax
*/

package sources.files;

import controllers.security.logger;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class sourceFiles extends executorFiles implements sources.files.repositoryFiles {
    
    private final logger ERROR = new logger();
    private final mapperFiles MAPPER = new mapperFiles();

    @Override
    public boolean writeFile(File file) {
        return false;
    }

    @Override
    public boolean writeFile(String file) {
        return false;
    }

    @Override
    public String readFile(String file) {
        try{
            return this.getFile(file);
        }
        catch(IOException ex){
            ERROR.error(ex);
        }
        return "";
    }
    
    @Override
    public boolean createDirectory(String name){
        String res = this.saveDirectory(name);
        return (res != null ) && (!res.equals(""));
    }

}
