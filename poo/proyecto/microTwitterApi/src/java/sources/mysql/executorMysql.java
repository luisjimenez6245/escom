/*
* Contenido de microTwitterApi generado por $author$
 */
package sources.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Diego Jiménez Delgado
 */
public class executorMysql {

    private final String DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
    private final String BASEURL = "jdbc:mysql://$url$:$port$/dbName?allowPublicKeyRetrieval=true&useSSL=false&useServerPrepStmts=true";
    private Connection connection = null;
    private final boolean debug = false;

    public executorMysql(String user, String password, String dbName, String url, String port) {
        if (debug) {
            connection = conectar("", "", "", "", "");
        } else {
            connection = conectar(user, password, dbName, url, port);
        }
    }

    private Connection conectar(String user, String password, String dbName, String url, String port) {
        try {
            String urlBD = BASEURL;
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
        if (verifyConnection()) {
            PreparedStatement state = this.connection.prepareStatement(query);
            if (parametros != null) {
                for (int i = 0; i < parametros.length; ++i) {
                    state.setObject(i + 1, parametros[i]);
                }
            }
            return state.executeQuery();
        }
        return null;
    }

    private int executeUpdate(String query, Object[] parametros) throws SQLException {
        if (verifyConnection()) {
            PreparedStatement state;
            if (query.toLowerCase().contains("insert")) {
                state = this.connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            } else {
                state = this.connection.prepareStatement(query);
            }
            if (parametros != null) {
                for (int i = 0; i < parametros.length; ++i) {
                    state.setObject(i + 1, parametros[i]);
                }
            }
            state.execute();
            if (query.toLowerCase().contains("insert")) {
                ResultSet res = state.getGeneratedKeys();
                return res.next() ? res.getInt(1) : 0;
            }

        }
        return 0;
    }

    public ResultSet save(String tableName, Map<String, Object> parametros) {
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
        int id;
        try {
            id = this.executeUpdate(query, mapToArray(parametros));
            HashMap<String, Object> param = new HashMap<>();
            param.put(tableName + "_id", id);
            return this.get("select * from " + tableName + " ", param);
        } catch (SQLException ex) {
            Logger.getLogger(executorMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet get(String query, Map<String, Object> parametros) {
        return getList(query, parametros);
    }

    public ResultSet getList(String query, Map<String, Object> parametros) {
        if (parametros != null && parametros.size() > 0) {
            String valores = " where ";
            valores = parametros.entrySet().stream().map((param) -> param.getKey() + " = ? AND ").reduce(valores, String::concat);
            valores = valores.substring(0, valores.length() - 5);
            query += valores + ";";
        }
        try {
            ResultSet r = executeQuery(query, mapToArray(parametros));
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(executorMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet set(String query, Map<String, Object> parametros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long delete(String query, Map<String, Object> parametros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object[] mapToArray(Map<String, Object> parametros) {
        ArrayList<Object> helper = new ArrayList<>();
        parametros.entrySet().forEach((r) -> {
            helper.add(r.getValue());
        });
        return helper.toArray(new Object[helper.size()]);
    }

}
