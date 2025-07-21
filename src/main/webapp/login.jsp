<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bienvenido</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@include file="WEB-INF/jspf/login.jspf" %>
    </head>
    <body>
        <section class="target login-page">
            <div class="form">
                <form method="post" id="login">
                    <img 
                        class="logo" 
                        src="RESOURCES/img/img-logo-180.png" 
                        alt="mydaylydb"
                        height="117"
                        width="275"/>
                    <div class="form-group">
                        <input type="text" class="form-control" aria-describedby="Usuario para acceso al sistema." placeholder="Usuario" id="user" name="user"/>
                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                    </div>
                    <br>
                    <div class="form-group">
                        <input type="password" class="form-control" aria-describedby="Usuario para acceso al sistema." placeholder="Contraseña" id="password" name="password"/>
                        <div class="invalid-feedback">Este campo es obligatorio.</div>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Ingresar</button>
                </form>
            </div>
        </section>
        <%@include file="WEB-INF/jspf/scripts_login.jspf" %>
    </body>
</html>
