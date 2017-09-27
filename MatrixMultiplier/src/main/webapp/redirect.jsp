<%-- 
    Document   : redirect
    Created on : 29.06.2014, 20:42:25
    Author     : Admin
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JSP Redirect Example</title>
</head>
<body>
	<%
		response.sendRedirect("http://localhost:8080/MatrixMultiply/welcome");
	%>
</body>
</html>