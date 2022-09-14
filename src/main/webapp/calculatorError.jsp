<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Calculator error page</title>
    </head>
    <body>
        <p>Значение <%=request.getParameter("number")%> не является числом</p>
    </body>
</html>
