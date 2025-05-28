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
        <section class="col-lg-8 offset-lg-2">
            <div class="container-fluid">
                <div class="d-flex">
                    <div>    
                        <img style="height: 50px; width: 50px;" id="logo" src="RESOURCES/img/img-account-512.png" alt="mydaylydb/account"/>
                    </div>
                    &nbsp;
                    <div><h1>Cuentas</h1></div>
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
                <h1 style="font-size: 20px;">Nueva cuenta:</h1>        
                <form method="post" id= "create">
                    <div class="row">
                        <div class="col">
                            <div class="form-floating">
                                <select class="form-select" id="newbanco" name="newbanco" aria-label="Floating label select example">
                                    <option></option>
                                    <c:forEach var="b" items="${banks}">
                                        <option value="${b.id}">${b.nombrelargo}</option>    
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Seleccione un banco</label>
                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="newcuenta" name="newcuenta">
                                <label for="floatingInput">Ingrese el numero de cuenta</label>
                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-floating">
                                <select class="form-select" id="newtipo" name="newtipo" aria-label="Floating label select example">
                                    <option></option>
                                    <c:forEach var="t" items="${accounttype}">
                                        <option value="${t.id}">${t.nombrelargo}</option>    
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Seleccione tipo cuenta</label>
                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                            </div>
                        </div>  
                        <div class="col">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="newcci" name="newcci">
                                <label for="floatingInput">Ingrese el numero interbancario</label>
                                <!--<div class="invalid-feedback">Este campo es obligatorio.</div>-->
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-floating mb-3">
                                <select class="form-select" id="newmoneda" name="newmoneda" aria-label="Floating label select example">
                                    <option></option>
                                    <c:forEach var="co" items="${cointype}">
                                        <option value="${co.id}">${co.nombrelargo}</option>    
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Seleccione tipo moneda</label>
                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                            </div>
                        </div>
                        <div class="col">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Crear cuenta</button>
                </form>
            </div>
            <div class="container-fluid">
                <hr>
                <h1 style="font-size: 20px;" class="data">Registro:</h1> 
                <table class="table caption-top" id="tbl-accounts">
                    <thead>
                        <tr>
                            <th scope="col">N°</th>
                            <th scope="col">Banco</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Moneda</th>
                            <th scope="col">N° Cuenta</th>
                            <th scope="col">N° Interbancario</th>                            
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${showaccounts}">
                            <% int i = 1;%>
                            <c:forEach var="a" items="${accounts}">
                                <tr>
                                    <th scope="row"><%=i++%></th>
                                    <td>${a.bancos_id}</td>
                                    <td>${a.tipocuenta_id}</td>
                                    <td>${a.tipomoneda_id}</td>
                                    <td>${a.numerocuenta}</td>
                                    <td>${a.numerointerbancario}</td>
                                    <td>
                                        <button style="width: 100px;" onclick="loadaccount(${a.id})" type="button" class="btn btn-warning">Editar</button>
                                        <button style="width: 100px;" onclick="deleteaccount(${a.id})" type="button" class="btn btn-danger">Eliminar</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody> 
                </table>
                <c:if test="${!showaccounts}">
                    <div class="alert alert-secondary">
                        No existen registros o debe seleccionar una empresa.
                    </div>
                </c:if>  
            </div>
        </section>
        <!--Button Trigger Account Modal-->
        <button id="editmodal" class="btn btn-primary invisible" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button>
        <!--Account Modal-->
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropEditLabel"></h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="post" id="edit" >
                        <div class="modal-body">
                            <input type="hidden" id="editid" name="editid">
                            <div class="form-floating">
                                <select class="form-select" id="editbanco" name="editbanco" aria-label="Floating label select example">
                                    <option></option>
                                    <c:forEach var="b" items="${banks}">
                                        <option value="${b.id}">${b.nombrelargo}</option>    
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Seleccione un banco</label>
                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                            </div>
                            <br>
                            <div class="form-floating">
                                <select class="form-select" id="edittipo" name="edittipo" aria-label="Floating label select example">
                                    <option></option>
                                    <c:forEach var="t" items="${accounttype}">
                                        <option value="${t.id}">${t.nombrelargo}</option>    
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Seleccione tipo cuenta</label>
                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                            </div>
                            <br>
                            <div class="form-floating mb-3">
                                <select class="form-select" id="editmoneda" name="editmoneda" aria-label="Floating label select example">
                                    <option></option>
                                    <c:forEach var="co" items="${cointype}">
                                        <option value="${co.id}">${co.nombrelargo}</option>    
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Seleccione tipo moneda</label>
                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                            </div>
                            <br>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="editcuenta" name="editcuenta">
                                <label for="floatingInput">Ingrese el numero de cuenta</label>
                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                            </div>
                            <br>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="editcci" name="editcci">
                                <label for="floatingInput">Ingrese el numero interbancario</label>
                                <!--<div class="invalid-feedback">Este campo es obligatorio.</div>-->
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" >Guardar</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
        <%@include file="WEB-INF/jspf/scripts_account.jspf" %>
    </body>        
</html>
