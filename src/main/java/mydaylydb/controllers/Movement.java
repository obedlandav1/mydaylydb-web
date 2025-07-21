package mydaylydb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mydaylydb.DAO.AccountDAO;
import mydaylydb.DAO.ComboDAO;
import mydaylydb.DAO.CompanyDAO;
import mydaylydb.DAO.MovementDAO;
import mydaylydb.entities.CompanyEntity;
import mydaylydb.entities.MovementEntity;
import mydaylydb.entities.QueryEntity;

public class Movement extends HttpServlet {

    HttpSession session;
    CompanyDAO objCompany = new CompanyDAO();
    ComboDAO objCombo = new ComboDAO();
    AccountDAO objAccount = new AccountDAO();
    MovementDAO objMovement = new MovementDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        switch (action) {
            case "query": {
                setQueryparams(request, response);
                break;
            }
            case "load": {
                initComponents(request, response);
                break;
            }
            case "create": {
                createMovement(request, response);
                break;
            }
            case "read": {
                readMovement(request, response);
                break;
            }
            case "update": {
                updateMovement(request, response);
                break;
            }
            case "delete": {
                deleteMovement(request, response);
                break;
            }
        }
    }

    protected void createMovement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        MovementEntity movementEntity = new MovementEntity();
        movementEntity.setCuenta_id(Integer.parseInt(request.getParameter("newaccount")));
        movementEntity.setTipooperacion_id(Integer.parseInt(request.getParameter("newtype")));
        movementEntity.setFechaemision(request.getParameter("newvoucherdate"));
        movementEntity.setFechaoperacion(request.getParameter("newoperationdate"));
        movementEntity.setPeriodooperacion(request.getParameter("newperiod"));
        movementEntity.setNumerooperacion(request.getParameter("newoperationnum"));
        movementEntity.setDescripcionoperacion(request.getParameter("newdescription"));
        movementEntity.setBeneficiariooperacion(request.getParameter("newbeneficiary"));
        movementEntity.setGlosaoperacion(request.getParameter("newgloss"));
        movementEntity.setMontooperacion1(Double.parseDouble(request.getParameter("newsubtotal")));
        movementEntity.setTipocambio(Double.parseDouble(request.getParameter("newexrate")));
        movementEntity.setMontooperacion2(Double.parseDouble(request.getParameter("newtotal")));
        movementEntity.setEstado(1);

        boolean flg = objMovement.Create(movementEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
        //request.getRequestDispatcher("/account?action=load&company=" + company).forward(request, response);

    }

    protected void setQueryparams(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean flg;
        session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.jsp");
            //request.getRequestDispatcher("/contract.jsp").forward(request, response);
            return;
        }
        try {
            QueryEntity query = new QueryEntity();
            query.setParam0(request.getParameter("queryaccount"));
            query.setParam1(request.getParameter("queryyear"));
            query.setParam2(request.getParameter("queryperiod"));
            session.setAttribute("queryparams", query);
            flg = true;
        } catch (Exception e) {
            flg = false;
        }
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
    }

    protected void readMovement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void updateMovement(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void deleteMovement(HttpServletRequest request, HttpServletResponse response)
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

        CompanyEntity companyEntity = objCompany.SelectCompanyByName(request.getParameter("company"));
        session.setAttribute("companyses", companyEntity);
        try {
            QueryEntity queryEntity = (QueryEntity) session.getAttribute("queryparams");
            int account = Integer.parseInt(queryEntity.getParam0());
            int year = Integer.parseInt(queryEntity.getParam1());
            int month = Integer.parseInt(queryEntity.getParam2());
            //================================================================
            List<MovementEntity> listaMovimientos = objMovement.SelectAllMovementsByCompany(account, year, month);
            request.setAttribute("showmovements", !listaMovimientos.isEmpty());
            request.setAttribute("movements", listaMovimientos);
        } catch (Exception e) {
            Logger.getLogger(Movement.class.getName()).log(Level.SEVERE, null, e);
        }

        //================================================================
        request.setAttribute("companies", objCompany.SelectAllCompanyName());
        //request.setAttribute("banks", objCombo.SelectAllBanksName());
        request.setAttribute("accounts", objAccount.SelectAllAccountsDetailsByCompany(companyEntity.getId()));
        request.setAttribute("movementtype", objCombo.SelectAllOperationsType());
        request.setAttribute("accounttype", objCombo.SelectAllAccountsType());
        request.setAttribute("cointype", objCombo.SelectAllCurrenciesType());
        request.getRequestDispatcher("/movement.jsp").forward(request, response);

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
