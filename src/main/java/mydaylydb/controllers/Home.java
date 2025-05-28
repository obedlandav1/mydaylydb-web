package mydaylydb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mydaylydb.DAO.CompanyDAO;
import mydaylydb.entities.CompanyEntity;

public class Home extends HttpServlet {

    HttpSession session;
    CompanyDAO objCompany = new CompanyDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        switch (action) {
            case "load": {
                initComponents(request, response);
                initHome(request, response);
                break;
            }
            case "create": {
                //createAccount(request, response);
                break;
            }
            case "read": {
                //readAccuount(request, response);
                break;
            }
            case "update": {
                //updateAccount(request, response);
                break;
            }
            case "delete": {
                //deleteAccount(request, response);
                break;
            }
        }
    }

        protected void initHome(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        session = request.getSession(false);
//        CompanyEntity companyEntity = objCompany.SelectCompanyByName(request.getParameter("company"));
//        session.setAttribute("companyses", companyEntity);

        //List<AccountEntity> listaCuentas = objAccount.SelectAllAccountsByCompany(companyEntity.getId());
        //request.setAttribute("showaccounts", !listaCuentas.isEmpty());
        //request.setAttribute("accounts", listaCuentas);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    protected void initComponents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.setAttribute("companies", objCompany.SelectAllCompanyName());
        //request.setAttribute("banks", objCombo.SelectAllBankName());
        //request.setAttribute("accounttype", objCombo.SelectAllAccountType());
        //request.setAttribute("cointype", objCombo.SelectAllCurrencyType());
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
