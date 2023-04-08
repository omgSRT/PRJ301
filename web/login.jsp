<%-- 
    Document   : login
    Created on : Feb 25, 2023, 2:07:04 PM
    Author     : omg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String msg = (String)request.getAttribute("WARNING");
            if(msg == null){
                msg = "";
            }          
        %>
        <h1>Login Page</h1>
        <form action="MainController" method="post">
            Username:
            <input type="text" name="txtname">
            <br/>
            Password:
            <input type="password" name="txtpassword">
            <br/>
            <input type="submit" value="login" name="action">
        </form>
        <h4><%= msg %></h4>
        <br/>
        <a href="register.jsp">register</a>
        <a href="bookStore.jsp">Go to shopping</a>
    </body>
</html>
