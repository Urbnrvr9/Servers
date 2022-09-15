<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Get All Products</title>
    </head>
    <body>
        <h1>Products</h1>
        <br>
        <c:forEach var="product" items="${products}">
            Id : <c:out value="${product.id}"/> <p>
            Name : <c:out value="${product.name}"/> <p>
            Description:  <c:out value="${product.desc}"/><br><br>
        </c:forEach>
    </body>
</html>
