<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cuentas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            h1{padding-top: 0px;}
        </style>
        <%@include file="WEB-INF/jspf/main.jspf" %>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <%@include file="WEB-INF/jspf/navbar.jspf" %>        
        <section>
            <div class="container-fluid">
                <h1 style="font-size: 20px;">Empresas:</h1>
                <div class="row">
                    <nav aria-label="...">
                        <ul class="pagination pagination-lg">
                            <c:forEach var="c" items="${companies}">
                                <li style="width: 150px; text-align: center;" class="page-item"><a class="page-link" href="account?company=${c.nombrecorto}">${c.nombrecorto}</a></li>
                                </c:forEach>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="container-fluid">
                <h1 style="font-size: 20px;">Nueva cuenta:</h1>                                        
            </div>
            <div class="container-fluid">
                <form>
                    <div class="row">
                        <div class="col">
                            <div class="form-floating">
                                <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                    <option selected></option>
                                    <c:forEach var="b" items="${banks}">
                                        <option value=${b.id}>${b.nombrecorto}</option>    
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Seleccione un banco</label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-floating mb-3">
                                <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                                <label for="floatingInput">Ingrese el numero de cuenta</label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="form-floating">
                                <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                    <option selected></option>
                                    <c:forEach var="t" items="${accounttype}">
                                        <option value=${t.tipocuenta}>${t.tipocuenta}</option>    
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Seleccione tipo cuenta</label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-floating mb-3">
                                <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                    <option selected></option>
                                    <c:forEach var="co" items="${cointype}">
                                        <option value=${co.monedacuenta}>${co.monedacuenta}</option>    
                                    </c:forEach>
                                </select>
                                <label for="floatingSelect">Seleccione tipo moneda</label>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-primary">Crear cuenta</button>
                </form>
            </div>
            <div class="container-fluid">
                <h1 style="font-size: 20px;" class="data">Registro:</h1>                                        
            </div>
            <div class="container-fluid">
                <table class="table caption-top">
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
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>
                                <button style="width: 100px;" type="button" class="btn btn-warning">Editar</button>
                                <button style="width: 100px;" type="button" class="btn btn-danger">Eliminar</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </section>
        <%@include file="WEB-INF/jspf/footer.jspf" %>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
    </body>        
</html>
