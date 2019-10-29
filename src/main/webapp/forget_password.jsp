<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="./assets/css/main.css"/>
    
    <script type="text/javascript">
    function passwordValidate() {
        var password = document.getElementById("newpassword").value;
            var confirmPassword = document.getElementById("confirmpassword").value;
            if (password != confirmPassword) {
                alert("Passwords do not match.");
                return false;
            }
            return true;
    }
    </script>
</head>
<body style=" background:#edd1ff;">

	<div class="topnav">
                <a class="active" href="index.html">Home</a>
                <a href="about_us.jsp">About Us</a>
                <a style="float:right" href="register.jsp">Register</a>
                <a style="float:right" href="login.jsp">Login</a>
        </div>
    <div class="form">
    	<p>${message}</p>
        <form action="forgetPassword.lti" method="post">
            New Password : <input type="password" name="newpassword"/><br>
            Confirm Password :<input type="password" name="confirmpassword"/><br>
            <br>
            <button onclick="return passwordValidate();" type="submit">Reset</button>
        </form>
    </div>
</body>
</html>

