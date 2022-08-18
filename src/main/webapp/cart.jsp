<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Корзина</title>
    </head>
    <body>
    <%
        List<String> cart = (List<String>) request.getAttribute("cart");
    %>
        <h2>Каталог</h2>
        <div>1: <%= cart.get(0)%></div>
        <div>2: <%= cart.get(1)%></div>
    </body>
</html>
