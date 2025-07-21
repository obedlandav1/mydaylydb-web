<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Ordenes</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@include file="WEB-INF/jspf/main.jspf" %>
    </head>
    <body>
        <section class="target">
            <%@include file="WEB-INF/jspf/header_contract.jspf" %>
            <!-- Body content-->
            <div class="col-lg-10 offset-lg-1 mt-2">
                <div class="container-fluid">
                    <div class="d-flex">
                        <div>
                            <img style="height: 45px; width: 45px;" id="logo" src="RESOURCES/img/img-orders-512.png" alt="mydaylydb/project"/>
                        </div>
                        &nbsp;
                        <div><h1>Proyectos/Ordenes</h1></div>
                    </div> 
                </div> 
                <div class="container-fluid">
                    <hr>
                    <input type="hidden" id="companyid" name="companyid" value="${companyses.id}">
                    <input type="hidden" id="projectid" name="projectid" value="${projectses.id}">  
                    <input type="hidden" id="projectname" name="projectname" value="${projectses.nombrecorto}">
                    <input type="hidden" id="orderid" name="orderid"> 
                    <div class="d-flex justify-content-between">
                        <div><h1 style="font-size: 35px;" class="data"><strong>Registro:</strong></h1></div>
                        <div><button style="width: 200px;" onclick="neworder()" type="button" class="btn btn-primary">Crear orden</button></div>
                    </div> 
                    <table style="max-height: 300px; overflow-y: auto;" class="table table-sm fs-6 table-responsive caption-top table-striped" id="tbl-order">
                        <thead class="table-active text-center align-middle">                        
                            <tr>
                                <th scope="col">N°</th>
                                <th scope="col">Cliente</th>
                                <th scope="col">Tipo</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">Plazo orden</th>
                                <th scope="col">Plazo restante</th>
                                <th scope="col">Adjudicado S/</th>
                                <th scope="col">Pagado S/</th>
                                <th scope="col">Por pagar S/</th>
                                <th scope="col">Avance económico %</th>
                                <th scope="col">Avance físico %</th>
                                <th style="width: 350px;" scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${showorders}">
                                <% int j = 1;%>
                                <c:forEach var="o" items="${orders}">
                                    <tr>
                                        <th scope="row"><%=j++%></th>
                                        <td>${o.proveedor}</td>
                                        <td>${o.tipoorden}</td>
                                        <td>${o.descripcionorden}</td>
                                        <td></td>
                                        <td></td>
                                        <td>${o.valortotal}</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td>                                       
                                            <button style="width: 50px;" onclick="showpdf(${o.id})" type="button" class="btn btn-danger">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/pdf.svg" width="16" height="16" Title="Ver PDF" data-bs-toggle="tooltip"> 
                                            </button>
                                            <button style="width: 50px;" onclick="downloadpdf(${o.id})" type="button" class="btn btn-success">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/download.svg" width="16" height="16" Title="Descargar PDF" data-bs-toggle="tooltip"> 
                                            </button>
                                            <button style="width: 50px;" onclick="performancereport(${o.id})" type="button" class="btn btn-success">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/report.svg" width="16" height="16" Title="Informe avance" data-bs-toggle="tooltip"> 
                                            </button>
                                            <button style="width: 50px;" onclick="settlementreport(${o.id})" type="button" class="btn btn-success">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/finish.svg" width="16" height="16" Title="Generar Liquidacion" data-bs-toggle="tooltip"> 
                                            </button>
                                            <button style="width: 50px;" onclick="loadorder(${o.id})" type="button" class="btn btn-warning">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/pencil.svg" width="16" height="16" Title="Editar" data-bs-toggle="tooltip"> 
                                            </button>
                                            <button style="width: 50px;" onclick="deleteorder(${o.id})" type="button" class="btn btn-danger">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/trash.svg" width="16" height="16" Title="Eliminar" data-bs-toggle="tooltip"> 
                                            </button>                                            
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                    <c:if test="${!showorders}">
                        <div class="alert alert-secondary">
                            No existen registros.
                        </div>
                    </c:if>  
                </div>
                <!--Button Trigger New Contract-->
                <button id="modal" class="btn btn-primary invisible" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button>
        </section>
        <section class="target">
            <!--New Contract Modal-->
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel"></h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form id="createprov" class="mb-2">    
                            </form> 
                            <form method="post" id="orderform">
                                <div class="row">      
                                    <div class="form-floating mb-2">
                                        <button id="btn-collapse" 
                                                class="btn btn-info" 
                                                type="button" 
                                                data-bs-toggle="collapse" 
                                                data-bs-target="#provider" 
                                                aria-expanded="true" 
                                                aria-controls="provider">▼
                                        </button>
                                        &nbsp;
                                        <strong>Proveedor</strong>
                                    </div>
                                </div>
                                <div id="provider" class="collapse show">
                                    <div class="row d-flex">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-2">
                                                <input type="hidden" id="providerid" name="providerid">
                                                <input type="text" class="form-control" id="providername" name="providername" autocomplete="off">
                                                <label for="floatingInput">Ingrese el proveedor</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                                <ul id="providersearch" class="list-group position-absolute w-100 z-3"></ul>
                                            </div>
                                        </div>
                                        <div class="col-md-2 mt-3">
                                            <div class="form-check form-switch">
                                                <input class="form-check-input" type="checkbox" role="switch" name="providerswitch" id="providerswitch">
                                                <label class="form-check-label" for="providerswitch">+Nuevo</label>
                                            </div>                                        
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="form-floating mb-2">
                                        <button id="btn-collapse" 
                                                class="btn btn-info" 
                                                type="button" 
                                                data-bs-toggle="collapse" 
                                                data-bs-target="#description" 
                                                aria-expanded="true" 
                                                aria-controls="description">▼
                                        </button>
                                        &nbsp;
                                        <strong>Descripcion de la orden</strong>
                                    </div>
                                </div>
                                <div id="description" class="collapse show">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-2">
                                                <input type="date" id="orderdate" name="orderdate" class="form-control datepicker item" placeholder="Fecha">
                                                <label for="floatingSelect">Fecha emision de orden</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-2">
                                                <select class="form-select" id="ordertype" name="ordertype" aria-label="Floating label select example">
                                                    <option></option>
                                                    <c:forEach var="ot" items="${ordertypes}">
                                                        <option value="${ot.id}">${ot.nombrelargo}</option>    
                                                    </c:forEach>
                                                </select>
                                                <label for="floatingSelect">Seleccione tipo de orden</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-floating mb-2">
                                                <input type="text" class="form-control h-50" id="orderdescription" name="orderdescription">
                                                <label for="floatingInput">Ingrese la descripcion del objeto de la orden</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-2">
                                                <input type="number" class="form-control" id="orderterm" name="orderterm">
                                                <label for="floatingInput">Ingrese el plazo de  la order</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>                                            
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-floating mb-2">
                                                <select class="form-select" id="order-currency" name="order-currency" aria-label="Floating label select example">
                                                    <option></option>
                                                    <c:forEach var="cc" items="${ordercurrency}">
                                                        <option value="${cc.id}">${cc.nombrelargo}</option>    
                                                    </c:forEach>
                                                </select>
                                                <label for="floatingSelect">Seleccione tipo de moneda</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-floating mb-2">
                                                <input type="number" id="exchangerate" name="exchangerate" class="form-control" step="0.01" disabled>
                                                <label for="floatingInput">Ingrese tipo de cambio</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <hr> 
                                <div id="budget-row" class="row">
                                    <div class="d-flex">
                                        <button id="btn-collapse" 
                                                class="btn btn-info mt-2" 
                                                type="button" 
                                                data-bs-toggle="collapse" 
                                                data-bs-target="#budget-body" 
                                                aria-expanded="true" 
                                                aria-controls="budget-body">▼
                                        </button>
                                        <div class="m-2">
                                            <strong>Detalle de partidas</strong>
                                        </div>
                                        <div class="m-2">
                                            <div class="form-check form-switch">
                                                <input class="form-check-input" type="checkbox" role="switch" name="billable" id="billable">
                                                <label class="form-check-label" for="billable">Con factura</label>
                                            </div>    
                                        </div>
                                        <div class="ms-auto m-2">
                                            <input type="file" id="input-excel" accept=".xlsx, .xls" />
                                        </div>    
                                    </div>
                                    <div id="budget-body" class="row collapse show">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-2">
                                                <input type="text" id="budget-tittle" name="budget-tittle" class="form-control">
                                                <label for="floatingInput">Ingrese titulo general del presupuesto</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                        <div class="col-md-1">
                                            <div class="form-floating mt-2">
                                                <button type="button" onclick="addbudgetitem()" class="btn btn-success" Title="Añadir partida" data-bs-toggle="tooltip">+</button>
                                            </div>
                                        </div>
                                        <div class="col-md-1">
                                            <div class="form-floating mt-2">
                                                <button type="button" onclick="dropbudgetitem()" class="btn btn-danger" Title="Eliminar partida" data-bs-toggle="tooltip">-</button>
                                            </div>
                                        </div>
                                        <input type="hidden" id="bud-num-item" class="bud-num-item" value="">
                                        <div id="order-details">
                                        </div>
                                    </div>    
                                </div>
                                <hr> 
                                <div class="row">
                                    <div class="col-md-9">
                                        <div class="d-flex">
                                            <button id="btn-collapse" 
                                                    class="btn btn-info btn-detail mt-2" 
                                                    type="button" 
                                                    data-bs-toggle="collapse" 
                                                    data-bs-target="#container-payment" 
                                                    aria-expanded="true" 
                                                    aria-controls="container-payment">▼
                                            </button>
                                            <div class="m-2">
                                                <strong>Forma de pago</strong>
                                            </div>
                                            <div class="m-2">
                                                <input class="form-check-input" type="radio" name="paymenttype" onchange="paymentclean()" id="inlineRadio3" value="VALORIZACIONES" required>
                                                <label class="form-check-label" for="inlineRadio3">Valorizacion</label>
                                            </div>
                                            <div class="m-2">
                                                <input class="form-check-input" type="radio" name="paymenttype" onchange="paymentclean()" id="inlineRadio4" value="HITOS" required>
                                                <label class="form-check-label" for="inlineRadio4">Hitos</label>
                                            </div>
                                            <button type="button" onclick="addpaymentdetail()" class="btn btn-success ms-auto">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/newdetail.svg" width="16" height="16" Title="Añadir detalle de pago" data-bs-toggle="tooltip"> 
                                            </button>
                                            <button type="button" onclick="droppaymentdetail()" class="btn btn-danger">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/newdetail.svg" width="16" height="16" Title="Eliminar detalle de pago" data-bs-toggle="tooltip"> 
                                            </button>
                                            <input type="hidden" id="pay-num-item" value="">
                                        </div>
                                        <div id="container-payment" class="collapse show">
                                        </div>
                                        <hr>
                                        <div class="d-flex">
                                            <button id="btn-collapse" 
                                                    class="btn btn-info btn-detail" 
                                                    type="button" 
                                                    data-bs-toggle="collapse" 
                                                    data-bs-target="#general-considerations" 
                                                    aria-expanded="true" 
                                                    aria-controls="general-considerations">▼
                                            </button>
                                            <div class="m-2">
                                                <strong>Consideraciones generales</strong>
                                            </div>
                                            <div class="ms-auto">
                                                <button type="button" onclick="addgconsideration()" class="btn btn-success">
                                                    <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/newdetail.svg" width="16" height="16" Title="Añadir consideracion general" data-bs-toggle="tooltip"> 
                                                </button>
                                                <button type="button" onclick="dropgconsideration()" class="btn btn-danger">
                                                    <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/newdetail.svg" width="16" height="16" Title="Eliminar consideracion general" data-bs-toggle="tooltip"> 
                                                </button>
                                            </div>
                                            <input type="hidden" class="gen-con-num" value="">
                                        </div>
                                        <div id="general-considerations" class="row collapse show">
                                        </div>
                                        <hr>     
                                        <div class="d-flex">
                                            <button id="btn-collapse" 
                                                    class="btn btn-info btn-detail" 
                                                    type="button" 
                                                    data-bs-toggle="collapse" 
                                                    data-bs-target="#specific-considerations" 
                                                    aria-expanded="true" 
                                                    aria-controls="specific-considerations">▼
                                            </button>                                      
                                            <div class="m-2">
                                                <strong>Consideraciones especificas</strong>
                                            </div>
                                            <div class="ms-auto">
                                                <button type="button" onclick="addsconsideration()" class="btn btn-success">
                                                    <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/newdetail.svg" width="16" height="16" Title="Añadir consideracion especifica" data-bs-toggle="tooltip"> 
                                                </button>
                                                <button type="button" onclick="dropsconsideration()" class="btn btn-danger">
                                                    <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/newdetail.svg" width="16" height="16" Title="Eliminar consideracion especifica" data-bs-toggle="tooltip"> 
                                                </button>
                                            </div>  
                                            <input type="hidden" class="spc-con-num" value="">
                                        </div>
                                        <div id="specific-considerations" class="row collapse show">
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-floating mb-2">
                                            <strong>Detalle valor order</strong>
                                        </div>
                                        <input type="hidden" id="subtotal1">
                                        <input type="hidden" id="subtotal2">                                        
                                        <div class="form-floating mb-2">
                                            <input type="text" class="form-control" id="exonerated" name="exonerated" disabled>
                                            <label for="floatingInput">Exonerado</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                        <div class="form-floating mb-2">
                                            <input type="text" class="form-control" id="taxable" name="taxable" disabled>
                                            <label for="floatingInput">Imponible</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                        <div class="form-floating mb-2">
                                            <input type="text" class="form-control" id="tax" name="tax" disabled>
                                            <label for="floatingInput">Impuesto</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                        <div class="form-floating mb-2">
                                            <input type="text" class="form-control" id="total" name="total" disabled>
                                            <label for="floatingInput">Total</label>
                                            <div class="invalid-feedback">Este campo es obligatorio.</div>
                                        </div>
                                    </div>
                                    <div class="d-flex">
                                        <div style="width: 100%;" class="form-floating mb-2">
                                            <input type="text" id="numletters" name="numletters" class="form-control" disabled>
                                            <label for="floatingInput">Son:</label>            
                                        </div>
                                    </div>
                                </div>  
                            </form>  
                        </div>
                        <div class="modal-footer">
                            <button id="form-btn" type="submit" form="orderform" class="btn btn-primary" >Guardar</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                        </div>                    
                    </div>
                </div>
            </div>
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
        <%@include file="WEB-INF/jspf/scripts_order.jspf" %>
        <%@include file="WEB-INF/jspf/scripts_provider.jspf" %>
    </body>        
</html>