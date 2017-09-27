<%-- 
    Document   : index
    Created on : 15.04.2014, 21:32:51
    Author     : Calango
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/MatrixMultiply/resources/CSS/welcome-style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="http://localhost:8080/MatrixMultiply/resources/scripts/AJAX-time.js"></script>
    </head>
    <body>
        <div class="time">
            <p>Time on the server is: </p>
            <div id="time"></div>
        </div>
        <div id="show-box">
            <h1>Welcome to the Matrix Multiply site!</h1>
            <div>Now you can chose:</div>
            <a HREF="http://localhost:8080/MatrixMultiply/welcome/matrix"> If you want to see my Matrix-Multiply power click here </a>
            <br/>
            <a HREF="http://localhost:8080/MatrixMultiply/welcome/history"> Otherwise you can see the history of your previous Matrix-Multiplying</a>
        </div>
    </body>
</html>