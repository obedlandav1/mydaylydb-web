package mydaylydb.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mydaylydb.DAO.LoginDAO;
import mydaylydb.entities.CompanyEntity;
import mydaylydb.entities.UserEntity;

public class Login extends HttpServlet {

    LoginDAO obj = new LoginDAO();
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        doLogin(request, response);

    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserEntity userEntity = new UserEntity();
        userEntity.setIdentidadusuario(request.getParameter("user"));
        userEntity.setPasswordusuario(request.getParameter("password"));

        boolean flg = obj.AuthenticateUser(userEntity);
        if (flg) {
            userEntity = obj.SelectUser(request.getParameter("user"));
            session = request.getSession();
            session.setAttribute("userses", userEntity);
            session.setAttribute("companyses", new CompanyEntity());

            response.setContentType("application/json");
            response.getWriter().write("{\"success\": " + flg + "}");
            //request.getRequestDispatcher("/home.jsp").forward(request, response);;
        } else {
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": " + flg + "}");
            //request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
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
