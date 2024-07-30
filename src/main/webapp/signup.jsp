<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Registration Form</title>
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
        width: 500px;
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
    .form-group input, 
    .form-group select {
        width: calc(100% - 10px);
        padding: 8px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }
    .form-group input:focus, 
    .form-group select:focus {
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
    .row {
        display: flex;
        justify-content: space-between;
    }
</style>
<script>
    function validateForm() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirm_password").value;
        if (password !== confirmPassword) {
            alert("Passwords do not match. Please try again.");
            return false;
        }
        return true;
    }
</script>
</head>
<body>

<div class="container">
    <h2>User Registration</h2>
    <form action="Register" method="POST" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="full_name">Full Name:</label>
            <input type="text" id="full_name" name="full_name" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="text" id="age" name="age" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" required>
            </div>
        </div>
        <div class="form-group">
            <label for="country">Country:</label>
            <select id="country" name="country">
                <option value="India">India</option>
                <option value="Nepal">Nepal</option>
                <option value="China">China</option>
                <option value="Bangladesh">Bangladesh</option>
                <option value="Pakistan">Pakistan</option>
            </select>
        </div>
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password:</label>
            <input type="password" id="confirm_password" name="confirm_password" required>
        </div>
        <button type="submit" class="btn">Register</button>
    </form>
</div>

</body>
</html>
