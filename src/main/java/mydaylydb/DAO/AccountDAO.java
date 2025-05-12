package mydaylydb.DAO;

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
import mydaylydb.utils.Database;

public class AccountDAO implements AccountInterface{

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;    
    
    @Override
    public boolean Create(AccountEntity accountEntity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AccountEntity ReadById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Update(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Delete(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AccountEntity> SelectTipoCuenta() {
        List<AccountEntity> list = new ArrayList<>();
        Connection con = Database.getConexion();
        try {
            ps = con.prepareStatement(SELECT_ACCOUNT_TYPE);
            rs = ps.executeQuery();
            while (rs.next()) {
                AccountEntity bankEntity = new AccountEntity();
                bankEntity.setTipocuenta(rs.getString(1));
                System.out.println(rs.getString(1));
                list.add(bankEntity);
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

    @Override
    public List<AccountEntity> SelectTipoMoneda() {
        List<AccountEntity> list = new ArrayList<>();
        Connection con = Database.getConexion();
        try {
            ps = con.prepareStatement(SELECT_COIN_NAMES);
            rs = ps.executeQuery();
            while (rs.next()) {
                AccountEntity accountEntity = new AccountEntity();
                accountEntity.setMonedacuenta(rs.getString(1));
                System.out.println(rs.getString(1));
                list.add(accountEntity);
            }
        } catch (SQLException e) {
            Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BankDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public List<AccountEntity> SelectAllAccount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
