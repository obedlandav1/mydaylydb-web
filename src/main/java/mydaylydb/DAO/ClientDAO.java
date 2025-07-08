package mydaylydb.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mydaylydb.entities.ClientEntity;
import mydaylydb.interfaces.ClientInterfase;
import mydaylydb.utils.DatabaseConn;
import mydaylydb.utils.RStoJSON;
import org.json.JSONArray;

public class ClientDAO implements ClientInterfase {
    
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private CallableStatement cs;

    @Override
    public boolean Create(ClientEntity clientEntity) {
        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(CLIENT_CREATE);
            ps.setInt(1, Integer.parseInt(clientEntity.getRazonsocial_id()));
            ps.setInt(2, Integer.parseInt(clientEntity.getTipodocumento_id()));
            ps.setString(3, clientEntity.getNombrecliente());
            ps.setString(4, clientEntity.getIdentidadcliente());
            ps.setString(5, clientEntity.getDireccioncliente());
            ps.setString(6, clientEntity.getDistritocliente());
            ps.setString(7, clientEntity.getCiudadcliente());
            ps.setString(8, clientEntity.getTelefonocliente());
            ps.setString(9, clientEntity.getCorreocliente());
            ps.setInt(10, clientEntity.getEstado());
            ps.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flg;    
    }

    @Override
    public JSONArray ReadById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update(ClientEntity projectEntity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Delete(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public JSONArray SelectClientByLikeName(String name) {
        JSONArray JSONString = null;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(CLIENT_SELECT_ALL_BY_LIKE_NAME);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            JSONString = RStoJSON.convertRStoJson(rs);
        } catch (SQLException e) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JSONString;    
    }
    
    @Override
    public List<ClientEntity> SelectAllClientsByCompany(int company) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
