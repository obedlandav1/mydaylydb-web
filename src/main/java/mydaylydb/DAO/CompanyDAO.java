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
import mydaylydb.entities.CompanyEntity;
import mydaylydb.interfaces.CompanyInterface;
import mydaylydb.utils.Database;
import static mydaylydb.interfaces.LoginInterface.SELECT_PASSWORD;

public class CompanyDAO implements CompanyInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;

    @Override
    public int SelectIdByName(String name) {
        int id = 0;
        Connection con = Database.getConexion();
        try {
            ps = con.prepareStatement(SELECT_ID);
            ps.setString(1, name);
            rs = ps.executeQuery();
            id = rs.getInt(1);
        } catch (SQLException e) {
            Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }

    @Override
    public List<CompanyEntity> SelectAllCompanyName() {
        List<CompanyEntity> list = new ArrayList<>();
        Connection con = Database.getConexion();
        try {
            ps = con.prepareStatement(SELECT_COMPANY_NAMES);
            rs = ps.executeQuery();
            while (rs.next()) {
                CompanyEntity companyEntity = new CompanyEntity();
                companyEntity.setNombrecorto(rs.getString(1));
                System.out.println(rs.getString(1));
                list.add(companyEntity);
            }
        } catch (SQLException e) {
            Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CompanyDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
