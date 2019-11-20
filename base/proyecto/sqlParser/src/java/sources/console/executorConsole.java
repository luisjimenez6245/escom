/*
* Contenido de sqlParser generado por Luis Diego Jiménez Delgado en el 2019
*/

package sources.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */

public class executorConsole {

    String res;

    protected String execute(String command, HashMap<String, String> map) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        command = parameters(map, command);
        System.out.println(command);
        String[] cmd = {"/bin/bash", "-c", command};
        processBuilder.command(cmd);
        Process process = processBuilder.start();
        res = getInput(process.getInputStream()) + getInput(process.getErrorStream());
        System.out.println("res");
        return res;
    }

    protected void asyncExecute(String command, HashMap<String, String> map) throws Exception {
        new Thread(new Runnable() {
            public void run() {
                try {
                    execute(command, map);
                } catch (Exception ex) {
                    Logger.getLogger(executorConsole.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    protected String awaitExecute(String command, HashMap<String, String> map) throws Exception {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    res = execute(command, map);
                } catch (Exception ex) {
                    Logger.getLogger(executorConsole.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
        while (t.isAlive()) {
        }
        return res;
    }

    private String parameters(HashMap<String, String> map, String exec) {
        if (map != null) {
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry) iter.next();
                String key = entry.getKey();
                String value = entry.getValue();
                exec = exec.replace(("$" + key + "$"), value);
            }
        }
        return exec;
    }

    private String parameters(HashMap<String, String> map) {
        String r = "";
        if (map != null) {
            r += "?";
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry) iter.next();
                String key = entry.getKey();
                String value = entry.getValue();
                r += key + " " + value + " ";
            }
            r = r.substring(0, r.length() - 1);
        }
        return r;
    }

    private String getInput(InputStream stream) throws IOException {
        String r = "";
        String helper = "";
        try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(stream))) {
            while ((helper = stdInput.readLine()) != null) {
                r += helper;
            }
        }
        return r;
    }

}
