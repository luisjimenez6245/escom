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

    // compile: javac -cp "./mysql.jar" executor.java
    // excecute: java -cp ".:./mysql.jar" executor
    public static void main(String[] args) {
        new Formulario();
    }

}

class Formulario extends Controller implements ActionListener {

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
    private JButton consult;
    private executorMysql exec;

    public Formulario() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    protected void loadView() {
        setVisible(true);
        setTitle("Perros");
        setSize(500, 500);
        LNombre = new JLabel("Nombre: ");
        LRaza = new JLabel("Raza: ");
        LEdad = new JLabel("Edad: ");
        LGenero = new JLabel("Genero: ");
        TNombre = new JTextField();
        TRaza = new JTextField();
        TEdad = new JTextField();
        TGenero = new JTextField();
        LNombre.setFont(new Font("Arial", Font.PLAIN, 25));
        LRaza.setFont(new Font("Arial", Font.PLAIN, 25));
        LEdad.setFont(new Font("Arial", Font.PLAIN, 25));
        TNombre.setFont(new Font("Arial", Font.PLAIN, 25));
        LGenero.setFont(new Font("Arial", Font.PLAIN, 25));
        TRaza.setFont(new Font("Arial", Font.PLAIN, 25));
        TEdad.setFont(new Font("Arial", Font.PLAIN, 25));
        TGenero.setFont(new Font("Arial", Font.PLAIN, 25));
        insertar = new JButton("Enviar");
        conect = new JButton("Conectar");
        consult = new JButton("Consultar");
    }

    @Override
    protected void loadContent() {
        this.setLayout(new GridLayout(6, 2));
        this.add(LNombre);
        this.add(TNombre);
        this.add(LRaza);
        this.add(TRaza);
        this.add(LEdad);
        this.add(TEdad);
        this.add(LGenero);
        this.add(TGenero);
        this.add(conect);
        this.add(insertar);
        this.add(consult);
    }

    @Override
    protected void loadActions() {
        insertar.addActionListener(this);
        conect.addActionListener(this);
        consult.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == conect) {
            checkConection();
        } else {
            if (b == insertar) {
                try {
                    String nombre = (String) TNombre.getText();
                    String raza = (String) TRaza.getText();
                    int edad = Integer.parseInt(TEdad.getText());
                    String genero = (String) TGenero.getText();
                    register(nombre, raza, edad, genero);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "La edad no es valida");
                }
            } else {
                getItems();
            }
        }
    }

    private void checkConection() {
        if (exec == null) {
            exec = new executorMysql("root", "Siul6245", "Perros", "localhost", "3306");
            JOptionPane.showMessageDialog(rootPane, "Conectado Exitosamente");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ya estabas conectado.");
        }
    }

    private void register(String nombre, String raza, int edad, String genero) {
        if (exec != null) {
            HashMap<String, Object> parameters = new HashMap<>();
            parameters.put("nombre", nombre);
            parameters.put("raza", raza);
            parameters.put("edad", edad);
            parameters.put("genero", genero);
            exec.save("tableName", parameters);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No te haz conecatdo. :(");
        }
    }

    private void getItems() {
        if (exec != null) {
            HashMap<String, Object> parameters = new HashMap<>();
            String items = "";
            try {
                ResultSet r = exec.getList("Select * from tableName ", parameters);
                while (r.next()) {
                    items += "Perro:";
                    items += " Nombre:" + r.getString("nombre") + "";
                    items += "\t Raza:" + r.getString("raza") + "";
                    items += "\t Edad:" + r.getString("edad") + "";
                    items += "\t Género:" + r.getString("genero") + "\n";
                }
                r.close();
                JTextArea output = new JTextArea(items);
                output.setSize(620, 420);
                JScrollPane scroll = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scroll.setBounds(420, 0, 620, 420);
                JOptionPane.showMessageDialog(rootPane,scroll, "Lista de Perros",JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Ocurrió un error:" + ex.toString());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No te haz conecatdo. :(");
        }
    }
}

abstract class Controller extends JFrame {

    private static final long serialVersionUID = -6691512838218834379L;

    public Controller() {
        loadView();
        loadContent();
        loadActions();
        this.invalidate();
        this.validate();
        this.repaint();
    }

    protected abstract void loadView();

    protected abstract void loadContent();

    protected abstract void loadActions();

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
