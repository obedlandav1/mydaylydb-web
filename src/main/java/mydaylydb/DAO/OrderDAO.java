package mydaylydb.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mydaylydb.entities.OrderEntity;
import mydaylydb.interfaces.OrderInterface;
import mydaylydb.utils.DatabaseConn;
//import mydaylydb.utils.JsonBuild;
import mydaylydb.utils.RStoJSON;
import org.json.JSONArray;

public class OrderDAO implements OrderInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;
    private CallableStatement cs;

    @Override
    public boolean Create(OrderEntity orderEntity) {

        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(ORDER_CREATE);
            ps.setInt(1, Integer.parseInt(orderEntity.getProyecto()));
            ps.setInt(2, Integer.parseInt(orderEntity.getProveedor()));
            ps.setInt(3, Integer.parseInt(orderEntity.getTipoorden()));
            ps.setInt(4, Integer.parseInt(orderEntity.getTipomoneda()));
            //================================================
            //String f = orderEntity.getFechaorden();
            //SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            //Date fecha = format.parse(f);
            //java.sql.Date dateSQL = new java.sql.Date(fecha.getTime());
            //ps.setDate(5, dateSQL);
            Date dateSQL = Date.valueOf(orderEntity.getFechaorden().trim());
            ps.setDate(5, dateSQL);
            //================================================
            ps.setString(6, orderEntity.getDescripcionorden());
            ps.setInt(7, orderEntity.getPlazoorden());
            ps.setString(8, orderEntity.getFormapago());
            ps.setString(9, orderEntity.getPresupuesto());
            ps.setString(10, orderEntity.getDetallepago());
            ps.setString(11, orderEntity.getConsgenrales());
            ps.setString(12, orderEntity.getConsespecificas());
            ps.setDouble(13, orderEntity.getSubtotal1());
            ps.setDouble(14, orderEntity.getTipocambio());
            ps.setDouble(15, orderEntity.getSubtotal2());
            ps.setDouble(16, orderEntity.getExonerado());
            ps.setDouble(17, orderEntity.getImponible());
            ps.setDouble(18, orderEntity.getImpuesto());
            ps.setDouble(19, orderEntity.getValortotal());
            ps.setString(20, orderEntity.getLetras());
            ps.setDouble(21, orderEntity.getEstado());
            ps.executeUpdate();
            flg = true;
        //} catch (ParseException ex) {
        //    Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JSONString;
    }

    @Override
    public boolean Update(OrderEntity orderEntity) {

        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(ORDER_UPDATE);
            ps.setInt(1, orderEntity.getId());
            ps.setInt(2, Integer.parseInt(orderEntity.getProveedor()));
            ps.setInt(3, Integer.parseInt(orderEntity.getTipoorden()));
            ps.setInt(4, Integer.parseInt(orderEntity.getTipomoneda()));
            //================================================
            //String date = orderEntity.getFechaorden().trim();
            //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            //Date fecha = format.parse(date);
            //java.sql.Date dateSQL = new java.sql.Date(fecha.getTime());
            Date dateSQL = Date.valueOf(orderEntity.getFechaorden().trim());
            ps.setDate(5, dateSQL);
            //===============================================
            ps.setString(6, orderEntity.getDescripcionorden());
            ps.setInt(7, orderEntity.getPlazoorden());
            ps.setString(8, orderEntity.getFormapago());
            ps.setString(9, orderEntity.getPresupuesto());
            ps.setString(10, orderEntity.getDetallepago());
            ps.setString(11, orderEntity.getConsgenrales());
            ps.setString(12, orderEntity.getConsespecificas());
            ps.setDouble(13, orderEntity.getSubtotal1());
            ps.setDouble(14, orderEntity.getTipocambio());
            ps.setDouble(15, orderEntity.getSubtotal2());
            ps.setDouble(16, orderEntity.getExonerado());
            ps.setDouble(17, orderEntity.getImponible());
            ps.setDouble(18, orderEntity.getImpuesto());
            ps.setDouble(19, orderEntity.getValortotal());
            ps.setString(20, orderEntity.getLetras());
            ps.executeUpdate();
            flg = true;
            //} catch (ParseException ex) {
            //    Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrderDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();

                }
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flg;
    }

    @Override
    public List<OrderEntity> SelectAllOrdersByProject(int companyid) {
        List<OrderEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(ORDER_SELECT_ALL_BY_PROJECT);
            ps.setInt(1, companyid);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    OrderEntity orderEntity = new OrderEntity();
                    orderEntity.setId(rs.getInt(1));
                    orderEntity.setFechaorden(rs.getString(2));
                    orderEntity.setProveedor(rs.getString(3));
                    orderEntity.setTipoorden(rs.getString(4));
                    orderEntity.setPlazoorden(rs.getInt(8));
                    orderEntity.setValortotal(rs.getDouble(16));
                    list.add(orderEntity);
                }
            } else {
                list = null;
            }
        } catch (SQLException e) {
            Logger.getLogger(OrderDAO.class
                    .getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(OrderDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
