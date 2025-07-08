package mydaylydb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mydaylydb.DAO.AccountDAO;
import mydaylydb.DAO.ComboDAO;
import mydaylydb.DAO.CompanyDAO;
import mydaylydb.entities.AccountEntity;
import mydaylydb.entities.CompanyEntity;

public class Account extends HttpServlet {

    HttpSession session;
    CompanyDAO objCompany = new CompanyDAO();
    AccountDAO objAccount = new AccountDAO();
    ComboDAO objCombo = new ComboDAO();

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
                createAccount(request, response);
                break;
            }
            case "read": {
                readAccount(request, response);
                break;
            }
            case "update": {
                updateAccount(request, response);
                break;
            }
            case "delete": {
                deleteAccount(request, response);
                break;
            }
        }
    }

    protected void createAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setRazonsocial_id(request.getParameter("companyid"));
        accountEntity.setBancos_id(request.getParameter("newbanco"));
        accountEntity.setTipocuenta_id(request.getParameter("newtipo"));
        accountEntity.setTipomoneda_id(request.getParameter("newmoneda"));
        accountEntity.setNumerocuenta(request.getParameter("newcuenta"));
        accountEntity.setNumerointerbancario(request.getParameter("newcci"));
        accountEntity.setEstado(1);

        boolean flg = objAccount.Create(accountEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
        //request.getRequestDispatcher("/account?action=load&company=" + company).forward(request, response);
    }

    protected void readAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(objAccount.ReadById(id));
            out.flush();
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        }
    }

    protected void updateAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(Integer.parseInt(request.getParameter("accountid")));
        accountEntity.setBancos_id(request.getParameter("editbanco"));
        accountEntity.setTipocuenta_id(request.getParameter("edittipo"));
        accountEntity.setTipomoneda_id(request.getParameter("editmoneda"));
        accountEntity.setNumerocuenta(request.getParameter("editcuenta"));
        accountEntity.setNumerointerbancario(request.getParameter("editcci"));

        boolean flg = objAccount.Update(accountEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
        //request.getRequestDispatcher("/account?action=load&company=" + company).forward(request, response);
    }

    protected void deleteAccount(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean flg = objAccount.Delete(Integer.parseInt(request.getParameter("id")));
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
        //request.getRequestDispatcher("/account?action=load&company=" + company).forward(request, response);
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

        List<AccountEntity> listaCuentas = objAccount.SelectAllAccountsByCompany(companyEntity.getId());

        request.setAttribute("companies", objCompany.SelectAllCompanyName());
        request.setAttribute("banks", objCombo.SelectAllBankName());
        request.setAttribute("accounttype", objCombo.SelectAllAccountType());
        request.setAttribute("cointype", objCombo.SelectAllCurrencyType());
        request.setAttribute("showaccounts", !listaCuentas.isEmpty());
        request.setAttribute("accounts", listaCuentas);
        
        request.getRequestDispatcher("/account.jsp").forward(request, response);
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
