/*
* Contenido generado de pruebax
*/

package sources.console;

import controllers.security.logger;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class sourceConsole extends executorConsole implements sources.console.repositoryConsole {

    public final logger ERROR = new logger();
    public final String FILELOCATION = "/Users/luis/Documents/GitHub/python-grapher/";
    public final String PYTHON3 = "/usr/local/bin/python3 ";
    // public final String PYTHON3 = "python3 ";
    //public final String FILELOCATION = "/home/luis/git/python-grapher/";

    @Override
    public String test(String exec) {
        try {
            return this.execute(exec, null);
        } catch (Exception ex) {
            ERROR.error(ex);
        }
        return null;
    }

}
