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
    <script src="./assets/js/main.js"></script>
</head>
<body>
    <div class="form">
    	<p>${message}</p>
        <form action="forgetPassword.lti" method="post">
            New Password : <input type="text" name="newpassword"/><br>
            Confirm Password :<input type="text" name="confirmpassword"/><br>
            <br>
            <button type="submit">Reset</button>
        </form>
    </div>
</body>
</html>

