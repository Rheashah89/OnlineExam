<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Exam</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="./assets/css/main.css" />
    <script src='./assets/js/main.js'></script>
  
</head>
<body style=" background:#edd1ff;">
<div class="exam">
    <div class="examname"><h1>${currentQuestion.subject.subjectName}</h1> </div>
    <div >Time left = <p id="timer"> </p></div>

   <div class="card">
   <form action="exam.lti" method="post">
      <div><h3>Question No: ${pointer+1}</h3></div>
      <hr>
      <div><p style="text-align:left;">${currentQuestion.question}</p> </div>
      <h4>Options</h4>
      <div>
            <ol class="answers">
            	   <c:forEach items="${currentQuestion.options}" var="currentOption"> 
      			   <li style="text-align:left;">
                    <span class="radio">
                    <c:choose>
                    <c:when test="${selectedId == currentOption.optionId }">
                    <input type="radio" name="option" value="${currentOption.optionId}" checked>
                    </c:when>
                    <c:otherwise>
                     <input type="radio" name="option" value="${currentOption.optionId}">
                    </c:otherwise>
                    </c:choose>
                    <span>${currentOption.option}</span>
                    </span>
                  </li>
   				 </c:forEach>
            </ol>
         </div> 
    <div>
         <div style="float: left;">
        
        <button type="submit" id="previousquestion" name="cursor" value="-1">Previous Question</button>
        </div>
        <c:if test = "${pointer < 9}" > 
        <div style="float: right;">
        <button type="submit" id="nextquestion" name="cursor" value="1">Next Question</button>
        </div>
        </c:if>
        
        </div>
   </div> 
   </div>
  		 <div>
        <button id="submitexam" name="submitExam" value="1">Submit Exam</button>
        </div>

</body>
</html>