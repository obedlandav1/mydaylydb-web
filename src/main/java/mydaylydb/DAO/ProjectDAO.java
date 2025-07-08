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
import mydaylydb.entities.ProjectEntity;
import mydaylydb.interfaces.ProjectInterface;
import mydaylydb.utils.DatabaseConn;
import mydaylydb.utils.RStoJSON;
import org.json.JSONArray;

public class ProjectDAO implements ProjectInterface {

    private ResultSet rs;
    private PreparedStatement ps;
    private Statement st;

    @Override
    public boolean Create(ProjectEntity projectEntity) {
        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(PROJECT_CREATE);
            ps.setInt(1, Integer.parseInt(projectEntity.getRazonsocial_id()));
            ps.setString(2, projectEntity.getNombrecorto());
            ps.setString(3, projectEntity.getNombrelargo());
            ps.setInt(4, projectEntity.getPlazoproyecto());
            ps.setDouble(5, projectEntity.getMontoproyecto());
            ps.setInt(6, projectEntity.getEstado());
            ps.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return JSONString;
    }

    @Override
    public boolean Update(ProjectEntity projectEntity) {
        boolean flg = false;
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(PROJECT_UPDATE);
            ps.setInt(1, projectEntity.getId());
            ps.setString(2, projectEntity.getNombrecorto());
            ps.setString(3, projectEntity.getNombrelargo());
            ps.setInt(4, projectEntity.getPlazoproyecto());
            ps.setDouble(5, projectEntity.getMontoproyecto());
            ps.executeUpdate();
            flg = true;
        } catch (SQLException e) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flg;
    }

    @Override
    public ProjectEntity SelectProjectByName(String name) {
        ProjectEntity projectEntity = new ProjectEntity();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(PROJECT_SELECT_ALL_BY_NAME);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                projectEntity.setId(rs.getInt(1));
                projectEntity.setNombrecorto(rs.getString(2));
                projectEntity.setNombrelargo(rs.getString(3));
            }
        } catch (SQLException e) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return projectEntity;
    }

    @Override
    public List<ProjectEntity> SelectAllProjectsByCompany(int company) {
        List<ProjectEntity> list = new ArrayList<>();
        Connection con = DatabaseConn.getConexion();
        try {
            ps = con.prepareStatement(PROJECT_SELECT_ALL_BY_COMPANY);
            ps.setInt(1, company);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProjectEntity projectEntity = new ProjectEntity();
                    projectEntity.setId(rs.getInt(1));
                    projectEntity.setNombrecorto(rs.getString(2));
                    projectEntity.setNombrelargo(rs.getString(3));
                    projectEntity.setPlazoproyecto(rs.getInt(4));
                    projectEntity.setMontoproyecto(rs.getDouble(5));
                    list.add(projectEntity);
                }
            } else {
                list = null;
            }
        } catch (SQLException e) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
}
