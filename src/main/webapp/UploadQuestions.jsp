<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Questions</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen"
	href="./assets/css/main.css" />
<script src="./assets/js/main.js"></script>
</head>
<body>
<div class="topnav">
		<a class="active" href="admin.jsp">Home</a> <a href="about_us.jsp">About
			Us</a> <a style="float: right" href="login.jsp">Logout</a>
	</div>
	<h3>Add Question</h3>

	<form action="" method="POST">
		<div>

			<div class="column">
				<div class="card">
					<h3>Add Question With File</h3>
					<div>
						<a href ="uploadQuestionsWithFile.jsp">ADD</a>  
					</div>
				</div>
			</div>
			
			<div class="column">
				<div class="card">
					<h3>Add Question With Form</h3>
					<div>
						<a href="ques_add.jsp">ADD</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>