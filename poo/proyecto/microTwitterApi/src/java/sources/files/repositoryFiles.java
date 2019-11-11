/*
* Contenido de microTwitterApi generado por $author$
*/

package sources.files;

import java.io.File;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public interface repositoryFiles {

    public String readFile(String file);

    public boolean writeFile(File file);

    public boolean writeFile(String file);
    
    public boolean createDirectory(String name);

}
