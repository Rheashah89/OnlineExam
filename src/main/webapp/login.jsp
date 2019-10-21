<html>
<head>
<title>Login Page</title>
</head>
<link rel="stylesheet" type="text/css" href="main.css">
<body style=" background:#edd1ff;">
    <div class="loginbox">
        <img src="LoginIcon.png" class="avatar">
        <h1>Please Login</h1>
        <form action="welcome.jsp" name="loginForm" method="POST">
            <p>E-mail: <input type="text"  name="email">  </p><br> 
            <p>Password: <input type="password"  name="password"> </p><br> 
            <input type="submit" value="Login" onclick="validate()">
            <div class="container">
            <span class="register"><a href ="register.html">Forget Password ?</a> </span>  
            <span class="foregtpassword"><a href ="register.html">Register</a> </span>  
           
            </div>
        </form>
    </div>
     
    <script type="text/javascript">
       
        function validate(){
          
         var email = document.forms["loginForm"]["Email"];    
         var password = document.forms["loginForm"]["Password"];  
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