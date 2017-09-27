<%-- 
    Document   : history
    Created on : 18.04.2014, 21:14:28
    Author     : Calango
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/MatrixMultiply/resources/CSS/ShowMatrix-style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
    </head>
    <body>   
        <c:if test="${empty matrixName}">
            <div id="error">
                ERROR #404<br/>
                No dates has been found!
            </div>    
            <a href="http://localhost:8080/MatrixMultiply/welcome" id="error-go"><img src="http://localhost:8080/MatrixMultiply/resources/images/back_button1.jpg" border="0" alt="Назад"></a>
        </c:if>
        <c:if test="${not empty matrixName}">
            <div id="show-box">
                <!--  Writing MATRIX NAME  -->
                    <h1><c:out value="${matrixName}"/></h1>
                <br/>
                <!--  Writing MATRIX 1 TABLE  -->
                <table>
                    <caption><b> Matrix 1 </b></caption>
                    <c:forEach var="row" items="${matrix1}">
                        <tr>
                            <c:forEach var="column" items="${row}">
                                <td>
                                    ${column}
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
                <br/>
                <!--  Writing MATRIX 2 TABLE  -->
                <div id="mx2">
                    <table>
                        <caption><b> Matrix 2 </b></caption>
                        <c:forEach var="row" items="${matrix2}">
                            <tr>
                                <c:forEach var="column" items="${row}">
                                    <td>
                                        ${column}
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>     
                </div>
                <br/>
                <!--  Writing MATRIX RESULT TABLE  -->
                <table>
                    <caption><b> Matrix Result </b></caption>
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
                <br/>
                <a href="http://localhost:8080/MatrixMultiply/welcome"><img src="http://localhost:8080/MatrixMultiply/resources/images/back_button1.jpg" border="0" alt="Назад"></a>
            </div>
        </c:if>
        
    </body>
</html>