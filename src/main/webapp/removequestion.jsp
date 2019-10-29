<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Remove Question</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen"
	href="./assets/css/main.css" />
<script src="main.js"></script>

<style type="text/css">
.removequestion {
	margin-left: 50px;
}

input[type="submit"] {
	width: 150px;
	height: 50px;
	border: none;
	color: white;
	border: solid 2px #56356B;
	border-radius: 5px;
	background: #56356B;
	cursor: pointer;
	border-radius: 10px;
}

input[type="submit"]:hover {
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
	color: white;
}
</style>
</head>
<body>
	<div class="removequestion">
		<form action="removequestion.lti" method="post">

			<div id="technology" style="width: auto;">
				Select Subject: <select style="width: 100px" class="innerselect"
					name="subjectId">

					<c:forEach var="subject" items="${subjects}">
						<option value="${subject.subjectId}">${subject.subjectName}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				Select Level: <select style="width: auto;" name="level">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>

				</select>
			</div>
			<input type="submit" value="Next">
		</form>
	</div>
</body>
</html>