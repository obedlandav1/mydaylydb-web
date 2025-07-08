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
        <style>

        </style>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header_contract.jspf" %>
        <!-- Body content-->
        <section class="col-lg-10 offset-lg-1">
            <div class="container-fluid">
                <div class="d-flex">
                    <div>
                        <img style="height: 50px; width: 50px;" id="logo" src="RESOURCES/img/img-orders-512.png" alt="mydaylydb/project"/>
                    </div>
                    &nbsp;
                    <div><h1><strong>Proyectos/Ordenes</strong></h1></div>
                </div> 
            </div> 
            <div class="container-fluid">
                <hr>
                <input type="hidden" id="companyid" name="companyid" value="${companyses.id}">
                <input type="hidden" id="projectid" name="projectid" value="${projectses.id}">  
                <input type="hidden" id="projectname" name="projectname" value="${projectses.nombrecorto}">
                <input type="hidden" id="orderid" name="orderid"> 
                <div class="d-flex justify-content-between">
                    <div><h1 style="font-size: 35px;" class="data">Registro:</h1></div>
                    <div><button style="width: 200px;" onclick="newcontract()" type="button" class="btn btn-primary">Crear orden</button></div>
                </div> 
                <table style="max-height: 300px; overflow-y: auto;" class="table table-responsive caption-top" id="tbl-contract">
                    <thead class="table-light">
                        <tr>
                            <th scope="col">N°</th>
                            <th scope="col">Cliente</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Descripcion</th>
                            <th scope="col">Plazo</th>
                            <th scope="col">Moneda</th>
                            <th scope="col">Tipo pago</th>
                            <th scope="col">Detalle pago</th>
                            <th scope="col">Consideraciones</th>
                            <!--<th scope="col">T. EXONERADO</th>-->
                            <th scope="col">Total sin IGV</th>
                            <!--<th scope="col">IMPUESTO</th>-->
                            <th scope="col">Total con IGV</th>
                            <th style="width: 150px;" scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${showcontracts}">
                            <% int j = 1;%>
                            <c:forEach var="c" items="${contracts}">
                                <tr>

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
            <!--Button Trigger New Contract-->
            <button id="modal" class="btn btn-primary invisible" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button>
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
                                                <label class="form-check-label" for="clientswitch">+Nuevo</label>
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
                                                <input type="text" id="orderdate" name="orderdate" class="form-control datepicker item" placeholder="Fecha" required>
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
                                                <select class="form-select" id="contractcurrency" name="contractcurrency" aria-label="Floating label select example">
                                                    <option></option>
                                                    <c:forEach var="cc" items="${contractcurrency}">
                                                        <option value="${cc.id}">${cc.nombrelargo}</option>    
                                                    </c:forEach>
                                                </select>
                                                <label for="floatingSelect">Seleccione tipo de moneda</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-floating mb-2">
                                                <input type="number" id="exchangerate" name="exchangerate" class="form-control" step="0.01">
                                                <label for="floatingInput">Ingrese tipo de cambio</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <hr> 
                                <div id="budget-row" class="row">
                                    <input type="hidden" id="budget-items" class="budget-items" value="">
                                    <div class="d-flex">
                                        <button id="btn-collapse" 
                                                class="btn btn-info mt-2" 
                                                type="button" 
                                                data-bs-toggle="collapse" 
                                                data-bs-target="#budgetbody" 
                                                aria-expanded="true" 
                                                aria-controls="budgetbody">▼
                                        </button>
                                        <div class="m-2">
                                            <strong>Detalle de partidas</strong>
                                        </div>
                                        <div class="m-2">
                                            <div class="form-check form-switch">
                                                <input class="form-check-input" type="checkbox" role="switch" name="billable" id="billable">
                                                <label class="form-check-label" for="taxable">Con factura</label>
                                            </div>    
                                        </div>
                                        <div class="ms-auto m-2">
                                            <input type="file" id="input-excel" accept=".xlsx, .xls" />
                                        </div>    
                                    </div>
                                    <div id="budgetbody" class="row collapse show">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-2">
                                                <input type="text" id="budgettittle" name="budgettittle" class="form-control">
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
                                            <strong>Detalle valor de orden</strong>
                                        </div>
                                        <div class="form-floating mb-2">
                                            <input type="text" class="form-control" id="exonerated" name="exonerated" disabled>
                                            <label for="floatingInput">Exonorado</label>
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