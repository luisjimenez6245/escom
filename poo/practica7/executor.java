import java.util.HashMap;
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.*;

public class executor {

    //compile: javac -cp "./mysql.jar" executor.java
    //excecute: java -cp ".:./mysql.jar" executor 
    public static void main(String[] args) {
        new Formulario();
    }

}

class Formulario implements ActionListener {
    private JFrame principal;
    private JLabel LNombre;
    private JLabel LRaza;
    private JLabel LEdad;
    private JLabel LGenero;
    private JTextField TNombre;
    private JTextField TRaza;
    private JTextField TEdad;
    private JTextField TGenero;
    private JButton insertar;
    private JButton conect;
    private executorMysql exec;

    public Formulario() {

        principal = new JFrame("Perros");
        LNombre = new JLabel("Nombre: ");
        LRaza = new JLabel("Raza: ");
        LEdad = new JLabel("Edad: ");
        LGenero = new JLabel("Genero: ");
        TNombre = new JTextField();
        TRaza = new JTextField();
        TEdad = new JTextField();
        TGenero = new JTextField();
        insertar = new JButton("Enviar");
        insertar.addActionListener(this);
        conect = new JButton("Conectar");
        conect.addActionListener(this);
        principal.setLayout(new GridLayout(5, 2));
        principal.add(LNombre);
        principal.add(TNombre);
        principal.add(LRaza);
        principal.add(TRaza);
        principal.add(LEdad);
        principal.add(TEdad);
        principal.add(LGenero);
        principal.add(TGenero);
        principal.add(conect);
        principal.add(insertar);
        principal.setSize(500, 500);
        principal.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b.getText().equals("Conectar")) {
            exec = new executorMysql("root", "Siul6245", "Perros", "localhost", "3306");
        } else {
            if (exec != null) {
                String nombre = (String) TNombre.getText();
                String raza = (String) TRaza.getText();
                int edad = Integer.parseInt(TEdad.getText());
                String genero = (String) TGenero.getText();
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("nombre", nombre);
                parameters.put("raza", raza);
                parameters.put("edad", edad);
                parameters.put("genero", genero);
                exec.save("tableName", parameters);
            }
            else{

            }
        }

    }
}

class executorMysql {

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

    public ResultSet save(String tableName, Map<String, Object> parameters) {
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

    public ResultSet get(String query, Map<String, Object> parameters) {
        return getList(query, parameters);
    }

    public ResultSet getList(String query, Map<String, Object> parameters) {
        if (parameters != null && parameters.size() > 0) {
            String valores = " WHERE ";
            valores = parameters.entrySet().stream().map((param) -> param.getKey() + " = ? AND ").reduce(valores,
                    String::concat);
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

    public ResultSet set(String query, Map<String, Object> parameters, Map<String, Object> conditions) {
        if (parameters != null && parameters.size() > 0) {
            String valores = " SET ";
            valores = parameters.entrySet().stream().map((param) -> param.getKey() + " = ?, ").reduce(valores,
                    String::concat);
            valores = valores.substring(0, valores.length() - 3);
            query += valores + " ";
        }
        if (conditions != null && conditions.size() > 0) {
            String valores = " WHERE ";
            valores = conditions.entrySet().stream().map((param) -> param.getKey() + " = ? AND ").reduce(valores,
                    String::concat);
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

    public Long delete(String tableName, Map<String, Object> parameters) {
        String query = "DELETE FROM " + tableName + " ";
        if (parameters != null && parameters.size() > 0) {
            String valores = "WHERE ";
            valores = parameters.entrySet().stream().map((param) -> param.getKey() + " = ? AND ").reduce(valores,
                    String::concat);
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

    private Object[] mapToArray(Map<String, Object> parameters) {
        ArrayList<Object> helper = new ArrayList<>();
        parameters.entrySet().forEach((r) -> {
            helper.add(r.getValue());
        });
        return helper.toArray(new Object[helper.size()]);
    }

}
