<%-- 
    Document   : ShowHistory
    Created on : 26.06.2014, 12:48:46
    Author     : Calango
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/MatrixMultiply/resources/CSS/ShowHisroty-style.css">
        <title>History</title>
    </head>
    <body>
        <div id="history-label">
        <h3 >History:</h3>
        </div>
        <div id="show-box">
        <c:if test="${not empty datesList}">
            <form method="post" action="history/ShowDate">
                <select name="date" size="2" multiple>
                    <option selected>
                            <c:out value="Select"/>
                        </option>
                    <c:forEach var="date" items="${datesList}">
                        <option>
                            <c:out value="${date}"/>
                        </option>
                    </c:forEach>  
                </select>
                <INPUT type="submit" value="Show">
            </form>
        </c:if>         
            <a href="http://localhost:8080/MatrixMultiply/welcome"><img src="http://localhost:8080/MatrixMultiply/resources/images/back_button1.jpg" border="0" alt="Назад"></a>
        </div>
    </body>
</html>
