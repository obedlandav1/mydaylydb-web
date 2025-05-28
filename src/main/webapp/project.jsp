<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cuentas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@include file="WEB-INF/jspf/main.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <!-- Body content-->
        <section class="col-lg-10 offset-lg-1">
            <div class="container-fluid">
                <div class="d-flex">
                    <div>
                        <img style="height: 50px; width: 50px;" id="logo" src="RESOURCES/img/img-project-512.png" alt="mydaylydb/project"/>
                    </div>
                    &nbsp;
                    <div><h1>Proyectos</h1></div>
                </div> 
            </div> 
            <div class="container-fluid">
                <hr>
                <h1 style="font-size: 20px;">Empresas:</h1>
                <div class="pagination pagination-lg">
                    <div class="row">
                        <div class="d-flex">
                            <c:forEach var="c" items="${companies}">
                                <div>
                                    <button style="width: 150px;" onclick="loadcompany('${c.nombrecorto}')" class="btn btn-primary">${c.nombrecorto}</button>&nbsp;
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <hr>
                <input type="hidden" id="company" name="company" value="${companyses.nombrecorto}">
                <input type="hidden" id="companyid" name="companyid" value="${companyses.id}">
                <input type="hidden" id="projectid" name="projectid">
                <div class="d-flex justify-content-between">
                    <div><h1 style="font-size: 20px;" class="data">Registro:</h1></div>
                    <div><button style="width: 200px;" onclick="newproject()" type="button" class="btn btn-primary">Crear proyecto</button></div>
                </div> 
                <table style="max-height: 300px; overflow-y: auto;" class="table table-responsive caption-top" id="tbl-project">
                    <thead>
                        <tr>
                            <th scope="col">N°</th>
                            <th scope="col">Nombre corto</th>
                            <th scope="col">Nombre completo</th>
                            <th scope="col">Plazo</th>
                            <th scope="col">Monto adjudicado</th>                            
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${showprojects}">
                            <% int i = 1;%>
                            <c:forEach var="p" items="${projects}">
                                <tr>
                                    <th scope="row"><%=i++%></th>
                                    <td>${p.nombrecorto}</td>
                                    <td>${p.nombrelargo}</td>
                                    <td>${p.plazoproyecto}</td>
                                    <td>${p.montoproyecto}
                                    </td>
                                    <td>                                       
                                        <a style="width: 100px;" href="contract?action=load" class="btn btn-info">Contratos</a> 
                                        <a style="width: 100px;" href="order?action=load" class="btn btn-success">Ordenes</a> 
                                        <a style="width: 100px;" onclick="loadproject(${p.id})" class="btn btn-warning">Editar</a>
                                        <a style="width: 100px;" onclick="deleteproject(${p.id})" class="btn btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
                <c:if test="${!showprojects}">
                    <div class="alert alert-secondary">
                        No existen registros o debe seleccionar una empresa.
                    </div>
                </c:if>  
            </div>
            <!--Button Trigger Create Modal-->
            <button id="createmodal" class="btn btn-primary invisible" data-bs-toggle="modal" data-bs-target="#staticBackdrop1"></button>
            <!--Project Create Modal-->
            <div class="modal fade" id="staticBackdrop1" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropCreateLabel"></h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="post" id="create" >
                            <div class="modal-body">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="newcorto" name="newcorto">
                                    <label for="floatingInput">Ingrese el nombre corto del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="newlargo" name="newlargo">
                                    <label for="floatingInput">Ingrese el nombre completo del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="newplazo" name="newplazo">
                                    <label for="floatingInput">Ingrese el plazo del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="newmonto" name="newmonto">
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
            <!--Button Trigger Edit Modal-->
            <button id="editmodal" class="btn btn-primary invisible" data-bs-toggle="modal" data-bs-target="#staticBackdrop2"></button>
            <!--Project Edit Modal-->
            <div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropEditLabel"></h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="post" id="edit">
                            <div class="modal-body">
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="editcorto" name="editcorto">
                                    <label for="floatingInput">Ingrese el nombre corto del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="editlargo" name="editlargo">
                                    <label for="floatingInput">Ingrese el nombre completo del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="editplazo" name="editplazo">
                                    <label for="floatingInput">Ingrese el plazo del proyecto</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <br>
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="editmonto" name="editmonto">
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
        <%@include file="WEB-INF/jspf/scripts_project.jspf"%>
    </body>        
</html>

