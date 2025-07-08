package mydaylydb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mydaylydb.DAO.ProviderDAO;
import mydaylydb.entities.ProviderEntity;

public class Provider extends HttpServlet {

    ProviderDAO objProvider = new ProviderDAO();

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
                createProvider(request, response);
                break;
            }
            case "read": {
                readProvider(request, response);
                break;
            }
            case "find": {
                findProvider(request, response);
                break;
            }
            case "update": {
                updateProvider(request, response);
                break;
            }
            case "delete": {
                deleteProvider(request, response);
                break;
            }
        }
    }

        protected void createProvider(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProviderEntity providerEntity  = new ProviderEntity();
        providerEntity.setNombreproveedor(request.getParameter("newpro"));
        providerEntity.setTipodocumento_id(request.getParameter("newtype"));
        providerEntity.setIdentidadproveedor(request.getParameter("newiden"));
        providerEntity.setDireccionproveedor(request.getParameter("newadd"));
        providerEntity.setDistritoproveedor(request.getParameter("newdist"));
        providerEntity.setCiudadproveedor(request.getParameter("newcity"));
        providerEntity.setBancoproveedor(request.getParameter("newban"));
        providerEntity.setCuentaproveedor(request.getParameter("newacc"));
        providerEntity.setCciproveedor(request.getParameter("newcci"));
        providerEntity.setTelefonoproveedor(request.getParameter("newtel"));
        providerEntity.setCorreoproveedor(request.getParameter("newemail"));
        providerEntity.setEstado(1);

        boolean flg = objProvider.Create(providerEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
    }

    protected void readProvider(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void findProvider(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(objProvider.SelectProviderByLikeName(name));
            out.flush();
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        }
    }

    protected void updateProvider(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void deleteProvider(HttpServletRequest request, HttpServletResponse response)
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
