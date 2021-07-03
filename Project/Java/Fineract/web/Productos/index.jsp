<%-- 
    Document   : index
    Created on : 1/07/2021, 05:29:48 PM
    Author     : steve
--%>



<%@page import="org.json.simple.JSONObject"%>
<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fineract</title>
    </head>
    <body>

        <h1>Productos</h1>
        <%
            out.print(request.getAttribute("lista"));
        %>    
       


    </body>
</html>
