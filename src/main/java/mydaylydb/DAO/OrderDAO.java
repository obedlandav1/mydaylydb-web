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
            ps.setInt(1, Integer.parseInt(orderEntity.getProyectos()));
            ps.setInt(2, Integer.parseInt(orderEntity.getProveedores()));
            ps.setInt(3, Integer.parseInt(orderEntity.getTipoorden()));
            ps.setInt(4, Integer.parseInt(orderEntity.getTipomoneda()));
            ps.setString(5, orderEntity.getDescripcioncontrato());
            ps.setInt(6, orderEntity.getPlazoorden());
            ps.setString(7, orderEntity.getFormapago());
            ps.setString(8, orderEntity.getDetallepago());
            ps.setString(9, orderEntity.getConsideraciones());            
            ps.setDouble(10, orderEntity.getSubtotal1());
            ps.setDouble(11, orderEntity.getTipocambio());
            ps.setDouble(12, orderEntity.getSubtotal2());
            ps.setDouble(13, orderEntity.getExonerado());
            ps.setDouble(14, orderEntity.getImponible());
            ps.setDouble(15, orderEntity.getImpuesto());
            ps.setDouble(16, orderEntity.getValortotal());
            ps.setDouble(17, orderEntity.getEstado());
            ps.executeUpdate();
            flg = true;
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
            ps.setInt(2, Integer.parseInt(orderEntity.getProveedores()));
            ps.setInt(3, Integer.parseInt(orderEntity.getTipoorden()));
            ps.setInt(4, Integer.parseInt(orderEntity.getTipomoneda()));
            ps.setString(5, orderEntity.getDescripcioncontrato());
            ps.setInt(6, orderEntity.getPlazoorden());
            ps.setString(7, orderEntity.getFormapago());
            ps.setString(8, orderEntity.getDetallepago());
            ps.setString(9, orderEntity.getConsideraciones());
            ps.setDouble(10, orderEntity.getSubtotal1());
            ps.setDouble(11, orderEntity.getTipocambio());
            ps.setDouble(12, orderEntity.getSubtotal2());
            ps.setDouble(13, orderEntity.getExonerado());
            ps.setDouble(14, orderEntity.getImponible());
            ps.setDouble(15, orderEntity.getImpuesto());
            ps.setDouble(16, orderEntity.getValortotal());
            ps.executeUpdate();
            flg = true;
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
    public List<OrderEntity> SelectAllContractsByCompany(int companyid) {
        List<OrderEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(ORDER_SELECT_ALL_BY_COMPANY);
            ps.setInt(1, companyid);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    OrderEntity orderEntity = new OrderEntity();
                    orderEntity.setId(rs.getInt(1));
                    orderEntity.setProveedores(rs.getString(2));
                    orderEntity.setTipoorden(rs.getString(3));
                    orderEntity.setTipomoneda(rs.getString(4));
                    orderEntity.setDescripcioncontrato(rs.getString(5));
                    orderEntity.setPlazoorden(rs.getInt(6));
                    orderEntity.setFormapago(rs.getString(7));
                    orderEntity.setDetallepago(rs.getString(8));
                    orderEntity.setConsideraciones(rs.getString(9));
                    orderEntity.setExonerado(rs.getDouble(10));
                    orderEntity.setImponible(rs.getDouble(11));
                    orderEntity.setImpuesto(rs.getDouble(12));
                    orderEntity.setValortotal(rs.getDouble(13));
                    list.add(orderEntity);
                }
            } else {
                list = null;
            }
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
        return list;
    }
}
