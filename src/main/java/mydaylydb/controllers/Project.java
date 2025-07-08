/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mydaylydb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mydaylydb.DAO.CompanyDAO;
import mydaylydb.DAO.ContractDAO;
import mydaylydb.DAO.ProjectDAO;
import mydaylydb.entities.ProjectEntity;
import mydaylydb.entities.CompanyEntity;
import mydaylydb.entities.ContractEntity;

public class Project extends HttpServlet {

    HttpSession session;
    CompanyDAO objCompany = new CompanyDAO();
    ProjectDAO objProject = new ProjectDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        switch (action) {
            case "load": {
                initComponents(request, response);
                break;
            }
            case "create": {
                createProject(request, response);
                break;
            }
            case "read": {
                readProject(request, response);
                break;
            }
            case "update": {
                updateProject(request, response);
                break;
            }
            case "delete": {
                deleteProject(request, response);
                break;
            }
        }
    }

    protected void createProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setRazonsocial_id(request.getParameter("companyid"));
        projectEntity.setNombrecorto(request.getParameter("newcorto"));
        projectEntity.setNombrelargo(request.getParameter("newlargo"));
        projectEntity.setPlazoproyecto(Integer.parseInt(request.getParameter("newplazo")));
        projectEntity.setMontoproyecto(Double.valueOf(request.getParameter("newmonto")));
        projectEntity.setEstado(1);

        boolean flg = objProject.Create(projectEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
        //request.getRequestDispatcher("/project?action=load&company=" + company).forward(request, response);
    }

    protected void readProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("projectid"));
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(objProject.ReadById(id));
            out.flush();
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        }
    }

    protected void updateProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(Integer.parseInt(request.getParameter("projectid")));
        projectEntity.setNombrecorto(request.getParameter("editcorto"));
        projectEntity.setNombrelargo(request.getParameter("editlargo"));
        projectEntity.setPlazoproyecto(Integer.parseInt(request.getParameter("editplazo")));
        projectEntity.setMontoproyecto(Double.valueOf(request.getParameter("editmonto")));

        boolean flg = objProject.Update(projectEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
        //request.getRequestDispatcher("/project?action=load&company=" + company).forward(request, response);
    }

    protected void deleteProject(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String company = request.getParameter("company");
        boolean flg = objProject.Delete(Integer.parseInt(request.getParameter("id")));
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
        //request.getRequestDispatcher("/project?action=load&company=" + company).forward(request, response);
    }

    protected void initComponents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            //request.getRequestDispatcher("/contract.jsp").forward(request, response);
            return;
        }

        CompanyEntity companyEntity = objCompany.SelectCompanyByName(request.getParameter("company"));
        session.setAttribute("companyses", companyEntity);

        List<ProjectEntity> listaProyectos = objProject.SelectAllProjectsByCompany(companyEntity.getId());

        request.setAttribute("companies", objCompany.SelectAllCompanyName());
        request.setAttribute("showprojects", !listaProyectos.isEmpty());
        request.setAttribute("projects", listaProyectos);

        request.getRequestDispatcher("/project.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
