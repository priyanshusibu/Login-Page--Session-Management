<%@ page language="java" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="index_style.css">
</head>
<body>
<%
    String message = null;
    if (session.getAttribute("key1") != null) {
        message = session.getAttribute("key1").toString();
    }
%>

<div class="container">
    <% if (message != null) { %>
        <div class="message"><%= message %></div>
    <% } %>
    <div class="login-box">
        <h1>Login</h1>
        <form action="Login" method="post">
            <input type="text" placeholder="Enter Username" name="uname" required>
            <input type="password" placeholder="Enter Password" name="password" required>
            <input type="submit" value="Login">
        </form>
        <a href="forgot.jsp" class="forgot-password">Forgot Password?</a>
        <a href="signup.jsp" class="signup-button">Sign Up</a>
    </div>
</div>
</body>
</html>
