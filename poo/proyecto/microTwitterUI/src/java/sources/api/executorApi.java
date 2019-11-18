/*
* Contenido de microTwitterUI generado por $author$
 */
package sources.api;

import controllers.security.manager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class executorApi {

    private final String URL;
    private final int CONNECT_TIME_OUT = 30000;
    private final int READ_OUT_TIME = 50000;
    private final String BOUNDARY_STRING = getBoundary();

    public executorApi() {
        URL = manager.getInstance().getProperty("apiURL");
    }

    protected String save(String url, HashMap<String, Object> map, HashMap<String, byte[]> fileMap) {
        try {
            return formRequest(url, "POST", map, fileMap);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    protected String set(String url, HashMap<String, Object> map, HashMap<String, byte[]> fileMap) {
        try {
            return formRequest(url, "PUT", map, fileMap);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    protected String get(String url, HashMap<String, Object> map) {
        try {
            return queryRequest(url, "GET", map);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    protected String getList(String url, HashMap<String, Object> map) {
        try {
            return queryRequest(url + "/list/", "GET", map);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    protected String delete(String url, HashMap<String, Object> map) {
        try {
            return queryRequest(url, "DELETE", map);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return null;
    }

    private String queryRequest(String query, String method, HashMap<String, Object> map) throws Exception {
        if (map != null) {
            query += "?";
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry) iter.next();
                String key = entry.getKey();
                String value = entry.getValue();
                query += key + "=" + value + "&";
            }
            query = query.substring(0, query.length() - 1);
        }
        HttpURLConnection conne = conecta(new URL(URL + query), method, "");

        return new String(handleResponse(conne), StandardCharsets.UTF_8);
    }

    private String formRequest(String query, String method, HashMap<String, Object> map, HashMap<String, byte[]> fileMap) throws Exception {
        HttpURLConnection conne = conecta(new URL(URL + query), method, "multipart/form-data");
        try (DataOutputStream obos = new DataOutputStream(conne.getOutputStream())) {
            if (map == null) {
                return null;
            }
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry) iter.next();
                String key = entry.getKey();
                String value = entry.getValue();
                obos.writeBytes("--" + BOUNDARY_STRING + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + key
                        + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.writeBytes(value + "\r\n");
            }
            if (fileMap != null && fileMap.size() > 0) {
                for (Map.Entry<String, byte[]> fileEntry : fileMap.entrySet()) {
                    obos.writeBytes("--" + BOUNDARY_STRING + "\r\n");
                    obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey()
                            + "\"; filename=\"" + encode(" ") + "\"\r\n");
                    obos.writeBytes("\r\n");
                    obos.write(fileEntry.getValue());
                    obos.writeBytes("\r\n");
                }
            }
            obos.writeBytes("--" + BOUNDARY_STRING + "--" + "\r\n");
            obos.writeBytes("\r\n");
            obos.flush();
        }
        return new String(handleResponse(conne), StandardCharsets.UTF_8);
    }

    private byte[] handleResponse(HttpURLConnection conne) throws IOException {
        InputStream ins;
        int code = conne.getResponseCode();
        if (code == 200) {
            ins = conne.getInputStream();
        } else {
            ins = conne.getErrorStream();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        int len;
        while ((len = ins.read(buff)) != -1) {
            baos.write(buff, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        ins.close();
        return bytes;
    }

    private HttpURLConnection conecta(URL url, String method, String dataType) throws IOException {
        HttpURLConnection conne = (HttpURLConnection) url.openConnection();
        method = method.toUpperCase();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod(method);
        conne.setConnectTimeout(CONNECT_TIME_OUT);
        conne.setReadTimeout(READ_OUT_TIME);
        conne.setRequestProperty("accept", "*/*");
        conne.setRequestProperty("Content-Type", dataType + "; boundary=" + BOUNDARY_STRING);
        conne.setRequestProperty("connection", "Keep-Alive");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        return conne;
    }

    private String getBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 32; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }

    private String encode(String value) throws Exception {
        return URLEncoder.encode(value, "UTF-8");
    }

}
