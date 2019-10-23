<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="./assets/css/main.css" />
    <script src="./assets/js/main.js"></script>
    
</head>
<body style=" background:#edd1ff;">
    <div class="topnav">
        <a class="active" href="welcome.jsp">Home</a>
        <a href="about_us.jsp">About Us</a>
        <a style="float:right" href="profile.jsp">Profile</a>
        <a style="float:right" href="index.html">Logout</a>
</div>
    <div class="profilecard">
            <div style="font-weight: bold; font-size: 20px;">Profile</div>
            <hr>
        <table class="profiletable">
        <tr><td class="fields">Name:</td><td>${user.userName} </td></tr> 
        <tr><td class="fields">Email:</td><td>${user.userEmail}</td></tr> 
        <tr><td class="fields">Mobile No:</td><td>${user.userMobile}</td></tr> 
        <tr><td class="fields">Degree:</td><td>${user.userDegree}</td></tr> 
        <tr><td class="fields">State:</td><td>${user.userState}</td></tr> 
        <tr><td class="fields">City:</td><td>${user.userCity}</td></tr> 
        </table>

    </div>
</body>
</html>