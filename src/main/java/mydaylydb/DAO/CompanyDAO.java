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
import mydaylydb.entities.CompanyEntity;
import mydaylydb.interfaces.CompanyInterface;
import mydaylydb.utils.DatabaseConn;

public class CompanyDAO implements CompanyInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private CallableStatement cl;

    @Override
    public CompanyEntity SelectCompanyByName(String name) {

        CompanyEntity companyEntity = new CompanyEntity();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_COMPANY_BY_NAME);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                companyEntity.setId(rs.getInt(1));
                companyEntity.setNombrecorto(rs.getString(2));
                companyEntity.setNombrelargo(rs.getString(3));
            }
            Logger.getLogger(CompanyDAO.class.getName()).log(Level.INFO, null, "success");
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
        return companyEntity;
    }

    @Override
    public List<CompanyEntity> SelectAllCompanyName() {
        List<CompanyEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(SELECT_COMPANY_NAMES);
            rs = ps.executeQuery();
            while (rs.next()) {
                CompanyEntity companyEntity = new CompanyEntity();
                companyEntity.setNombrecorto(rs.getString(1));
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
