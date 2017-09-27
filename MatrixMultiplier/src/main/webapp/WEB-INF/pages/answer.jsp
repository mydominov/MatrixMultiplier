<%-- 
    Document   : Answer
    Created on : 03.05.2014, 23:54:33
    Author     : Calango
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/MatrixMultiply/resources/CSS/answer-style.css">
        <title>Answer</title>
    </head>
    <body>
        <c:if test="${empty matrixName}">
                <div id="error">
                <p><b>ERROR!</b></p>
                <p>Something goes wrong...</p>
            </div>
        </c:if>
        <c:if test="${empty matrixResult}">
            <div id="error">
                <p><b>ERROR!</b></p>
                <p>Something goes wrong...</p>
            </div>
        </c:if>
        <c:if test="${not empty matrixName}">
        <c:if test="${not empty matrixResult}">    
            <!-- Writing MATRIX NAME -->
            <h2><b>Matrix <c:out value="${matrixName}"/></b></h2>
            <!-- Writing MATRIX RESULT TABLE-->
            <table>
                <caption><b> Result </b></caption>
                <c:forEach var="row" items="${matrixResult}">
                    <tr>
                    <c:forEach var="column" items="${row}">
                        <td>
                            ${column}
                        </td>
                    </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        </c:if>
        <a href="http://localhost:8080/MatrixMultiply/welcome"><img src="http://localhost:8080/MatrixMultiply/resources/images/back_button1.jpg" border="0" alt="Назад"></a>    
    </body>
</html>