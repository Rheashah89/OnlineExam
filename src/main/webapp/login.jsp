<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./assests/style1.css">
</head>
<body>
 <div class="loginbox">
        <img src="LoginIcon.png" class="avatar">
        <h1>Please Login</h1>
        <form name="RegForm" method="POST"  action="login.lti">
            <p>E-mail: <input type="text"  name="email">  </p><br> 
            <p>Password: <input type="text"  name="password"> </p><br> 
            <input type="submit" value="Login" onclick="validate()">
        
            <div><a href ="register.html">Forget Password ?</a> </div>  
            <div><a href ="register.html">Register</a> </div>  

        </form>
    </div>
     
    <script type="text/javascript">
       
        function validate(){
          
         var email = document.forms["RegForm"]["Email"];    
         var password = document.forms["RegForm"]["Password"];  
         if (email.value == "")                                   
     { 
         alert("Blank Username not allowed"); 
         email.focus(); 
         return false; 
     }   
     
    if (password.value == "")                        
     { 
         alert("Blank Password not allowed"); 
         password.focus(); 
         return false; 
     } 
    return true;
    }
    </script>
</body>
</html>