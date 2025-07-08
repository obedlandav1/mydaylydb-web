package mydaylydb.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import mydaylydb.entities.UserEntity;
import mydaylydb.interfaces.LoginInterface;
import mydaylydb.utils.CreateSHA256;
import mydaylydb.utils.DatabaseConn;

public class LoginDAO implements LoginInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;

    @Override
    public String SelectPassword(String User) {

        String password = "";
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_PASSWORD);
            ps.setString(1, User);
            rs = ps.executeQuery();
            rs.next();
            password = rs.getString(1);
        } catch (SQLException e) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return password;
    }

    @Override
    public boolean AuthenticateUser(UserEntity User) {
        String PassUser = CreateSHA256.SecurePassword(User.getPasswordusuario());
        System.out.println("PassUser: " + PassUser + " " + LoginDAO.class.getName());
        String PassBase = SelectPassword(User.getIdentidadusuario());
        //System.out.println("Resultado PassUser: "+PassUser+" "+LoginDAO.class.getName());
        //System.out.println("Resultado PassBase: "+PassBase+" "+LoginDAO.class.getName());
        return PassUser.equals(PassBase);
    }

    @Override
    public UserEntity SelectUser(String User) {
        UserEntity userEntity = new UserEntity();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_USER);
            ps.setString(1, User);
            rs = ps.executeQuery();
            rs.next();
            userEntity.setId(rs.getInt(1));
            userEntity.setNombreUsuario(rs.getString(2));
            userEntity.setApellidousuario(rs.getString(3));
        } catch (SQLException e) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return userEntity;
    }
}
