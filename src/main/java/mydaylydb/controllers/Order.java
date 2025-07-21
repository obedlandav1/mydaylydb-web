/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mydaylydb.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mydaylydb.DAO.ComboDAO;
import mydaylydb.DAO.OrderDAO;
import mydaylydb.DAO.ProjectDAO;
import mydaylydb.DTO.OrderDTO;
import mydaylydb.entities.CompanyEntity;
import mydaylydb.entities.OrderEntity;
import mydaylydb.entities.ProjectEntity;

public class Order extends HttpServlet {

    HttpSession session;
    ComboDAO objCombo = new ComboDAO();
    ProjectDAO objProject = new ProjectDAO();
    OrderDAO objOrder = new OrderDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "load": {
                initComponents(request, response);
                break;
            }
            case "create": {
                createOrder(request, response);
                break;
            }
            case "read": {
                readOrder(request, response);
                break;
            }
            case "update": {
                updateOrder(request, response);
                break;
            }
            case "delete": {
                deleteOrder(request, response);
                break;
            }
        }
    }

    protected void createOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderEntity orderEntity = new OrderEntity();
        BufferedReader reader = request.getReader();
        //Gson gson = new Gson();
        //OrderDTO dto = gson.fromJson(reader, OrderDTO.class);
        ObjectMapper objectMapper = new ObjectMapper();
        OrderDTO dto = objectMapper.readValue(reader, OrderDTO.class);

        orderEntity.setProyecto(dto.getProject());
        orderEntity.setProveedor(dto.getProvider());
        orderEntity.setFechaorden(dto.getDateorder());
        orderEntity.setTipoorden(dto.getTypeorder());
        orderEntity.setDescripcionorden(dto.getDescription());
        orderEntity.setPlazoorden(Integer.parseInt(dto.getTerm()));
        orderEntity.setTipomoneda(dto.getCurrency());
        orderEntity.setFormapago(dto.getPayment());
        //================================================
        //String jsonBudget = gson.toJson(dto.getBudgetbody());
        orderEntity.setPresupuesto(objectMapper.writeValueAsString(dto.getBudgetbody()));
        //================================================ 
        //String jsonPayment = gson.toJson(dto.getPaymentdetail());
        orderEntity.setDetallepago(objectMapper.writeValueAsString(dto.getPaymentdetail()));
        //================================================ 
        //String jsonGeneral = gson.toJson(dto.getGenconsider());
        orderEntity.setConsgenrales(objectMapper.writeValueAsString(dto.getGenconsider()));
        //================================================
        //String jsonSpecific = gson.toJson(dto.getSpeconsider());
        orderEntity.setConsespecificas(objectMapper.writeValueAsString(dto.getSpeconsider()));
        //================================================ 
        orderEntity.setSubtotal1(Double.parseDouble(dto.getSubtotal1()));
        orderEntity.setTipocambio(Double.parseDouble(dto.getExchange()));
        orderEntity.setSubtotal2(Double.parseDouble(dto.getSubtotal2()));
        orderEntity.setExonerado(dto.getExonerated());
        orderEntity.setImponible(dto.getTaxable());
        orderEntity.setImpuesto(dto.getTax());
        orderEntity.setValortotal(dto.getTotal());
        orderEntity.setLetras(dto.getLetters());
        orderEntity.setEstado(1);

        boolean flg = objOrder.Create(orderEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");

    }

    protected void readOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(objOrder.ReadById(id));
            out.flush();
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        }
    }

    protected void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        OrderEntity orderEntity = new OrderEntity();
        BufferedReader reader = request.getReader();
        //Gson gson = new Gson();
        //OrderDTO dto = gson.fromJson(reader, OrderDTO.class);
        ObjectMapper objectMapper = new ObjectMapper();
        OrderDTO dto = objectMapper.readValue(reader, OrderDTO.class);

        orderEntity.setId(Integer.parseInt(request.getParameter("id")));
        orderEntity.setProveedor(dto.getProvider());
        orderEntity.setFechaorden(dto.getDateorder());
        orderEntity.setTipoorden(dto.getTypeorder());
        orderEntity.setDescripcionorden(dto.getDescription());
        orderEntity.setPlazoorden(Integer.parseInt(dto.getTerm()));
        orderEntity.setTipomoneda(dto.getCurrency());
        orderEntity.setFormapago(dto.getPayment());
        //================================================
        //String jsonBudget = gson.toJson(dto.getBudgetbody());
        orderEntity.setPresupuesto(objectMapper.writeValueAsString(dto.getBudgetbody()));
        //================================================ 
        //String jsonPayment = gson.toJson(dto.getPaymentdetail());
        orderEntity.setDetallepago(objectMapper.writeValueAsString(dto.getPaymentdetail()));
        //================================================ 
        //String jsonGeneral = gson.toJson(dto.getGenconsider());
        orderEntity.setConsgenrales(objectMapper.writeValueAsString(dto.getGenconsider()));
        //================================================
        //String jsonSpecific = gson.toJson(dto.getSpeconsider());
        orderEntity.setConsespecificas(objectMapper.writeValueAsString(dto.getSpeconsider()));
        //================================================ 
        orderEntity.setSubtotal1(Double.parseDouble(dto.getSubtotal1()));
        orderEntity.setTipocambio(Double.parseDouble(dto.getExchange()));
        orderEntity.setSubtotal2(Double.parseDouble(dto.getSubtotal2()));
        orderEntity.setExonerado(dto.getExonerated());
        orderEntity.setImponible(dto.getTaxable());
        orderEntity.setImpuesto(dto.getTax());
        orderEntity.setValortotal(dto.getTotal());
        orderEntity.setLetras(dto.getLetters());
        //orderEntity.setEstado(1);

        boolean flg = objOrder.Update(orderEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");

    }

    protected void deleteOrder(HttpServletRequest request, HttpServletResponse response)
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

        request.setAttribute("ordertypes", objCombo.SelectAllContractsType());
        request.setAttribute("ordercurrency", objCombo.SelectAllCurrenciesType());

        List<OrderEntity> listaOrdenes = objOrder.SelectAllOrdersByProject(projectEntity.getId());

        request.setAttribute("showorders", !listaOrdenes.isEmpty());
        request.setAttribute("orders", listaOrdenes);
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
