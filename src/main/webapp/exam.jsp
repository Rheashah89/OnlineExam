<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Exam</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" media="screen"
	href="./assets/css/main.css" />
<script src='./assets/js/main.js'></script>

<!--  <script type="text/javascript">

    var timer = 60;
    var min = 0;
    var sec = 0;
     function startTimer(){
         min = parseInt(timer/60);
         sec = parseInt(timer%60);

         if(timer < 1){
            //  window.location = "";
             alert("Time up")
             return true;
         }

         document.getElementById("time").innerHTML = "<b>Time Left: </b>" + min.toString() + ":" + sec.toString();
         timer--;
         setTimeout(function(){
             startTimer();
         },1000);

        //  window.onload=function(){ 
        //   window.setTimeout(document.exam.submit(), 60);

        window.onload=function(){ 
        window.setTimeout(function() { document.exam.submit(); }, 5000);
};
     }   
    </script> -->
    
     <script type="text/javascript">
	function startTimer(duration, display) {
		var timer = duration, minutes, seconds;
		setInterval(function() {
			minutes = parseInt(timer / 60, 10);
			seconds = parseInt(timer % 60, 10);

			minutes = minutes < 10 ? "0" + minutes : minutes;
			seconds = seconds < 10 ? "0" + seconds : seconds;

			display.textContent = minutes + ":" + seconds;

			if (--timer < 0) {
				timer = duration;
			}
		}, 1000);
	}

	window.onload = function() {
		var reMinutes = 60 * 2, display = document.querySelector('#time');
		startTimer(reMinutes, display);
	};
</script>

     


</head>
<body style="background: #edd1ff;">
	<div class="exam">
		<div>
			<center>
			<div>Time Left: <span id="time">2:00</span> minutes!</div>
			</center>
		</div>
		
		<div>
		<center>
		<div>Current Level: ${currentQuestion.questionLevel}</div>
		</center>
		</div>


		<div class="examname">
			<h1>${currentQuestion.subject.subjectName}</h1>
		</div>
		<div>
<!-- 			Time left = -->
<!-- 			<p id="timer"></p> -->
		</div>

		<div class="card">
			<form action="exam.lti" method="post">
				<div>
					<h3>Question No: ${pointer+1}</h3>
				</div>
				<hr>
				<div>
					<p style="text-align: left;">${currentQuestion.question}</p>
				</div>
				<h4>Options</h4>
				<div>
					<ol class="answers">
						<c:forEach items="${currentQuestion.options}" var="currentOption">
							<li style="text-align: left;"><span class="radio"> <c:choose>
										<c:when test="${selectedId == currentOption.optionId }">
											<input type="radio" name="option"
												value="${currentOption.optionId}" checked>
										</c:when>
										<c:otherwise>
											<input type="radio" name="option"
												value="${currentOption.optionId}">
										</c:otherwise>
									</c:choose> <span>${currentOption.option}</span>
							</span></li>
						</c:forEach>
					</ol>
				</div>
		</div>
		<div style="width: 100%; display: inline-block; margin-top: 10px;">
			<div style="width: 33%; float: left;">
			<c:if test="${pointer > 0}">
				<button type="submit" id="previousquestion" name="cursor" value="-1"
					style="float: right;">Previous Question</button>
			</c:if>
			</div>
			<div style="width: 33%; float: left;">
				<button id="submitexam" name="submitExam" value="1"
					style="left: 35%; position: relative;">Submit Exam</button>
			</div>
			<c:if test="${pointer < 9}">
				<div style="width: 33%; float: left;">
					<button type="submit" id="nextquestion" name="cursor" value="1">Next
						Question</button>
				</div>
			</c:if>

		</div>
	</div>


</body>
</html>