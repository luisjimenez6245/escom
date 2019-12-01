package sources.mysql;

import controllers.security.Logger;
import controllers.security.Manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubSource {

    private Executor exec;
    private final Logger LOGGER = new Logger();

    public SubSource() {
    }

    public boolean check(String query, String dbName, String url) {
        String res = query.toLowerCase();
        try {
            try {
                exec = new Executor(Manager.getInstance().getProperty("dbTestUser"), Manager.getInstance().getProperty("dbTestPassword"), dbName, url, Manager.getInstance().getProperty("dbPort"));
                if (res.contains("select")) {
                    checkQuery(query);
                } else {
                    checkUpdate(query);
                }
                exec.closeConnection();
                res = "";
            } catch (SQLException ex) {
                res = ex.getMessage();
            }
            exec.closeConnection();
        } catch (SQLException ex) {
            LOGGER.error(ex);
            res = ex.getSQLState();
        }
        return !res.toLowerCase().contains("your sql syntax");
    }

    private void checkQuery(String query) throws SQLException {
        exec.executeQuery(query);
    }

    private void checkUpdate(String query) throws SQLException {
        exec.executeUpdate(query);
    }

    private class Executor {

        private final String DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
        private final String BASEURL = "jdbc:mysql://$url$:$port$/dbName?allowPublicKeyRetrieval=true&useSSL=false&useServerPrepStmts=true";
        private Connection connection = null;

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
            Statement state;
            if (query.toLowerCase().contains("insert")) {
                state = this.connection.createStatement(1, PreparedStatement.RETURN_GENERATED_KEYS);
            } else {
                state = this.connection.createStatement();
            }
            state.execute(query);
            if (query.toLowerCase().contains("insert")) {
                ResultSet res = state.getGeneratedKeys();
                return res.next() ? res.getInt(1) : 0;
            }

            return 0;
        }

        public ResultSet executeQuery(String query) throws SQLException {
            Statement state = this.connection.createStatement();
            return state.executeQuery(query);
        }
    }
}
