/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lusi
 */
public class Algoritmo {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    static Connection connection;

    public static String res;
    public static int count;

    public static void main(String[] args) throws IOException, SQLException {
        int id = 1249 * 1000;
        String connectionUrl
                = "jdbc:sqlserver://192.168.1.155:1433;"
                + "database=dic_databse;"
                + "user=sa;"
                + "password=Siul6245;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";
        connection = DriverManager.getConnection(connectionUrl);
        for (count = 1249; count <= 1250; ++count) {
            String folder = "/Users/lusi/Desktop/words/words-" + count;
            String file = getFile(folder);
            String words[] = file.split("\n");
            res = "";
            for (var word : words) {
                res += save(id, "", word);
                ++id;
            }
            res = res.substring(0, res.length() - 1);
            Thread t = new Thread(() -> {
                try {
                    save(res);
                } catch (SQLException ex) {
                   System.out.println("reading" + count);
                    Logger.getLogger(Algoritmo.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            t.start();
            if ((count % 5) == 0) {
                while (t.isAlive()) {
                }
            }

        }
        connection.close();

    }

    public static String getFile(String path) throws FileNotFoundException, IOException {
        String res = "";
        String helper = "";
        try (BufferedReader stdInput = new BufferedReader(new FileReader(path))) {
            while ((helper = stdInput.readLine()) != null) {
                res += helper + "\n";
            }
        }
        return res;
    }

    public static String save(int id, String type, String word) {
        String res = "(" + id + ",'', '" + word + "'),";
        return res;
    }

    public static void save(String values) throws SQLException {

        String insertSql = "Insert into [tbl_dic] values" + values;

        PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);

        prepsInsertProduct.execute();

    }

}
