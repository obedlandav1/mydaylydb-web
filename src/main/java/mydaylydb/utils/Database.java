package mydaylydb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://192.168.1.10:3306/mydaylydb";
            String usr = "mydaylydb";
            String psw = "ablement";
            con = DriverManager.getConnection(url, usr, psw);
            Logger.getLogger(Database.class.getName()).log(Level.INFO, null, "success connection");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
