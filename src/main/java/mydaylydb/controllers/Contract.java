package mydaylydb.controllers;

import mydaylydb.DTO.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mydaylydb.DAO.ComboDAO;
import mydaylydb.DAO.ContractDAO;
import mydaylydb.DAO.ProjectDAO;
//import mydaylydb.entities.ComboEntity;
import mydaylydb.entities.CompanyEntity;
import mydaylydb.entities.ContractEntity;
import mydaylydb.entities.ProjectEntity;
//import org.json.JSONArray;

public class Contract extends HttpServlet {

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

        ContractEntity contractEntity = new ContractEntity();
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        ContractDTO dto = gson.fromJson(reader, ContractDTO.class);

        contractEntity.setProyectos(dto.getProject());
        contractEntity.setClientes(dto.getClient());
        contractEntity.setTipocontrato(dto.getTypecontract());
        contractEntity.setTipomoneda(dto.getCurrency());
        contractEntity.setDescripcioncontrato(dto.getDescription());
        contractEntity.setPlazocontrato(Integer.parseInt(dto.getTerm()));
        contractEntity.setFormapago(dto.getPayment());
        //================================================
        String json = gson.toJson(dto.getPaydetail());
        contractEntity.setDetallepago(json);
        //================================================        
        contractEntity.setExonerado(dto.getExonerated());
        contractEntity.setImponible(dto.getTaxable());
        contractEntity.setImpuesto(dto.getTax());
        contractEntity.setValortotal(dto.getTotal());
        contractEntity.setEstado(1);

        boolean flg = objContract.Create(contractEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
    }

    protected void readContract(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(objContract.ReadById(id));
            out.flush();
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        }       
    }

    protected void updateContract(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ContractEntity contractEntity = new ContractEntity();
        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        ContractDTO dto = gson.fromJson(reader, ContractDTO.class);

        contractEntity.setId(Integer.parseInt(request.getParameter("id")));
        contractEntity.setClientes(dto.getClient());
        contractEntity.setTipocontrato(dto.getTypecontract());
        contractEntity.setTipomoneda(dto.getCurrency());
        contractEntity.setDescripcioncontrato(dto.getDescription());
        contractEntity.setPlazocontrato(Integer.parseInt(dto.getTerm()));
        contractEntity.setFormapago(dto.getPayment());
        //================================================
        String json = gson.toJson(dto.getPaydetail());
        contractEntity.setDetallepago(json);
        //================================================        
        contractEntity.setExonerado(dto.getExonerated());
        contractEntity.setImponible(dto.getTaxable());
        contractEntity.setImpuesto(dto.getTax());
        contractEntity.setValortotal(dto.getTotal());

        boolean flg = objContract.Update(contractEntity);
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
    }

    protected void deleteContract(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //String company = request.getParameter("company");
        boolean flg = objContract.Delete(Integer.parseInt(request.getParameter("id")));
        response.setContentType("application/json");
        response.getWriter().write("{\"success\": " + flg + "}");
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
        
        request.setAttribute("contracttypes", objCombo.SelectAllContractsType());
        request.setAttribute("contractcurrency", objCombo.SelectAllCurrenciesType());
        List<ContractEntity> listaContratos = objContract.SelectAllContractsByProject(projectEntity.getId());
        request.setAttribute("showcontracts", !listaContratos.isEmpty());
        request.setAttribute("contracts", listaContratos);
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

/**
 * List<ContractEntity> Contratos =
 * objContract.SelectAllContractsByCompany(companyEntity.getId());
 * //===============================================================================
 * List<ContractDTO> listaContratos = Contratos.stream().map(Entity -> {
 * ContractDTO dto = new ContractDTO();
 * dto.setId(Integer.toString(Entity.getId()));
 * dto.setClient(Entity.getClientes_id());
 * dto.setTypecontract(Entity.getTipocontrato_id());
 * dto.setCurrency(Entity.getTipomoneda_id());
 * dto.setDescription(Entity.getDescripcioncontrato());
 * dto.setTerm(Integer.toString(Entity.getPlazocontrato()));
 * dto.setPayment(Entity.getTipopagocontrato()); System.out.println("Valor de
 * tipopagocontrato: " + Entity.getFormapagocontrato());
 * //-------------------------------------------------------- Gson gson = new
 * Gson(); Type PayDetail = new TypeToken<List<PaymentDetailDTO>>() {
 * }.getType(); List<PaymentDetailDTO> Detail =
 * gson.fromJson(Entity.getFormapagocontrato(), PayDetail);
 * dto.setPaydetail(Detail);
 * //--------------------------------------------------------
 * dto.setExonerated(Entity.getExonerado());
 * dto.setTaxable(Entity.getImponible()); dto.setTax(Entity.getImpuesto());
 * dto.setTotal(Entity.getValortotal()); return dto;
 * }).collect(Collectors.toList());
 * //===============================================================================
 * request.setAttribute("showcontracts", !listaContratos.isEmpty());
 *
 */
