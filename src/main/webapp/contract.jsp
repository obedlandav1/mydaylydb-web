<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Contratos</title>
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
                            <img style="height: 45px; width: 45px;" id="logo" src="RESOURCES/img/img-project-512.png" alt="mydaylydb/project"/>
                        </div>
                        &nbsp;
                        <div><h1>Proyectos/Contratos</h1></div>
                    </div> 
                </div> 
                <div class="container-fluid">
                    <hr>
                    <input type="hidden" id="companyid" name="companyid" value="${companyses.id}">
                    <input type="hidden" id="projectid" name="projectid" value="${projectses.id}">             
                    <input type="hidden" id="projectname" name="projectname" value="${projectses.nombrecorto}">
                    <input type="hidden" id="contractid" name="contractid"> 
                    <div class="d-flex justify-content-between mb-2">
                        <div><strong style="font-size: 20px;" class="data">Registro:</strong></div>
                        <div><button style="width: 200px;" onclick="newcontract()" type="button" class="btn btn-primary">Crear contrato</button></div>
                    </div>
                    <table style="max-height: 300px; overflow-y: auto;" class="table table-sm fs-6 table-responsive caption-top table-striped" id="tbl-project">
                        <thead class="table-active text-center align-middle">
                            <tr>
                                <th scope="col">N°</th>
                                <th scope="col">Cliente</th>
                                <th scope="col">Tipo contrato</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">Plazo contrato</th>
                                <th scope="col">Plazo restante</th>
                                <th scope="col">Adjudicado S/</th>
                                <th scope="col">Pagado S/</th>
                                <th scope="col">Por cobrar S/</th>  
                                <th scope="col">Avance ecónomico %</th>  
                                <th scope="col">Avance físico %</th>  
                                <th style="width: 240px;" scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody class="align-middle">
                            <c:if test="${showcontracts}">
                                <% int j = 1;%>
                                <c:forEach var="c" items="${contracts}">
                                    <tr>
                                        <th scope="row"><%=j++%></th>
                                        <td>${c.clientes}</td>
                                        <td>${c.tipocontrato}</td>
                                        <td>${c.descripcioncontrato}</td>
                                        <td>${c.plazocontrato}</td>
                                        <td>${c.valortotal}</td>
                                        <td></td>
                                        <td></td>                                   
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td>
                                            <!--<button type="button" data-details='${c.detallepago}' onclick="showdetails(this.dataset.details)" class="btn btn-primary">
                                                Ver
                                            </button>-->
                                            <button style="width: 50px;" onclick="showpdf('${c.id}')" type="button" class="btn btn-danger">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/pdf.svg" width="16" height="16" Title="Editar" data-bs-toggle="tooltip"> 
                                            </button>
                                            <button style="width: 50px;" onclick="uploadpdf('${c.id}')" type="button" class="btn btn-success">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/upload.svg" width="16" height="16" Title="Editar" data-bs-toggle="tooltip"> 
                                            </button>
                                            <button style="width: 50px;" onclick="loadcontract('${c.id}')" type="button" class="btn btn-warning">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/pencil.svg" width="16" height="16" Title="Editar" data-bs-toggle="tooltip"> 
                                            </button>
                                            <button style="width: 50px;" onclick="deletecontract('${c.id}')" type="button" class="btn btn-danger">
                                                <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/trash.svg" width="16" height="16" Title="Eliminar" data-bs-toggle="tooltip">
                                            </button>
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
                <!--Button Trigger New Contract-->
                <button id="modal" class="btn btn-primary invisible" data-bs-toggle="modal" data-bs-target="#staticBackdrop"></button>
            </div>
        </section>
        <section class="target">
            <div class="col-lg-10 offset-lg-1">
                <!--New Contract Modal-->
                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel"></h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form id="createcli">    
                                </form> 
                                <form method="post" id="contractform">
                                    <div class="row">
                                        <div class="form-floating mb-2">
                                            <strong>Cliente</strong>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-2">
                                                <input type="hidden" id="clientid" name="clientid">
                                                <input type="text" class="form-control" id="clientname" name="clientname" autocomplete="off">
                                                <label for="floatingInput">Ingrese el cliente</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                                <ul id="clientsearch" class="list-group position-absolute w-100 z-3"></ul>
                                            </div>
                                        </div>
                                        <div class="col-md-2 mt-3">
                                            <div class="form-check form-switch">
                                                <input class="form-check-input" type="checkbox" role="switch" name="clientswitch" id="clientswitch">
                                                <label class="form-check-label" for="clientswitch">+Nuevo</label>
                                            </div>                                        
                                        </div>                                      
                                    </div>
                                    <hr> 
                                    <div class="row">
                                        <div class="form-floating mb-2">
                                            <strong>Descripcion de contrato</strong>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating mb-2">
                                                <select class="form-select" id="contracttype" name="contracttype" aria-label="Floating label select example">
                                                    <option></option>
                                                    <c:forEach var="ct" items="${contracttypes}">
                                                        <option value="${ct.id}">${ct.nombrelargo}</option>    
                                                    </c:forEach>
                                                </select>
                                                <label for="floatingSelect">Seleccione tipo de contrato</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
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
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-floating mb-2">
                                                <input type="text" class="form-control h-50" id="contractdescription" name="contractdescription">
                                                <label for="floatingInput">Ingrese la descripcion del contrato</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <div class="form-floating mb-2">
                                                <input type="number" class="form-control" id="contractterm" name="contractterm">
                                                <label for="floatingInput">Ingrese el plazo del contrato proyecto</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>                                            
                                        </div>
                                        <div class="col-sm-6 mt-3">
                                            <div class="form-check form-switch">
                                                <input class="form-check-input" type="checkbox" role="switch" name="billable" id="billable">
                                                <label class="form-check-label" for="billable">Con factura</label>
                                            </div>  
                                        </div> 
                                    </div>
                                    <hr>  
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="d-flex">
                                                <div class="m-2">
                                                    <strong>Detalle de pago</strong>
                                                </div>
                                                <div class="m-2">
                                                    <input class="form-check-input" type="radio" name="paymenttype" onchange="paymentclean()" id="inlineRadio1" value="VALORIZACIONES" required>
                                                    <label class="form-check-label" for="inlineRadio1">Valorizaciones</label>
                                                </div>
                                                <div class="m-2">
                                                    <input class="form-check-input" type="radio" name="paymenttype" onchange="paymentclean()" id="inlineRadio2" value="CRONOGRAMA" required>
                                                    <label class="form-check-label" for="inlineRadio2">Cronograma</label>
                                                </div>
                                                <button type="button" onclick="addpaymentdetail()" class="btn btn-success ms-auto">
                                                    <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/newdetail.svg" width="16" height="16" Title="Añadir detalle de pago" data-bs-toggle="tooltip"> 
                                                </button>
                                                <button type="button" onclick="droppaymentdetail()" class="btn btn-danger">
                                                    <img style="filter: brightness(0) invert(1);" src="RESOURCES/svg/newdetail.svg" width="16" height="16" Title="Eliminar detalle de pago" data-bs-toggle="tooltip"> 
                                                </button>
                                                <input type="hidden" id="pay-num-item" value="">
                                            </div>
                                            <div id="container-payment" class="row">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-floating mb-2">
                                                <strong>Detalle valor de contrato</strong>
                                            </div>
                                            <div class="form-floating mb-2">
                                                <input type="text" class="form-control" id="exonerated" name="exonerated">
                                                <label for="floatingInput">Ingrese el valor exonorado</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                            <div class="form-floating mb-2">
                                                <input type="text" class="form-control" id="taxable" name="taxable">
                                                <label for="floatingInput">Ingrese el valor imponible</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                            <div class="form-floating mb-2">
                                                <input type="text" class="form-control" id="tax" name="tax">
                                                <label for="floatingInput">Ingrese el impuesto correspondiente</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                            <div class="form-floating mb-2">
                                                <input type="text" class="form-control" id="total" name="total">
                                                <label for="floatingInput">Valor total del proyecto</label>
                                                <div class="invalid-feedback">Este campo es obligatorio.</div>
                                            </div>
                                        </div>
                                    </div>  
                                </form>  
                            </div>
                            <div class="modal-footer">
                                <button id="form-btn" type="submit" form="contractform" class="btn btn-primary" >Guardar</button>
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            </div>                    
                        </div>
                    </div>
                </div>
            </div>
        </section>                
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
        <%@include file="WEB-INF/jspf/scripts_contract.jspf" %>
        <%@include file="WEB-INF/jspf/scripts_client.jspf" %>
    </body>        
</html>