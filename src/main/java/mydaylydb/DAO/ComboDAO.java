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
import mydaylydb.entities.ComboEntity;
import mydaylydb.interfaces.ComboInterface;
import mydaylydb.utils.DatabaseConn;
import mydaylydb.utils.RStoJSON;
import org.json.JSONArray;

public class ComboDAO implements ComboInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private CallableStatement cl;

    @Override
    public List<ComboEntity> SelectAllAccountsType() {
        List<ComboEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_ACCOUNT_TYPE);
            rs = ps.executeQuery();
            while (rs.next()) {
                ComboEntity comboEntity = new ComboEntity();
                comboEntity.setId(rs.getInt(1));
                comboEntity.setNombrelargo(rs.getString(2));
                list.add(comboEntity);
            }
        } catch (SQLException e) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public List<ComboEntity> SelectAllCurrenciesType() {
        List<ComboEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_CURRENCY_TYPE);
            rs = ps.executeQuery();
            while (rs.next()) {
                ComboEntity comboEntity = new ComboEntity();
                comboEntity.setId(rs.getInt(1));
                comboEntity.setNombrelargo(rs.getString(2));
                list.add(comboEntity);
            }
        } catch (SQLException e) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public List<ComboEntity> SelectAllBanksName() {
        List<ComboEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_BANK_OPTIONS);
            rs = ps.executeQuery();
            while (rs.next()) {
                ComboEntity comboEntity = new ComboEntity();
                comboEntity.setId(rs.getInt(1));
                comboEntity.setNombrelargo(rs.getString(2));
                list.add(comboEntity);
            }
        } catch (SQLException e) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public List<ComboEntity> SelectAllContractsType() {
        List<ComboEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_CONTRACT_TYPE);
            rs = ps.executeQuery();
            while (rs.next()) {
                ComboEntity comboEntity = new ComboEntity();
                comboEntity.setId(rs.getInt(1));
                comboEntity.setNombrecorto(rs.getString(2));
                comboEntity.setNombrelargo(rs.getString(3));
                list.add(comboEntity);
            }
        } catch (SQLException e) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public List<ComboEntity> SelectAllOperationsType() {
        List<ComboEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_OPERATION_TYPE);
            rs = ps.executeQuery();
            while (rs.next()) {
                ComboEntity comboEntity = new ComboEntity();
                comboEntity.setId(rs.getInt(1));
                comboEntity.setNombrelargo(rs.getString(2));
                list.add(comboEntity);
            }
        } catch (SQLException e) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public JSONArray SelectAllBankName() {
        JSONArray JSONString = null;
        List<ComboEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_BANK_OPTIONS);
            rs = ps.executeQuery();
            JSONString = RStoJSON.convertRStoJson(rs);
        } catch (SQLException e) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JSONString;
    }

    @Override
    public JSONArray SelectAllIdentificationType() {
        JSONArray JSONString = null;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_IDENTITY_TYPE);
            rs = ps.executeQuery();
            JSONString = RStoJSON.convertRStoJson(rs);
        } catch (SQLException e) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JSONString;
    }

    /**
     * @Override public ComboEntity SelectContractTypeByName(String name) {
     * ComboEntity comboEntity = new ComboEntity(); Connection con =
     * DatabaseConn.getConexion(); try { ps =
     * con.prepareStatement(SELECT_CONTRACT_ID); ps.setString(1, name); rs =
     * ps.executeQuery(); if (rs.next()) { comboEntity.setId(rs.getInt(1));
     * comboEntity.setNombrecorto(rs.getString(2)); } } catch (SQLException e) {
     * Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, e); }
     * finally { try { if (con != null) { con.close(); } } catch (SQLException
     * ex) { Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null,
     * ex); } } return comboEntity; }
     *
     * [
     */
}
