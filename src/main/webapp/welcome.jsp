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
<body >
    <div class="topnav">
        <a class="active" href="welcome.jsp" action = "welcome.jsp">Home</a>
        <a href="about_us.jsp" action = "about_us.jsp">About Us</a>
        <a style="float:right" href="profile.jsp" action = "profile.jsp">Profile</a>
        <a style="float:right" href="index.html" action = "index.html">Logout</a>
    </div>
    <div class="outterdiv">
        <div class="card">
        <div>
        <h1>Hello ${user.userName}! </h1>
         <div style="float: left;"><a href="report.jsp"><button>Report</button></a></div>
        <div > <a href="select_subject.jsp"><button>New Exam</button></a></div>
    </div>
    </div>
</body>
</html>