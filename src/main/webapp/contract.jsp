<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Contratos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@include file="WEB-INF/jspf/main.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <!-- Body content-->
        <section class="col-lg-8 offset-lg-2">
            <div class="container-fluid">
                <div class="d-flex">
                    <div>
                        <img style="height: 50px; width: 50px;" id="logo" src="RESOURCES/img/img-project-512.png" alt="mydaylydb/project"/>
                    </div>
                    &nbsp;
                    <div><h1>Proyectos/Contratos</h1></div>
                </div> 
            </div> 
            <div class="container-fluid">
                <hr>
                <h1 style="font-size: 20px;">Tipo contratos:</h1>
                <div class="pagination pagination-lg">
                    <div class="row">
                        <div class="d-flex">
                            <c:forEach var="t" items="${contracttypes}">
                                <a style="width: 150px;" href="contract?action=load?type=${t.id}" class="btn btn-primary">${t.nombrecorto}</a>&nbsp;
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <hr>
                <div class="d-flex justify-content-between">
                    <div><h1 style="font-size: 20px;" class="data">Registro:</h1></div>
                    <div><button style="width: 200px;" onclick="createcontract('<%=com%>',<%=companyid%>)" type="button" class="btn btn-primary">Crear proyecto</button></div>
                </div> 
                <table style="max-height: 300px; overflow-y: auto;" class="table table-responsive caption-top" id="tbl-contract">
                    <thead>
                        <tr>
                            <th scope="col">N°</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">plazo</th>
                            <th scope="col">Forma pago</th>
                            <th scope="col">Moneda</th>
                            <th scope="col">Exonerado</th>
                            <th scope="col">Imponible</th>
                            <th scope="col">Impuesto</th>
                            <th scope="col">Total</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${showcontracts}">
                            <% int j = 1;%>
                            <c:forEach var="p" items="${contracts}">
                                <tr>
                                    <th scope="row"><%=j++%></th>
                                    <td>${p.nombrecorto}</td>
                                    <td>${p.nombrelargo}</td>
                                    <td>${p.plazoproyecto}</td>
                                    <td>${p.montoproyecto}</td>
                                    <td>
                                        <button style="width: 100px;" onclick="showcontracts('<%=com%>',${p.id})" type="button" class="btn btn-info">Contratos</button>                                        
                                        <button style="width: 100px;" onclick="editproject('<%=com%>',${p.id})" type="button" class="btn btn-warning">Editar</button>
                                        <button style="width: 100px;" onclick="deleteproject('<%=com%>',${p.id})" type="button" class="btn btn-danger">Eliminar</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
                <c:if test="${!showcontracts}">
                    <div class="alert alert-secondary">
                        No existen registros.
                    </div>
                </c:if>  
            </div>
            <!--Button Trigger Project Modal-->
            <button id="contractmodal" class="btn btn-primary invisible" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button>
            <!--Project Modal-->
            <div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel2"></h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="post" id="contractform" >
                            <div class="modal-body">
                                <!--<input type="hidden" id="editid" name="editid">-->
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="projectnombrec" name="projectnombrec">
                                    <label for="floatingInput">Ingrese el nombre corto del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="projectnombrel" name="projectnombrel">
                                    <label for="floatingInput">Ingrese el nombre completo del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="projectplazo" name="projectplazo">
                                    <label for="floatingInput">Ingrese el plazo del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="projectvalor" name="projectvalor">
                                    <label for="floatingInput">Ingrese el valor adjudicado del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary" >Guardar</button>
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
        <%@include file="WEB-INF/jspf/scripts_contract.jspf" %>
    </body>        
</html>

