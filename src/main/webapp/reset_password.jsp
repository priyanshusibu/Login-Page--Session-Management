<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Change Password</title>
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
    .form-group {
        margin-bottom: 15px;
    }
    .form-group label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
    }
    .form-group input {
        width: calc(100% - 10px);
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    .form-group input:focus {
        outline: none;
        border-color: #7ecaee;
    }
    .btn {
        background-color: #4CAF50;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
    }
    .btn:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

<div class="container">
    <h2>Change Password</h2>
    <form action="ChangePassword" method="POST">
        <div class="form-group">
            <label for="old_password">Old Password:</label>
            <input type="password" id="old_password" name="old_password" required>
        </div>
        <div class="form-group">
            <label for="new_password">New Password:</label>
            <input type="password" id="new_password" name="new_password" required>
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm New Password:</label>
            <input type="password" id="confirm_password" name="confirm_password" required>
        </div>
        <button type="submit" class="btn">Change Password</button>
    </form>
</div>

</body>
</html>