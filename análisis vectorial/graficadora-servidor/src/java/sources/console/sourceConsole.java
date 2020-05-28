package sources.console;

import controllers.security.logger;
import java.util.HashMap;
import objects.Parametrics;

/**
 *
 * @author luis
 */
public class sourceConsole extends executorConsole implements repositories.repositoryConsole {

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

    @Override
    public String getSurface(Parametrics param, String name) {
        String exec = PYTHON3 + FILELOCATION + "surface.py surface \"$t$\" \"$s$\" \"$x$\" \"$y$\" \"$z$\"";
        HashMap<String, String> map = new HashMap<>();
        map.put("x", param.x);
        map.put("y", param.y);
        map.put("z", param.z);
        map.put("t", param.t);
        map.put("s", param.s);
        map.put("name", name);
        map.put("point", "" + param.point);
        try {
            return this.awaitExecute(exec, map);
        } catch (Exception ex) {
            ERROR.error(ex);
        }
        return null;
    }

    @Override
    public String get3d(Parametrics param, String name) {
        String exec = PYTHON3 + FILELOCATION + "app.py \"$name$\" 3d \"$t$\" \"$s$\" xyz \"$x$\" \"$y$\" \"$z$\"";
        HashMap<String, String> map = new HashMap<>();
        map.put("x", param.x);
        map.put("y", param.y);
        map.put("z", param.z);
        map.put("t", param.t);
        map.put("s", param.s);
        map.put("name", name);
        try {
            return this.awaitExecute(exec, map);
        } catch (Exception ex) {
            ERROR.error(ex);
        }
        return null;
    }

    @Override
    public String get2d(Parametrics param, String name) {
        String exec = PYTHON3 + FILELOCATION + "app.py \"$name$\" 2d \"$t$\" \"$s$\" xyz \"$x$\" \"$y$\" \"$z$\"";
        HashMap<String, String> map = new HashMap<>();
        map.put("x", param.x);
        map.put("y", param.y);
        map.put("z", param.z);
        map.put("t", param.t);
        map.put("s", param.s);
        map.put("name", name);
        try {
            return this.awaitExecute(exec, map);
        } catch (Exception ex) {
            ERROR.error(ex);
        }
        return null;
    }

    @Override
    public void get3dAsync(Parametrics param, String name) {
        String exec = PYTHON3 + FILELOCATION + "app.py \"$name$\" 3d $point$ \"$t$\" \"$s$\" xyz \"$x$\" \"$y$\" \"$z$\"";
        HashMap<String, String> map = new HashMap<>();
        map.put("x", param.x);
        map.put("y", param.y);
        map.put("z", param.z);
        map.put("t", param.t);
        map.put("s", param.s);
        map.put("name", name);
        map.put("point", "" + param.point);
        try {
            this.asyncExecute(exec, map);
        } catch (Exception ex) {
            ERROR.error(ex);
        }
    }

    @Override
    public void get2dAsync(Parametrics param, String name) {
        String exec = PYTHON3 + FILELOCATION + "app.py \"$name$\" 2d $point$ \"$t$\" \"$s$\" xy \"$x$\" \"$y$\"";
        HashMap<String, String> map = new HashMap<>();
        map.put("x", param.x);
        map.put("y", param.y);
        map.put("t", param.t);
        map.put("s", param.s);
        map.put("name", name);
        map.put("point", "" + param.point);
        try {
            this.asyncExecute(exec, map);
        } catch (Exception ex) {
            ERROR.error(ex);
        }
    }

    @Override
    public void getSurfaceAsync(Parametrics param, String name) {
        String exec = PYTHON3 + FILELOCATION + "surface.py surface \"$t$\" \"$s$\" \"$x$\" \"$y$\" \"$z$\"";
        HashMap<String, String> map = new HashMap<>();
        map.put("x", param.x);
        map.put("y", param.y);
        map.put("z", param.z);
        map.put("t", param.t);
        map.put("s", param.s);
        map.put("name", name);
        map.put("point", "" + param.point);
        try {
            this.asyncExecute(exec, map);
        } catch (Exception ex) {
            ERROR.error(ex);
        }
    }

}
