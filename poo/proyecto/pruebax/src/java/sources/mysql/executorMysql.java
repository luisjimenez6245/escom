/*
* Contenido generado de pruebax
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
public class executorMysql{

    private String usrBD = "root";
    private String passBD = "Siul6245";
    private String dbName = "usuarios";
    private String urlBD = "jdbc:mysql://localhost:3306/dbName?allowPublicKeyRetrieval=true&useSSL=false&useServerPrepStmts=true";
    // private String urlBD = "jdbc:mysql://187.221.116.149:3306/dbName?allowPublicKeyRetrieval=true&useSSL=false";
    private final String DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
    private Connection conn = null;
    private PreparedStatement state = null;
    private ResultSet res = null;

    protected executorMysql(String user, String pswd, String url, String dbName) {
        this.usrBD = user;
        this.passBD = pswd;
        this.urlBD = url;
        this.dbName = dbName;
    }

    protected executorMysql(String url) {
        this.urlBD = url;
    }

    protected executorMysql() {
    }

    protected executorMysql(String user, String pswd) {
        this.usrBD = user;
        this.passBD = pswd;
    }

    protected void conectar() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        urlBD = urlBD.replace("dbName", dbName);
        Class.forName(this.DRIVERCLASSNAME).newInstance();
        this.conn = DriverManager.getConnection(this.urlBD, this.usrBD, this.passBD);
    }

    protected void cierraConexion() throws SQLException {
        new Thread(() -> {
            try {
                if (state != null) {
                    if (!state.isClosed()) {
                        state.close();
                    }
                }
                if (res != null) {
                    if (!res.isClosed()) {
                        res.close();
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                new logger().errorBd(ex);
            }
        }).start();
    }

    protected void kill() throws SQLException {
        conn.abort((Runnable command) -> {
            try {
                Statement st = (Statement) conn.createStatement();
                res = st.executeQuery("select * from information_schema.processlist where DB =  '" + dbName + "';");
                ArrayList<Integer> id = new ArrayList<>();
                while (res.next()) {
                    id.add(res.getInt("id"));
                }
                for (int i = id.size() - 1; i > 0; --i) {
                    st.executeUpdate("KILL " + id.get(i) + ";");
                }
                state.close();
            } catch (SQLException ex) {
                new logger().errorBd(ex);
            }
        });
    }

    private ResultSet preparedS(String consulta, String[] parametros) throws SQLException {
        state = this.conn.prepareStatement(consulta);
        for (int i = 1; i < parametros.length + 1; i++) {
            state.setString(i, parametros[i - 1]);
        }
        res = state.executeQuery();
        return res;
    }

    private ResultSet executeQuery(String query,  Object[] parametros) throws SQLException {
        state = this.conn.prepareStatement(query);
        if (parametros != null) {
            for (int i = 0; i < parametros.length; ++i) {
                state.setString(i + 1, parametros[i - 1].toString());
            }
        }
        return state.executeQuery();
    }

    private int executeUpdate(String query, Object[] parametros) throws SQLException {
        state = this.conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        if (parametros != null) {
            for (int i = 0; i < parametros.length; ++i) {
                state.setString(i + 1, parametros[i - 1].toString());
            }
        }
        state.execute();
        return 0;
    }

    /*
    protected ResultSet get(String query, Map<String, Object> parametros) throws SQLException {
        if (parametros != null && parametros.size() > 0) {
            String valores = "where ";
            valores = parametros.stream().map((param) -> param.getKey() + " = ? and ").reduce(valores, String::concat);
            valores = valores.substring(0, valores.length() - 5);
            query += valores + ";";
        }
        return executeQuery(query, parametros);
    }

    protected int save(String query,  Map<String, Object> parametros) throws SQLException {
        if (parametros != null) {
            String keys = "(";
            String valores = "(";
            for (Pair<String, String> param : parametros) {
                keys += "" + param.getKey() + ", ";
                valores += "?,";
            }
            valores = valores.substring(0, valores.length() - 1) + ")";
            keys = keys.substring(0, keys.length() - 2) + ")";
            query += keys + " VALUES " + valores + ";";
        }
        this.executeUpdate(query, parametros);
        res = state.getGeneratedKeys();
        int id = -1;
        if (res.next()) {
            id = res.getInt(1);
        }
        return id;
    }

    protected int update(String query,  Map<String, Object> values, Map<String, Object> parametros) throws SQLException {
        Map<String, Object> ls = new HashMap<String, Object>();
        if (values != null) {
            String valores = " set ";
            valores = values.stream().map((param) -> param.getKey() + " = ?, ").reduce(valores, String::concat);
            valores = valores.substring(0, valores.length() - 2);
            query += valores;
            values.forEach((p) -> {
                ls.add(p);
            });
        }
        if (parametros != null) {
            String where = " where ";
            where = parametros.stream().map((param) -> param.getKey() + " = ? and ").reduce(where, String::concat);
            where = where.substring(0, where.length() - 5);
            query += where;
            parametros.forEach((p) -> {
                ls.add(p);
            });

        }
        query += ";";

        return executeUpdate(query, ls);
    }

    /*protected void delete(String query, Map<String, Object> parametros) throws SQLException {
        if (parametros != null) {
            String where = " where ";
            where = parametros.stream().map((param) -> param.getKey() + " = ? and ").reduce(where, String::concat);
            where = where.substring(0, where.length() - 5);
            query += where;
        }
        query += ";";
        System.out.println(query);
        executeUpdate(query, parametros);
    }*/

    public <T> T save(String tableName, Map<String, Object> parametros, Method mapper) throws Exception {
        tableName =  tableName.toLowerCase();
        String query =  "Insert into " + tableName +  " ";
        if (parametros != null) {
            String keys = "(";
            String valores = "(";
            for( Map.Entry<String, Object> param : parametros.entrySet()) {
                keys += "" + param.getKey() + ", ";
                valores += "?,";
            }
            valores = valores.substring(0, valores.length() - 1) + ")";
            keys = keys.substring(0, keys.length() - 2) + ")";
            query += keys + " VALUES " + valores + ";";
        }
        this.executeUpdate(query, parametros);
        res = state.getGeneratedKeys();
        int id = -1;
        if (res.next()) {
            id = res.getInt(1);
        }
        HashMap<String, Object> param =  new HashMap<>();
        param.put("id_" + tableName , id);
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
        return (T[]) mapper.invoke(this, executeQuery(query, parametros));
    }

    public <T> T update(String query, Map<String, Object> parametros, Method mapper) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long delete(String query, Map<String, Object> parametros) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}