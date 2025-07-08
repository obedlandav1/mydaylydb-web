package mydaylydb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mydaylydb.DAO.ClientDAO;
import mydaylydb.entities.ClientEntity;

public class Client extends HttpServlet {

    ClientDAO objClient = new ClientDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "load": {
                initComponents(request, response);
                break;
            }
            case "create": {
                createClient(request, response);
                break;
            }
            case "read": {
                readClient(request, response);
                break;
            }
            case "find": {
                findClient(request, response);
                break;
            }
            case "update": {
                updateClient(request, response);
                break;
            }
            case "delete": {
                deleteClient(request, response);
                break;
            }
        }
    }

    protected void createClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setRazonsocial_id(request.getParameter("companyid"));
        clientEntity.setTipodocumento_id(request.getParameter("newtype"));
        clientEntity.setNombrecliente(request.getParameter("newcli"));
        clientEntity.setIdentidadcliente(request.getParameter("newiden"));
        clientEntity.setDireccioncliente(request.getParameter("newadd"));
        clientEntity.setDistritocliente(request.getParameter("newdist"));
        clientEntity.setCiudadcliente(request.getParameter("newcity"));
        clientEntity.setTelefonocliente(request.getParameter("newtel"));
        clientEntity.setCorreocliente(request.getParameter("newemail"));
        clientEntity.setEstado(1);

        boolean flg = objClient.Create(clientEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
    }

    protected void readClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void findClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(objClient.SelectClientByLikeName(name));
            out.flush();
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        }
    }

    protected void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void initComponents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
