package mydaylydb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConn {

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydaylydb";
            String usr = "mydaylydb";
            String psw = "xV5E9U61DRVD";
            con = DriverManager.getConnection(url, usr, psw);
            Logger.getLogger(DatabaseConn.class.getName()).log(Level.INFO, null, "success connection");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
