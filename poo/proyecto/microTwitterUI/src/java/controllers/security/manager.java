/*
* Contenido de microTwitterUI generado por $author$
*/

package controllers.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;


/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class manager {

    public static String APPNAME =  "grapher";
    public static String DOMAIN = "http://localhost";
   // public static String DOMAIN = "http://192.168.1.72";
    public static String URL = DOMAIN + ":8080/grapher";
    private final Properties configProp = new Properties();
    
    private manager() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("app.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
        }
    }

    private static class LazyHolder {

        private static final manager INSTANCE = new manager();
    }

    public static manager getInstance() {
        return LazyHolder.INSTANCE;
    }

    public boolean isDebug() {
        if (containsKey("debug")) {
            return true;
        } else {
            return configProp.getProperty("debug").equals("true");
        }
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return configProp.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return configProp.containsKey(key);
    }

}
