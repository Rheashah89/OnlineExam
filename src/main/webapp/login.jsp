<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<html>
<head>
<title>Login Page</title>
</head>
<link rel="stylesheet" type="text/css" href="./assets/css/main.css">
<body>
    <div class="loginbox">
        <img src="./assets/images/LoginIcon.png" class="avatar">
        <h1>Please Login</h1>
        <form name="RegForm" method="POST" action="welcome.jsp" onsubmit="return validation()">
            <p>Email: <input type="text"  name="Email" id="myEmail" placeholder="Your Email"> </p><br> 
            <p>Password: <input type="text"  name="Password" placeholder="Your Password"> </p><br> 
            <input type="submit" name="btn" value="Login">
        
            <div><a href ="forget_password.jsp">Forgot Password ?</a> </div>  
            <div><a href ="register.jsp">Register</a> </div>  


            <div id = "mydiv"></div>

        </form>
    </div>

    <script type="text/javascript">

function validation() {
        var email = document.forms["RegForm"]["Email"];    
        var password = document.forms["RegForm"]["Password"]; 

         if (email.value == "") { 
        alert("Blank email not allowed");
        return false; 
        }   
    
    if (password.value == "") { 
        alert("Blank Password not allowed");  
        return false; 
        } 

    var email = document.forms["RegForm"]["Email"].value;   
    var reg =  /^([0-9a-zA-Z]([-_\\.]*[0-9a-zA-Z]+)*)@([0-9a-zA-Z]([-_\\.]*[0-9a-zA-Z]+)*)[\\.]([a-zA-Z]{2,9})$/;
    
    if (!reg.test(email)){
    alert("Enter Valid Email");
     return false;
    }
} 
    </script>
</body>
</html>