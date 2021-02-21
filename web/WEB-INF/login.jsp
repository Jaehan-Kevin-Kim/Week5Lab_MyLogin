<%-- 
    Document   : login
    Created on : Feb 17, 2021, 10:38:27 PM
    Author     : 841898
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="/" method="post">
            <label>Username:</label> <input type="text" name="username"> <br />
            <label>Password: </label><input type="password" name="password"> <br />
            <input type="submit" name="submitBtn" value="Log in">
        </form>
        ${message}
    </body>
</html>
