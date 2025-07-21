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
        <!-- Body content-->
        <section class="target">
            <%@include file="WEB-INF/jspf/header_main.jspf" %>
            <div class="col-lg-12 offset-lg-0 mt-2"> 
                <div class="row m-0">
                    <div class="col-4">  
                        <div class="container-fluid">
                            <div class="d-flex">
                                <div>    
                                    <img style="height: 45px; width: 45px;" id="logo" src="RESOURCES/img/img-transaccion-512.png" alt="mydaylydb/account"/>
                                </div>
                                &nbsp;
                                <div><h1>Movimientos</h1></div>
                            </div> 
                        </div> 
                        <div class="container-fluid">
                            <hr>
                            <strong style="font-size: 20px;">Empresas:</strong>
                            <div class="pagination pagination-lg">
                                <div class="row">
                                    <div class="d-flex">
                                        <c:forEach var="c" items="${companies}">
                                            <div>
                                                <button style="width: 10vw;" onclick="loadcompany('${c.nombrecorto}')" class="btn btn-primary">${c.nombrecorto}</button>&nbsp;
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
                            <div class="d-flex">
                                <div><strong style="font-size: 20px;">Nuevo movimiento:</strong></div>
                                <div class="ms-auto mb-2">
                                    <input type="file" id="input-excel" accept=".xlsx, .xls" style="display: none;"/>
                                    <label for="input-excel" class="btn btn-secondary">Carga masiva</label>
                                </div> 
                            </div> 
                            <form method="post" id= "create">
                                <div class="d-flex">
                                    <div class="form-floating w-50">
                                        <select class="form-select" id="newaccount" name="newaccount" aria-label="Floating label select example">
                                            <option></option>
                                            <c:forEach var="a" items="${accounts}">
                                                <option value="${a.id}">${a.numerocuenta}</option>    
                                            </c:forEach>
                                        </select>
                                        <label for="floatingSelect">Seleccione una cuenta</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                    &nbsp
                                    <div class="form-floating mb-1 w-50">
                                        <select class="form-select" id="newtype" name="newtype" aria-label="Floating label select example">
                                            <option></option>
                                            <c:forEach var="m" items="${movementtype}">
                                                <option value="${m.id}">${m.nombrelargo}</option>    
                                            </c:forEach>
                                        </select>
                                        <label for="floatingSelect">Seleccione tipo de operación</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                </div>
                                <div class="d-flex">
                                    <div class="form-floating w-50 mb-1">
                                        <input type="text" class="form-control datepicker" id="newvoucherdate" name="newvoucherdate">
                                        <label for="floatingInput">Ingrese fecha de comprobante</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                    &nbsp
                                    <div class="form-floating w-50">
                                        <input type="text" class="form-control datepicker" id="newoperationdate" name="newoperationdate">
                                        <label for="floatingInput">Ingrese fecha de la operación</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                </div>
                                <div class="d-flex">
                                    <div class="form-floating w-50 mb-1">
                                        <select class="form-select" id="newperiod" name="newperiod" aria-label="Floating label select example">
                                            <option></option>
                                            <option value="1">ENERO</option>    
                                            <option value="2">FEBRERO</option>    
                                            <option value="3">MARZO</option>    
                                            <option value="4">ABRIL</option>    
                                            <option value="5">MAYO</option>    
                                            <option value="6">JUNIO</option>    
                                            <option value="7">JULIO</option>    
                                            <option value="8">AGOSTO</option>    
                                            <option value="9">SEPTIEMBRE</option>    
                                            <option value="10">OCTUBRE</option>    
                                            <option value="11">NOVIEMBRE</option>    
                                            <option value="12">DICIEMBRE</option>        
                                        </select>
                                        <label for="floatingSelect">Seleccione periodo de operación</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                    &nbsp
                                    <div class="form-floating w-50 mb-1">
                                        <input type="text" class="form-control" id="newoperationnum" name="newoperationnum">
                                        <label for="floatingInput">Ingrese el número de operación</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                </div>
                                <div class="d-flex">
                                    <div class="form-floating w-50 mb-1">
                                        <input type="text" class="form-control" id="newdescription" name="newdescription">
                                        <label for="floatingInput">Ingrese la descripción de operación</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                    &nbsp
                                    <div class="form-floating w-50 mb-1">
                                        <input type="text" class="form-control" id="newbeneficiary" name="newbeneficiary">
                                        <label for="floatingInput">Ingrese el beneficiario de la operación</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                </div>
                                <div class="d-flex">
                                    <div class="form-floating w-100 mb-1">
                                        <input type="text" class="form-control" id="newgloss" name="newgloss">
                                        <label for="floatingInput">Ingrese la glosa del movimiento</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                </div>
                                <div class="d-flex">
                                    <div class="form-floating w-50 mb-1">
                                        <input type="text" class="form-control" id="newsubtotal" name="newsubtotal">
                                        <label for="floatingInput">Ingrese valor operación</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                    &nbsp
                                    <div class="form-floating w-50 mb-1">
                                        <input type="text" class="form-control" id="newexrate" name="newexrate">
                                        <label for="floatingInput">Ingrese tipo de cambio</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                </div>
                                <div class="d-flex">
                                    <div class="form-floating w-50 mb-1">
                                        <input type="text" class="form-control" id="newtotal" name="newtotal">
                                        <label for="floatingInput">Ingrese valor total de operación</label>
                                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                                    </div>
                                    &nbsp
                                    <div class="mt-2">
                                        <input type="file" id="input-voucher" accept=".pdf, .png, .jpg" style="display: none;"/>
                                        <label for="input-excel" class="btn btn-secondary">Carga comprobante</label>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Insertar movimiento</button>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-8">  
                        <div class="container-fluid">
                            <form id="querymovements" class="d-flex mb-2">
                                <strong style="font-size: 20px;" class="mt-3">Consulta:</strong>
                                <div class="form-floating ms-auto">
                                    <select class="form-select query-controls" id="queryaccount" name="queryaccount" aria-label="Floating label select example" required>
                                        <option></option>
                                        <c:forEach var="a" items="${accounts}">
                                            <option value="${a.id}">${a.numerocuenta}</option>    
                                        </c:forEach>
                                    </select>
                                    <label for="floatingSelect">Seleccione el numero de cuenta</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <div class="form-floating ms-auto">
                                    <select class="form-select query-controls" id="queryyear" name="queryyear" aria-label="Floating label select example" required>
                                        <option></option>
                                        <option value="2017">2017</option>
                                        <option value="2018">2018</option>
                                        <option value="2019">2019</option>
                                        <option value="2020">2020</option>
                                        <option value="2021">2021</option>
                                        <option value="2022">2022</option>
                                        <option value="2023">2023</option>
                                        <option value="2024">2024</option>
                                        <option value="2025">2025</option>
                                        <option value="2026">2026</option>
                                        <option value="2027">2027</option>
                                        <option value="2028">2028</option>
                                        <option value="2029">2029</option>
                                        <option value="2030">2030</option>
                                    </select>
                                    <label for="floatingSelect">Seleccione el año de operación</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <div class="form-floating ms-auto">
                                    <select class="form-select query-controls" id="queryperiod" name="queryperiod" aria-label="Floating label select example" required>
                                        <option></option>
                                        <option value="1">ENERO</option>    
                                        <option value="2">FEBRERO</option>    
                                        <option value="3">MARZO</option>    
                                        <option value="4">ABRIL</option>    
                                        <option value="5">MAYO</option>    
                                        <option value="6">JUNIO</option>    
                                        <option value="7">JULIO</option>    
                                        <option value="8">AGOSTO</option>    
                                        <option value="9">SEPTIEMBRE</option>    
                                        <option value="10">OCTUBRE</option>    
                                        <option value="11">NOVIEMBRE</option>    
                                        <option value="12">DICIEMBRE</option>        
                                    </select>
                                    <label for="floatingSelect">Seleccione periodo de operación</label>
                                    <div class="invalid-feedback">Este campo es obligatorio.</div>
                                </div>
                                <button type="submit" onclick="searchmovement(${a.id})" class="btn btn-success ms-auto">
                                    <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/wallet.svg" width="16" height="16" data-bs-toggle="tooltip">Cargar búsqueda                                         
                                </button>
                            </form>
                            <hr>
                            <div class="d-flex">
                                <div class="mt-3">                                
                                    <strong style="font-size: 20px;" class="mt-3">Registro:</strong>
                                </div>
                                <div class="d-flex w-50 mb-2 ms-auto">   
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="initialamount" name="initialamount" disabled>
                                        <label for="floatingInput">Saldo Inicial</label>
                                    </div>
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="deposits" name="deposits" disabled>
                                        <label for="floatingInput">Ingresos</label>
                                    </div>
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="charges" name="charges" disabled>
                                        <label for="floatingInput">Egresos</label>
                                    </div>
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="finalamount" name="finalamount" disabled>
                                        <label for="floatingInput">Saldo Final</label>
                                    </div>
                                </div>
                            </div>
                            <table style="max-height: 300px; overflow-y: auto;" class="table table-sm fs-6 table-responsive caption-top table-striped" id="tbl-accounts">
                                <thead class="table-active text-center align-middle"> 
                                    <tr>
                                        <th scope="col">N°</th>
                                        <th scope="col">Fecha Operación</th>
                                        <th scope="col">Periodo Operación</th>
                                        <th scope="col">N° Operación</th>
                                        <th scope="col">Glosa</th>
                                        <th scope="col">Descripción</th>
                                        <th scope="col">Abono</th>
                                        <th scope="col">Cargo</th>
                                        <th scope="col">Saldo</th>
                                        <th scope="col">Tipo Operación</th>
                                        <th style="width: 225px;" scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${showmovements}">
                                        <% int i = 1;%>
                                        <% int j = 0;%>                                        
                                        <c:forEach var="m" items="${movements}">
                                            <tr>
                                                <th scope="row"><%=i++%></th>
                                                <td>${m.fechaemision}</td>
                                                <td>${m.fechaoperacion}</td>
                                                <td>${m.numerooperacion}</td>
                                                <td>${m.glosaoperacion}</td>
                                                <td>${m.descripcionoperacion}</td>
                                                <c:choose>
                                                    <c:when test="${m.tipooperacion == 'INGRESO'}">
                                                        <td>${m.montooperacion1}</td>
                                                        <td>0</td>
                                                        <td></td>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <td>0</td>
                                                        <td>${m.montooperacion1}</td>
                                                        <td></td>
                                                    </c:otherwise>
                                                </c:choose>
                                                <td>${m.tipooperacion}</td>
                                                <td>
                                                    <button style="width: 50px;" onclick="uploadvoucher(${m.id})" class="btn btn-success">
                                                        <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/wallet.svg" width="16" height="16" Title="Movimientos" data-bs-toggle="tooltip">                                         
                                                    </button>
                                                    <button style="width: 50px;" onclick="showvoucher(${m.id})" class="btn btn-success">
                                                        <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/accounts.svg" width="16" height="16" Title="Estados de cuenta" data-bs-toggle="tooltip">                                         
                                                    </button> 
                                                    <button style="width: 50px;" onclick="loadaccount(${m.id})" type="button" class="btn btn-warning">
                                                        <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/pencil.svg" width="16" height="16" Title="Editar" data-bs-toggle="tooltip"> 
                                                    </button>
                                                    <button style="width: 50px;" onclick="deleteaccount(${m.id})" type="button" class="btn btn-danger">
                                                        <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/trash.svg" width="16" height="16" Title="Eliminar" data-bs-toggle="tooltip"> 
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                </tbody> 
                            </table>
                            <c:if test="${!showmovements}">
                                <div class="alert alert-danger">
                                    No existen registros o debe seleccionar una empresa.
                                </div>
                            </c:if>  
                        </div>
                    </div>
                </div>
            </div>  
            <!--Button Trigger Account Modal-->
            <button id="editmodal" class="btn btn-primary invisible" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button>                                                        
        </section>


        <section class="target">
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
                                <div class="row">
                                    <div class="col">
                                        <div class="form-floating">
                                            <select class="form-select" id="editaccount" name="editaccount" aria-label="Floating label select example">
                                                <option></option>
                                                <c:forEach var="a" items="${accounts}">
                                                    <option value="${a.id}">${a.numerocuenta}</option>    
                                                </c:forEach>
                                            </select>
                                            <label for="floatingSelect">Seleccione una cuenta</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <select class="form-select" id="edittype" name="edittype" aria-label="Floating label select example">
                                                <option></option>
                                                <c:forEach var="m" items="${movementtype}">
                                                    <option value="${m.id}">${m.nombrelargo}</option>    
                                                </c:forEach>
                                            </select>
                                            <label for="floatingSelect">Seleccione tipo de operación</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="form-floating">
                                            <input type="text" class="form-control datepicker" id="editdate" name="editdate">
                                            <label for="floatingInput">Ingrese fecha de la operación</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>  
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <select class="form-select" id="editperiod" name="editperiod" aria-label="Floating label select example">
                                                <option></option>
                                                <option value="ENERO">ENERO</option>    
                                                <option value="FEBRERO">FEBRERO</option>    
                                                <option value="MARZO">MARZO</option>    
                                                <option value="ABRIL">ABRIL</option>    
                                                <option value="MAYO">MAYO</option>    
                                                <option value="JUNIO">JUNIO</option>    
                                                <option value="JULIO">JULIO</option>    
                                                <option value="AGOSTO">AGOSTO</option>    
                                                <option value="SEPTIEMBRE">SEPTIEMBRE</option>    
                                                <option value="OCTUBRE">OCTUBRE</option>    
                                                <option value="NOVIEMBRE">NOVIEMBRE</option>    
                                                <option value="DICIEMBRE">DICIEMBRE</option>        
                                            </select>
                                            <label for="floatingSelect">Seleccione periodo de operación</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="editdescription" name="editdescription">
                                            <label for="floatingInput">Ingrese la descripción de operación</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="editbenefit" name="editbenefit">
                                            <label for="floatingInput">Ingrese el beneficiario</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="editsubtotal" name="editsubtotal">
                                            <label for="floatingInput">Ingrese valor operación</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="editexrate" name="editexrate">
                                            <label for="floatingInput">Ingrese tipo de cambio</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="edittotal" name="edittotal">
                                            <label for="floatingInput">Ingrese valor total de operación</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="ms-auto mt-2">
                                            <input type="file" id="input-voucher" accept=".pdf, .png, .jpg" style="display: none;"/>
                                            <label for="input-excel" class="btn btn-secondary">Carga comprobante</label>
                                        </div> 
                                    </div>        
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
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
        <%@include file="WEB-INF/jspf/scripts_movement.jspf" %>
    </body>        
</html>
