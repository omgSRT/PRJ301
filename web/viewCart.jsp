<%-- 
    Document   : viewCart
    Created on : Mar 1, 2023, 1:20:02 PM
    Author     : omg
--%>

<%@page import="java.util.Map"%>
<%@page import="ThangND.Cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CART: </h1>
        <%
            int count = 0;
            if(session != null){
                CartObj cart = (CartObj)session.getAttribute("CART");
                if(cart != null){
                    if(cart.getItems() != null){
                        %>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Title</th>
                                    <th>Quantity</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <form action="MainController" method="post">
                                    <%
                                        Map<String, Integer> items = cart.getItems();
                                        for(Map.Entry i : items.entrySet()){
                                    %>
                                    <tr>
                                        <td><%= count++ %></td>
                                        <td><%= i.getKey() %></td>
                                        <td><%= i.getValue() %></td>
                                        <td><input type="checkbox" name="chkItem" value="<%= i.getKey() %>"></td>
                                    </tr>
                                    <% } %>
                                    <tr>
                                        <td>
                                            <a href="bookStore.jsp">Add more items</a>
                                        </td>
                                        <td>
                                            <input type="submit" value="removeItem" name="action">
                                        </td>
                                    </tr>
                                </form>
                            </tbody>
                        </table>
                <%    }
                }
            }
        %>
    </body>
</html>
