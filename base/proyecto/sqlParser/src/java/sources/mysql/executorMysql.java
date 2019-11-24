/*
* MySQL executor
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

    private ResultSet executeQuery(String query, Object[] parameters) throws SQLException {
        if (verifyConnection()) {
            PreparedStatement state = this.connection.prepareStatement(query);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; ++i) {
                    state.setObject(i + 1, parameters[i]);
                }
            }
            return state.executeQuery();
        }
        return null;
    }

    private int executeUpdate(String query, Object[] parameters) throws SQLException {
        if (verifyConnection()) {
            PreparedStatement state;
            if (query.toLowerCase().contains("insert")) {
                state = this.connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            } else {
                state = this.connection.prepareStatement(query);
            }
            if (parameters != null) {
                for (int i = 0; i < parameters.length; ++i) {
                    state.setObject(i + 1, parameters[i]);
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

    protected ResultSet save(String tableName, Map<String, Object> parameters) {
        tableName = tableName.toLowerCase();
        String query = "INSERT INTO " + tableName + " ";
        if (parameters != null) {
            String keys = "(";
            String valores = "(";
            for (Map.Entry<String, Object> param : parameters.entrySet()) {
                keys += "" + param.getKey() + ", ";
                valores += "?,";
            }
            valores = valores.substring(0, valores.length() - 1) + ")";
            keys = keys.substring(0, keys.length() - 2) + ")";
            query += keys + " VALUES " + valores + ";";
        }
        int id;
        try {
            id = this.executeUpdate(query, mapToArray(parameters));
            HashMap<String, Object> param = new HashMap<>();
            param.put(tableName + "_id", id);
            return this.get("SELECT * FROM " + tableName + " ", param);
        } catch (SQLException ex) {
            Logger.getLogger(executorMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected ResultSet get(String query, Map<String, Object> parameters) {
        return getList(query, parameters);
    }

    protected ResultSet getList(String query, Map<String, Object> parameters) {
        if (parameters != null && parameters.size() > 0) {
            String valores = " WHERE ";
            valores = parameters.entrySet().stream().map((param) -> param.getKey() + " = ? AND ").reduce(valores, String::concat);
            valores = valores.substring(0, valores.length() - 5);
            query += valores + ";";
        }
        try {
            ResultSet r = executeQuery(query, mapToArray(parameters));
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(executorMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected ResultSet set(String query, Map<String, Object> parameters, Map<String, Object> conditions) {
        if (parameters != null && parameters.size() > 0) {
            String valores = " SET ";
            valores = parameters.entrySet().stream().map((param) -> param.getKey() + " = ?, ").reduce(valores, String::concat);
            valores = valores.substring(0, valores.length() - 3);
            query += valores + " ";
        }
        if (conditions != null && conditions.size() > 0) {
            String valores = " WHERE ";
            valores = conditions.entrySet().stream().map((param) -> param.getKey() + " = ? AND ").reduce(valores, String::concat);
            valores = valores.substring(0, valores.length() - 5);
            query += valores + ";";
        }
        try {
            ResultSet r = executeQuery(query, mapToArray(parameters));
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(executorMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    protected Long delete(String tableName, Map<String, Object> parameters) {
        String query = "DELETE FROM " + tableName + " ";
        if (parameters != null && parameters.size() > 0) {
            String valores = "WHERE ";
            valores = parameters.entrySet().stream().map((param) -> param.getKey() + " = ? AND ").reduce(valores, String::concat);
            valores = valores.substring(0, valores.length() - 5);
            query += valores + ";";
        }
        try {
            this.executeUpdate(query, mapToArray(parameters));
            return 0L;
        } catch (SQLException ex) {
            Logger.getLogger(executorMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Object[] mapToArray(Map<String, Object> parameters) {
        ArrayList<Object> helper = new ArrayList<>();
        parameters.entrySet().forEach((r) -> {
            helper.add(r.getValue());
        });
        return helper.toArray(new Object[helper.size()]);
    }

}
