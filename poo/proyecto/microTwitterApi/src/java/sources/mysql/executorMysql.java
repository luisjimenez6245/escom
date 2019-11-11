/*
* Contenido de microTwitterApi generado por $author$
*/
package sources.mysql;

import controllers.security.logger;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class executorMysql {

    private final String DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
    private final String BASEURL = "jdbc:mysql://$url$:3306/dbName?allowPublicKeyRetrieval=true&useSSL=false&useServerPrepStmts=true";
    private String dbName = "";
    private Connection connection = null;
    private boolean debug;

    public executorMysql() {
        if (debug) {
            connection = conectar("", "", "", "", "");
        } else {
            connection = conectar("", "", "", "", "");
        }
    }

    private Connection conectar(String user, String password, String dbName, String url, String port) {
        try {
            String urlBD = BASEURL;
            this.dbName = dbName;
            urlBD = urlBD.replace("dbName", dbName).replace("$url$", url).replace("$port$", port);
            Class.forName(this.DRIVERCLASSNAME).newInstance();
            return DriverManager.getConnection(urlBD, user, password);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println(ex.fillInStackTrace());
        }
        return null;
    }

    private boolean verifyConnection() {
        if (this.connection == null) {
            this.connection = conectar("", "", "", "", "");
        }
        return connection != null;
    }

    private ResultSet executeQuery(String query, Object[] parametros) throws SQLException {
        PreparedStatement state = this.connection.prepareStatement(query);
        if (parametros != null) {
            for (int i = 0; i < parametros.length; ++i) {
                state.setObject(i + 1, parametros[i - 1]);
            }
        }
        return state.executeQuery();
    }

    private int executeUpdate(String query, Object[] parametros) throws SQLException {
        PreparedStatement state = this.connection.prepareStatement(query);
        if (parametros != null) {
            for (int i = 0; i < parametros.length; ++i) {
                state.setObject(i + 1, parametros[i - 1]);
            }
        }
        state.execute();
        return 0;
    }

    public <T> T save(String tableName, Map<String, Object> parametros, Method mapper) throws Exception {
        tableName = tableName.toLowerCase();
        String query = "Insert into " + tableName + " ";
        if (parametros != null) {
            String keys = "(";
            String valores = "(";
            for (Map.Entry<String, Object> param : parametros.entrySet()) {
                keys += "" + param.getKey() + ", ";
                valores += "?,";
            }
            valores = valores.substring(0, valores.length() - 1) + ")";
            keys = keys.substring(0, keys.length() - 2) + ")";
            query += keys + " VALUES " + valores + ";";
        }
        this.executeUpdate(query, mapToArray(parametros));
       /* res = state.getGeneratedKeys();
        int id = -1;
        if (res.next()) {
            id = res.getInt(1);
        }*/
        HashMap<String, Object> param = new HashMap<>();
        //param.put("id_" + tableName, id);
        return this.get("select * from", param, mapper);
    }

    public <T> T get(String query, Map<String, Object> parametros, Method mapper) throws Exception {
        return (T) getList(query, parametros, mapper)[0];
    }

    public <T> T[] getList(String query, Map<String, Object> parametros, Method mapper) throws Exception {
        if (parametros != null && parametros.size() > 0) {
            String valores = "where ";
            valores = parametros.entrySet().stream().map((param) -> param.getKey() + " = ? AND ").reduce(valores, String::concat);
            valores = valores.substring(0, valores.length() - 5);
            query += valores + ";";
        }
        return (T[]) mapper.invoke(this, executeQuery(query, mapToArray(parametros)));
    }

    public <T> T update(String query, Map<String, Object> parametros, Method mapper) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long delete(String query, Map<String, Object> parametros) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Object[] mapToArray(Map<String, Object> parametros){
        ArrayList<Object> helper =  new ArrayList<>();
        parametros.entrySet().forEach((r) -> {
            helper.add(r.getValue());
        });
        return helper.toArray(new Object[helper.size()]);
    }

}
