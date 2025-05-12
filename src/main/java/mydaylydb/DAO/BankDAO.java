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
import mydaylydb.entities.BankEntity;
import mydaylydb.interfaces.BankInterface;
import mydaylydb.utils.Database;

public class BankDAO implements BankInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;

    @Override
    public List<BankEntity> SelectAllBankName() {
        List<BankEntity> list = new ArrayList<>();
        Connection con = Database.getConexion();
        try {
            ps = con.prepareStatement(SELECT_BANK_NAMES);
            rs = ps.executeQuery();
            while (rs.next()) {
                BankEntity bankEntity = new BankEntity();
                bankEntity.setId(rs.getInt(1));
                bankEntity.setNombrecorto(rs.getString(2));
                list.add(bankEntity);
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
}
