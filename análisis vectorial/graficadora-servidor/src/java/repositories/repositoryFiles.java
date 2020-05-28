package repositories;

import java.io.File;

/**
 *
 * @author luis
 */
public interface repositoryFiles {

    public String readFile(String file);

    public boolean writeFile(File file);

    public boolean writeFile(String file);
    
    public boolean createDirectory(String name);

}
