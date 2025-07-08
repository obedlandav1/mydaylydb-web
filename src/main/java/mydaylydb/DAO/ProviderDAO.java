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
import mydaylydb.entities.ProviderEntity;
import mydaylydb.interfaces.ProviderInterfase;
import mydaylydb.utils.DatabaseConn;
import mydaylydb.utils.RStoJSON;
import org.json.JSONArray;

public class ProviderDAO implements ProviderInterfase {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private CallableStatement cs;

    @Override
    public boolean Create(ProviderEntity providerEntity) {
        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(PROVIDER_CREATE);
            ps.setInt(1, Integer.parseInt(providerEntity.getTipodocumento_id()));
            ps.setString(2, providerEntity.getNombreproveedor());
            ps.setString(3, providerEntity.getIdentidadproveedor());
            ps.setString(4, providerEntity.getDireccionproveedor());
            ps.setString(5, providerEntity.getDistritoproveedor());
            ps.setString(6, providerEntity.getCiudadproveedor());
            ps.setString(7, providerEntity.getBancoproveedor());
            ps.setString(8, providerEntity.getCuentaproveedor());
            ps.setString(9, providerEntity.getCciproveedor());
            ps.setString(10, providerEntity.getTelefonoproveedor());
            ps.setString(11, providerEntity.getCorreoproveedor());
            ps.setInt(12, providerEntity.getEstado());
            ps.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(ProviderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProviderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flg;
    }

    @Override
    public JSONArray ReadById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update(ProviderEntity providerEntity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Delete(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public JSONArray SelectProviderByLikeName(String name) {
        JSONArray JSONString = null;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(PROVIDER_SELECT_ALL_BY_LIKE_NAME);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            JSONString = RStoJSON.convertRStoJson(rs);
        } catch (SQLException e) {
            Logger.getLogger(ProviderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProviderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JSONString;        }

    @Override
    public List<ProviderEntity> SelectAllProvider() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
