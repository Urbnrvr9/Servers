<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Каталог</title>
    </head>
    <body>
    <%
        List<String> catalog = (List<String>) request.getAttribute("catalog");

    %>
        <h2>Каталог</h2>
        <div>1: <%= catalog.get(0)%></div>
        <div>2: <%= catalog.get(1)%></div>
        <div>3: <%= catalog.get(2)%></div>
    </body>
</html>
