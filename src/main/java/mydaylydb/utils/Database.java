package mydaylydb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://192.168.1.10:3306/mydaylydb";
            String usr = "mydaylydb";
            String psw = "ablement";
            con = DriverManager.getConnection(url, usr, psw);
            System.out.println("conexion ok");
        } catch (ClassNotFoundException ex) {
            System.out.println("No hay Driver!!" + ex);
        } catch (SQLException ex) {
            System.out.println("Error con la BD " + ex);
        }
        return con;
    }
}
