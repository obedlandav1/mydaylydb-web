package mydaylydb.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mydaylydb.entities.ContractEntity;
import mydaylydb.interfaces.ContractInterface;
import mydaylydb.utils.DatabaseConn;
//import mydaylydb.utils.JsonBuild;
import mydaylydb.utils.RStoJSON;
import org.json.JSONArray;

public class ContractDAO implements ContractInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private CallableStatement cs;

    @Override
    public boolean Create(ContractEntity contractEntity) {

        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(CONTRACT_CREATE);
            ps.setInt(1, Integer.parseInt(contractEntity.getProyectos()));
            ps.setInt(2, Integer.parseInt(contractEntity.getClientes()));
            ps.setInt(3, Integer.parseInt(contractEntity.getTipocontrato()));
            ps.setInt(4, Integer.parseInt(contractEntity.getTipomoneda()));
            ps.setString(5, contractEntity.getDescripcioncontrato());
            ps.setInt(6, contractEntity.getPlazocontrato());
            ps.setString(7, contractEntity.getFormapago());
            ps.setString(8, contractEntity.getDetallepago());
            ps.setDouble(9, contractEntity.getExonerado());
            ps.setDouble(10, contractEntity.getImponible());
            ps.setDouble(11, contractEntity.getImpuesto());
            ps.setDouble(12, contractEntity.getValortotal());
            ps.setDouble(13, contractEntity.getEstado());
            ps.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flg;

    }

    @Override
    public JSONArray ReadById(int id) {
        JSONArray JSONString = null;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(READ_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            JSONString = RStoJSON.convertRStoJson(rs);
        } catch (SQLException e) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JSONString;
    }

    @Override
    public boolean Update(ContractEntity contractEntity) {
    
        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(CONTRACT_UPDATE);
            ps.setInt(1, contractEntity.getId());
            ps.setInt(2, Integer.parseInt(contractEntity.getClientes()));
            ps.setInt(3, Integer.parseInt(contractEntity.getTipocontrato()));
            ps.setInt(4, Integer.parseInt(contractEntity.getTipomoneda()));
            ps.setString(5, contractEntity.getDescripcioncontrato());
            ps.setInt(6, contractEntity.getPlazocontrato());
            ps.setString(7, contractEntity.getFormapago());
            ps.setString(8, contractEntity.getDetallepago());
            ps.setDouble(9, contractEntity.getExonerado());
            ps.setDouble(10, contractEntity.getImponible());
            ps.setDouble(11, contractEntity.getImpuesto());
            ps.setDouble(12, contractEntity.getValortotal());
            ps.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flg;    
    }

    @Override
    public boolean Delete(int Id) {
        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, Id);
            ps.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flg;
    }

    @Override
    public List<ContractEntity> SelectAllContractsByCompany(int companyid) {
        List<ContractEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(CONTRACT_SELECT_ALL_BY_COMPANY);
            ps.setInt(1, companyid);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ContractEntity contractEntity = new ContractEntity();
                    contractEntity.setId(rs.getInt(1));
                    contractEntity.setClientes(rs.getString(2));
                    contractEntity.setTipocontrato(rs.getString(3));
                    contractEntity.setTipomoneda(rs.getString(4));
                    contractEntity.setDescripcioncontrato(rs.getString(5));
                    contractEntity.setPlazocontrato(rs.getInt(6));
                    contractEntity.setFormapago(rs.getString(7));
                    contractEntity.setDetallepago(rs.getString(8));
                    contractEntity.setExonerado(rs.getDouble(9));
                    contractEntity.setImponible(rs.getDouble(10));
                    contractEntity.setImpuesto(rs.getDouble(11));
                    contractEntity.setValortotal(rs.getDouble(12));
                    list.add(contractEntity);
                }
            } else {
                list = null;
            }
        } catch (SQLException e) {
            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
