/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
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

public class Manager {

    public static String APPNAME =  "sqlParser";
    public static String DOMAIN = "http://localhost";
   // public static String DOMAIN = "http://192.168.1.72";
    public static String URL = DOMAIN + ":8080/sqlParser";
    private final Properties configProp = new Properties();
    
    private Manager() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("app.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
        }
    }

    private static class LazyHolder {

        private static final Manager INSTANCE = new Manager();
    }

    public static Manager getInstance() {
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
