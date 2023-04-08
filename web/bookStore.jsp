<%-- 
    Document   : bookStore
    Created on : Mar 1, 2023, 12:58:32 PM
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
        <h1>Book Store</h1>
        <form action="MainController" method="post">
            Choose book:
            <select name="cboBook">
                <option>Servlet</option>
                <option>Tomcat</option>
                <option>JSP</option>
                <option>MVC</option>
                <option>JavaEE</option>
                <option>EL</option>
                <option>EJB2</option>
                <option>EJB3</option>
                <option>JBoss</option>
            </select>
            <br/>
            <input type="submit" value="addBook" name="action">
            <input type="submit" value="viewCart" name="action">
        </form>
    </body>
</html>
