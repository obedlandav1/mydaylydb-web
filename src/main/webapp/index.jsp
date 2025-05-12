<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bienvenido</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@include file="WEB-INF/jspf/index.jspf" %>
    </head>
    <body>
        <c:if test="${success}">
            <script>
                alert("Usuario no registrado");
            </script>
        </c:if> 
        <div class="login-page">
            <div class="form">
                <form method="post" action="login" class="login-form">
                    <img class="logo" src="RESOURCES/img/img-contabilidad-512.png" alt="mydaylydb" width="112" height="112">
                    <input type="text" placeholder="Usuario" name="user"/>
                    <input type="password" placeholder="Contraseña" name="password"/>
                    <button>Ingresar</button>
                    <!--<p class="message">Not registered? <a href="#">Create an account</a></p>-->
                </form>
            </div>
        </div>
        <%@include file="WEB-INF/jspf/scripts.jspf" %>
    </body>
</html>
