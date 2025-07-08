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
import mydaylydb.entities.AccountEntity;
import mydaylydb.interfaces.AccountInterface;
import mydaylydb.utils.DatabaseConn;
import mydaylydb.utils.RStoJSON;
import org.json.JSONArray;

public class AccountDAO implements AccountInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private CallableStatement cl;

    @Override
    public boolean Create(AccountEntity accountEntity) {

        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(CREATE_ACCOUNT);
            ps.setInt(1, Integer.parseInt(accountEntity.getRazonsocial_id()));
            ps.setInt(2, Integer.parseInt(accountEntity.getBancos_id()));
            ps.setInt(3, Integer.parseInt(accountEntity.getTipocuenta_id()));
            ps.setInt(4, Integer.parseInt(accountEntity.getTipomoneda_id()));
            ps.setString(5, accountEntity.getNumerocuenta());
            ps.setString(6, accountEntity.getNumerointerbancario());
            ps.setInt(7, accountEntity.getEstado());
            ps.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JSONString;
    }

    @Override
    public boolean Update(AccountEntity accountEntity) {
        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            cl = con.prepareCall(UPDATE_ACCOUNT);
            cl.setInt(1, accountEntity.getId());
            cl.setInt(2, Integer.parseInt(accountEntity.getBancos_id()));
            cl.setInt(3, Integer.parseInt(accountEntity.getTipocuenta_id()));
            cl.setInt(4, Integer.parseInt(accountEntity.getTipomoneda_id()));
            cl.setString(5, accountEntity.getNumerocuenta());
            cl.setString(6, accountEntity.getNumerointerbancario());
            cl.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flg;
    }

    @Override
    public List<AccountEntity> SelectAllAccountsByCompany(int company) {
        List<AccountEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareCall(SELECT_ALL_ACCOUNTS_BY_COMPANY);
            ps.setInt(1, company);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AccountEntity accountEntity = new AccountEntity();
                    accountEntity.setId(rs.getInt(1));
                    accountEntity.setBancos_id(rs.getString(2));
                    accountEntity.setTipocuenta_id(rs.getString(3));
                    accountEntity.setTipomoneda_id(rs.getString(4));
                    accountEntity.setNumerocuenta(rs.getString(5));
                    accountEntity.setNumerointerbancario(rs.getString(6));
                    list.add(accountEntity  );
                }
            } else {
                list = null;
            }
        } catch (SQLException e) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
