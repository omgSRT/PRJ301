<%-- 
    Document   : search
    Created on : Feb 18, 2023, 1:31:42 PM
    Author     : omg
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ThangND.DAO.RegistrationDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie[] cookies = request.getCookies();
            String username = null;
            if(cookies != null){
                username = cookies[1].getName();
            }
        %>
        <h1>Welcome <%= username %></h1>
        <h4>Search Page</h4>
        <br/>
        <form action="MainController" method="post">
            Input Lastname:<input type="text" name="txtSearchValue">
            <input type="submit" value="search" name="action">
        </form>
</body>
</html>
