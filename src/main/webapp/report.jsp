<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Report</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="./assets/css/main.css" />
    <script src="./assets/js/main.js"></script>
</head>
<body style=" background:#edd1ff;">
    <div class="topnav">
        <a class="active" href="index.html" action = "index.html">Home</a>
        <a href="about_us.jsp" action = "about_us.jsp">About Us</a>
        <a style="float:right" href="profile.jsp" action = "profile.jsp">Profile</a>
        <a style="float:right" href="index.html" action = "index.html">Logout</a>
    </div>
    <div class="profilecard">
        <div style="font-weight: bold; font-size: 20px;">Report</div>
        <hr>
            <table class="profiletable">
                    <tr><td class="fields">Name:</td><td>${report.exam.user.userName}</td></tr> 
                    <tr><td class="fields">Subject:</td><td>${report.exam.subject.subjectName}</td></tr> 
                    <tr><td class="fields">Level:</td><td>${report.exam.currentLevel}</td></tr> 
                    <tr><td class="fields">Score:</td><td>${report.totalMarks}</td></tr> 
                    <c:choose>
                    <c:when test="${report.clearedLevel == report.exam.currentLevel}">
                     <tr><td class="fields">Status:</td><td>Pass</td></tr>
                    </c:when>
                    <c:otherwise>
                     <tr><td class="fields">Status:</td><td>Fail</td></tr>
                    </c:otherwise>
                    </c:choose>
                    </table>
        <a href="welcome.jsp"><button>Exit</button></a>
    </div>
</body>
</html>