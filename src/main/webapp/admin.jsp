<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen"
	href="./assets/css/main.css" />
	
<style type="text/css">

.admin input[type="submit"]{
	   width: 150px;
 height: 50px;
 border:none;
color: white;
 border:solid 2px #56356B;
 border-radius: 5px;
background: #56356B;
cursor: pointer;
 border-radius: 10px;
	
	
}


.admin input[type="submit"]:hover{
	      box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
  color: white;
	
}
</style>	
<script src="./assets/js/main.js"></script>
</head>
<body>

	<div class="topnav">
		<a class="active" href="admin.jsp">Home</a> <a href="about_us.jsp">About
			Us</a> <a style="float: right" href="login.jsp">Logout</a>
	</div>

	<div class="admin">
		<div class="card">
		<h1>Hello ${user.userName}! </h1>
			<div>
				<form action="retriveSubject.lti" method="post">
				<input type="submit" name="buttonvalue" value="addquestion" />
			</form>
			</div>
			<form action="retriveSubject.lti" method="post">
				<input type="submit" name="buttonvalue" value="Viewquestion" />
			</form>
			<div>
			<form action="retriveSubject.lti" method="post">
				<input type="submit" name="buttonvalue" value="viewreports" />
			</form>
		</div>
	</div>


	<div class="sidebar" style="background-image: url(sidebar-1.jpg)">
		<div class="sidebar-background">
			<!-- <h2 class="logo-text">
                    Online Examination System
                </h2> -->

			<!-- <div class="left-menu">
                    <a  href="adm-page.jsp?pgprt=0"><h2>Profile</h2></a>
                    <a href="adm-page.jsp?pgprt=2"><h2>Courses</h2></a>
                     <a class="active" href="adm-page.jsp?pgprt=3"><h2>Questions</h2></a>
                    <a href="adm-page.jsp?pgprt=1"><h2>Accounts</h2></a>
                </div> -->
		</div>
	</div>

</body>
</html>