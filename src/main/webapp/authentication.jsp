<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication</title>
</head>
    <body>
        <form method="post" action="authenticationServlet">
            <p><b>Логин</b>
                <br>
                <label>
                    <input name="login" type="text" size="40">
                </label>
            </p>
            <p><b>Пароль</b>
                <br>
                <label>
                    <input name="password" type="password" size="40">
                </label>
            </p>
            <p>
               <input type = "submit" value="Submit">
            </p>
        </form>
    </body>
</html>
