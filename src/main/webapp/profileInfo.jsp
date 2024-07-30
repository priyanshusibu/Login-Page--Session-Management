<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logic.bean.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Profile</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 20px;
    }
    .container {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        width: 300px;
        margin: auto;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    .profile-info {
        margin-bottom: 15px;
    }
    .profile-info label {
        font-weight: bold;
    }
    .profile-info span {
        display: block;
        margin-top: 5px;
    }
</style>
</head>
<body>
<%
   User user=(User)session.getAttribute("user_session");

%>
<div class="container">
    <h2>User Profile</h2>
    <div class="profile-info">
        <label for="name">Name:</label>
        <span><%=user.getName() %></span>
    </div>
    <div class="profile-info">
        <label for="email">Email:</label>
        <span><%=user.getEmail() %></span>
    </div>
    
     <div class="profile-info">
        <label for="age">Age:</label>
        <span><%=user.getAge() %></span>
    </div>
    
    
    <div class="profile-info">
        <label for="country">Country:</label>
        <span><%=user.getCountry() %></span>
    </div>
    <div class="profile-info">
        <label for="country">Mobile:</label>
        <span><%=user.getMobile() %></span>
    </div>
   
</div>
    <button style="display: inline-block; padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; text-align: center;">
            <a href="Loguot" style="color: white; text-decoration: none;">LogOut</a>
        </button>
</body>
</html>