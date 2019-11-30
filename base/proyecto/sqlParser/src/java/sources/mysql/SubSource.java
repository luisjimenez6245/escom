package sources.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubSource {

    private Executor exec;
    
   
    private class Executor {

        private final String DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
        private final String BASEURL = "jdbc:mysql://$url$:$port$/dbName?allowPublicKeyRetrieval=true&useSSL=false&useServerPrepStmts=true";
        private Connection connection = null;
        private final boolean debug = false;

        public Executor(String user, String password, String dbName, String url, String port) {
            connection = conectar(user, password, dbName, url, port);
        }

        public void closeConnection() throws SQLException {
            if (!connection.isClosed()) {
                connection.close();
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

        public ResultSet executeQuery(String query, Object[] parameters) throws SQLException {
            PreparedStatement state = this.connection.prepareStatement(query);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; ++i) {
                    state.setObject(i + 1, parameters[i]);
                }
            }
            return state.executeQuery();

        }

        public int executeUpdate(String query, Object[] parameters) throws SQLException {
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
            return 0;
        }

        public int executeUpdate(String query) throws SQLException {
            PreparedStatement state;
            if (query.toLowerCase().contains("insert")) {
                state = this.connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            } else {
                state = this.connection.prepareStatement(query);
            }
            state.execute();
            if (query.toLowerCase().contains("insert")) {
                ResultSet res = state.getGeneratedKeys();
                return res.next() ? res.getInt(1) : 0;
            }

            return 0;
        }
    }
}
