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
import mydaylydb.entities.ComboEntity;
import mydaylydb.entities.CompanyEntity;
import mydaylydb.entities.ContractEntity;

public class Contract extends HttpServlet {

    HttpSession session;
    ComboDAO objCombo = new ComboDAO();
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
        CompanyEntity companyEntity = (CompanyEntity) session.getAttribute("companyses");

        int tipo = 0;
        String type = (String) request.getAttribute("type");
        if (type != null) {
            tipo = Integer.parseInt(type);
        }

        List<ContractEntity> listaContratos = objContract.SelectAllContractsByCompany(companyEntity.getId(), tipo);
        //request.setAttribute("showcontracts", !listaContratos.isEmpty());
        //request.setAttribute("contracts", listaContratos);
        //request.setAttribute("contracttypes", objCombo.SelectAllContractType());
        request.getRequestDispatcher("/contract.jsp").forward(request, response);
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
