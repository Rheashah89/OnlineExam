<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Start Exam</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="./assets/css/main.css" />
    <script src="./assets/js/main.js"></script>
</head>
<body>
    <div class="instruction">
        INSTRUCTIONS
        <hr>
        <ul>
        <li><p>Before starting the exam:</p></li>

        <li><p>Please verify that the student's last name appears correctly within the User ID box.</p></li>
                
        <li ><p>During the exam:</p></li>
                
        <li><p>The student may not use his or her textbook, course notes, or receive help from a proctor or any other outside source.</p></li>
        <li><p>Students must complete the 10-question multiple-choice exam within the time frame allotted for the exam for proceeding to the next level .</p></li>
        <li><p>Students must not stop the session and then return to it. </p></li>
        <li><p>This is especially important in the online environment where the system will "time-out" and not allow the student or you to reenter the exam site.</p></li>
        <li><p>What to do if your online exam is interrupted</p></li>
        <li><p>If your online exam is interrupted, click the "Back" button on your web browser to see if you can return to the exam.  </p></li>
        <li><p>If not, follow the instructions below to resume taking the exam.</p></li>
      
        </ul>
        <div>
        <div>
        <button><a href="select_subject.jsp" style="color:white; text-decoration: none;">Change Subject</a></button>
        </div>
        <form action="startExam.lti">
        <button type="submit">Start Exam</button></div>
        </form>
    </div>
</body>
</html>