package sources.api;

import java.io.ByteArrayOutputStream;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 *
 * @author luisjimenezdelgado
 */
public class executorAPI {

    //private final String URL = "http://13.59.58.71:4004/v1";
    private final String URL = "http://localhost:4004/v1";

    private final int CONNECT_TIME_OUT = 30000;
    private final int READ_OUT_TIME = 50000;
    private final String BOUNDARY_STRING = getBoundary();

    public executorAPI() {
    }

    public String queryRequest(String query, String method, HashMap<String, String> map) throws Exception {
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

    public String formRequest(String query, String method, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception {
        String b = "";
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry) iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            b += key + "=" + value + "&";
        }

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, b);
        Request request;
        if (method.equals("POST")) {
            request = new Request.Builder()
                    .url(URL + query)
                    .post(body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("Postman-Token", "66056101-6deb-4815-ab08-fe8531248561")
                    .build();
        } else {
            request = new Request.Builder()
                    .url(URL + query)
                    .put(body)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("cache-control", "no-cache")
                    .addHeader("Postman-Token", "66056101-6deb-4815-ab08-fe8531248561")
                    .build();
        }
        okhttp3.Response response = client.newCall(request).execute();

        return new String(response.body().bytes(), StandardCharsets.UTF_8);

    }

    /*public String formRequest(String query, String method, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception {
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
    }*/
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
