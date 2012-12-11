<%-- 
    Document   : LogOut
    Created on : 30-nov-2012, 16:59:47
    Author     : al036309
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<% 
    HttpSession sesion = request.getSession();
    sesion.invalidate();
%>
    
    <jsp:forward page="index.jsp" />


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body>
</html>
