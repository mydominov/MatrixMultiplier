<%-- 
    Document   : matrix
    Created on : 18.04.2014, 20:52:28
    Author     : Calango
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/MatrixMultiply/resources/CSS/matrix-style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Matrix</title>
    </head>
    <body>
        <div id="show-box">
            <h1>Welcome to the your Matrix-Multiplying centre!</h1>
            <c:if test="${not empty requestScope.error}">
                    <div class="error">${requestScope.error}</div>
            </c:if>      
            <FORM action="http://localhost:8080/MatrixMultiply/Multiply" method="post">
                <p>Matrix Name:<br/>
                    <input type="text" name="matrix_name">
                </p>
                <p>Matrix 1:<br/>
                    <textarea rows="9" cols="45" name="matrix1"></textarea>
                </p>
                <p>Matrix 2:
                    <br/>
                    <textarea rows="9" cols="45" name="matrix2"></textarea>
                </p>
                <INPUT type="submit" value="Execute">
            </FORM>
            <a href="http://localhost:8080/MatrixMultiply/welcome"><img src="http://localhost:8080/MatrixMultiply/resources/images/back_button1.jpg" border="0" alt="Назад"></a>
        </div>
    </body>
</html>