<%-- 
    Document   : register
    Created on : Mar 1, 2023, 2:14:10 PM
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
        <h1>Registration</h1>
        <form action="MainController" method="post">
            Username: <input type="text" name="txtusername">
            <br/>
            Lastname: <input type="text" name="txtlastname">
            <br/>
            Password: <input type="password" name="txtpassword">
            <br/>
            Confirm password: <input type="password" name="txtconfirm">
            <br/>
            <input type="submit" value="register" name="action">
        </form>
    </body>
</html>
