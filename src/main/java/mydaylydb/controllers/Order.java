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
import mydaylydb.DAO.ComboDAO;
import mydaylydb.DAO.ContractDAO;
import mydaylydb.DAO.ProjectDAO;
import mydaylydb.entities.CompanyEntity;
import mydaylydb.entities.ContractEntity;
import mydaylydb.entities.ProjectEntity;

public class Order extends HttpServlet {

    HttpSession session;
    ComboDAO objCombo = new ComboDAO();
    ProjectDAO objProject = new ProjectDAO();
    ContractDAO objContract = new ContractDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "load": {
                initComponents(request, response);
                break;
            }
            case "create": {
                createContract(request, response);
                break;
            }
            case "read": {
                readContract(request, response);
                break;
            }
            case "update": {
                updateContract(request, response);
                break;
            }
            case "delete": {
                deleteContract(request, response);
                break;
            }
        }
    }

    protected void createContract(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void readContract(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void updateContract(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void deleteContract(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void initComponents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            //request.getRequestDispatcher("/contract.jsp").forward(request, response);
            return;
        }

        CompanyEntity companyEntity = null;
        ProjectEntity projectEntity = null;

        companyEntity = (CompanyEntity) session.getAttribute("companyses");
        projectEntity = objProject.SelectProjectByName(request.getParameter("project"));
        session.setAttribute("projectses", projectEntity);

        
        
        request.setAttribute("ordertypes", objCombo.SelectAllContractType());
        
        
        
        request.setAttribute("contractcurrency", objCombo.SelectAllCurrencyType());
        List<ContractEntity> listaContratos = objContract.SelectAllContractsByCompany(projectEntity.getId());
        request.setAttribute("showcontracts", !listaContratos.isEmpty());
        request.setAttribute("contracts", listaContratos);
        request.getRequestDispatcher("/order.jsp").forward(request, response);

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
