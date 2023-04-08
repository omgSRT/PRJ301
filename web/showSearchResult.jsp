<%-- 
    Document   : showSearchResult
    Created on : Feb 18, 2023, 2:03:31 PM
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
            String searchValue = request.getParameter("txtSearchValue");
            if (searchValue != null) {
                ArrayList<RegistrationDTO> list = (ArrayList<RegistrationDTO>) request.getAttribute("regList");
                if (list != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No.</th>
                    <th>username</th>
                    <th>lastname</th>
                    <th>password</th>
                    <th>isAdmin</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    String urlRewriting;
                    for (RegistrationDTO dto : list) {
                %>
                <tr>
                    <% urlRewriting = "MainController?action=delete&txtusername=" + dto.getUsername() + "&lastSearchResult=" + searchValue;%>
            <form action="MainController" method="post">
                <td><%= count++%></td>
                <td><%= dto.getUsername()%><input type='hidden' name='txtUsername' value="<%= dto.getUsername() %>"></td>
                <td><input type="text" name="txtLastname" value="<%= dto.getLastname()%>"></td>
                <td><input type="text" name="txtPassword" value="<%= dto.getPassword()%>"></td>
                    <% if (dto.isIsAdmin()) {%>
                <td><input type="checkbox" name="ADMIN" value="ON" checked="checked"></td>
                    <% } else { %>
                <td><input type="checkbox" name="ADMIN" value="ON"></td>
                    <% }%>
                <td><a href="<%= urlRewriting%>">Delete</a></td>
                <td><input type='hidden' name='lastSearchValue' value="<%= searchValue%>"><input type="submit" value="update" name="action"></td>
            </form>
        </tr>
        <% } %>
    </tbody>
</table>
<%
} else {%>
<h1>No record is matched</h1>
<%      }
    }
%>
<a href="search.jsp">Go Back</a>
</body>
</html>
