package mydaylydb.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mydaylydb.entities.MovementEntity;
import mydaylydb.interfaces.MovementInterface;
import mydaylydb.utils.DatabaseConn;
import mydaylydb.utils.RStoJSON;
import org.json.JSONArray;

public class MovementDAO implements MovementInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private CallableStatement cl;

    @Override
    public boolean Create(MovementEntity movementEntity) {

        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(CREATE_MOVEMENT);
            ps.setInt(1, movementEntity.getCuenta_id());
            ps.setInt(2, movementEntity.getTipooperacion_id());
            //================================================
            Date femisionSQL = Date.valueOf(movementEntity.getFechaemision().trim());
            ps.setDate(3, femisionSQL);
            //================================================
            Date foperacionSQL = Date.valueOf(movementEntity.getFechaoperacion().trim());
            ps.setDate(4, foperacionSQL);
            //================================================
            ps.setString(5, movementEntity.getPeriodooperacion());
            ps.setString(6, movementEntity.getNumerooperacion());            
            ps.setString(7, movementEntity.getDescripcionoperacion());
            ps.setString(8, movementEntity.getBeneficiariooperacion());
            ps.setString(9, movementEntity.getGlosaoperacion());
            ps.setDouble(10, movementEntity.getMontooperacion1());
            ps.setDouble(11, movementEntity.getTipocambio());
            ps.setDouble(12, movementEntity.getMontooperacion2());
            ps.setInt(13, movementEntity.getEstado());
            ps.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JSONString;
    }

    @Override
    public boolean Update(MovementEntity movementEntity) {
        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            cl = con.prepareCall(UPDATE_MOVEMENT);
            cl.setInt(1, movementEntity.getId());
            cl.setInt(2, movementEntity.getCuenta_id());
            cl.setInt(3, movementEntity.getTipooperacion_id());
            //================================================
            Date femisionSQL = Date.valueOf(movementEntity.getFechaemision().trim());
            cl.setDate(4, femisionSQL);
            //================================================
            Date foperacionSQL = Date.valueOf(movementEntity.getFechaoperacion().trim());
            cl.setDate(5, foperacionSQL);
            //================================================
            cl.setString(6, movementEntity.getPeriodooperacion());
            cl.setString(7, movementEntity.getNumerooperacion());
            cl.setString(8, movementEntity.getDescripcionoperacion());
            cl.setString(9, movementEntity.getBeneficiariooperacion());
            cl.setString(10, movementEntity.getGlosaoperacion());
            cl.setDouble(11, movementEntity.getMontooperacion1());
            cl.setDouble(12, movementEntity.getTipocambio());
            cl.setDouble(13, movementEntity.getMontooperacion2());
            cl.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flg;
    }

    @Override
    public List<MovementEntity> SelectAllMovementsByCompany(int accountid, int year, int month) {
        List<MovementEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareCall(SELECT_ALL_MOVEMENT_BY_COMPANY);
            ps.setInt(1, accountid);
            ps.setInt(2, year);
            ps.setInt(3, month);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    MovementEntity movementEntity = new MovementEntity();
                    movementEntity.setId(rs.getInt(1));
                    movementEntity.setCuenta(rs.getString(2));
                    movementEntity.setTipooperacion(rs.getString(3));
                    movementEntity.setFechaemision(rs.getString(4));
                    movementEntity.setFechaoperacion(rs.getString(5));
                    movementEntity.setPeriodooperacion(rs.getString(6));
                    movementEntity.setNumerooperacion(rs.getString(7));
                    movementEntity.setDescripcionoperacion(rs.getString(8));
                    movementEntity.setBeneficiariooperacion(rs.getString(9));
                    movementEntity.setGlosaoperacion(rs.getString(10));
                    movementEntity.setMontooperacion1(rs.getDouble(11));
                    movementEntity.setTipocambio(rs.getDouble(12));
                    movementEntity.setMontooperacion2(rs.getDouble(13));                    
                    list.add(movementEntity);
                }
            } else {
                list = null;
            }
        } catch (SQLException e) {
            Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MovementDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
