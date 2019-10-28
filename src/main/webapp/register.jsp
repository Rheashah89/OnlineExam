<html>
<head>
<title>Register Page</title>
<link rel="stylesheet" type="text/css" href="./assets/css/main.css">
</head>

<style>
/* width */
::-webkit-scrollbar {
  width: 10px;
}

/* Track */
::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px grey; 
  border-radius: 10px;
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: #ddd; 
  border-radius: 10px;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #ddd; 
}
</style>
<body>
        <div class="loginbox">
                <img src="./assets/images/LoginIcon.png" class="avatar">
                <h1>Please Register</h1>
                <form name="RegiForm" method="POST" action="login.jsp">
                <div class="scroll">
                        <p>Full Name</p>
                        <input type="text" name="FullName" placeholder="Your Name">
                        <p>Email</p>
                        <input type="text" name="Email" placeholder="Your Email">
                        <p>Mobile</p>
                        <input type="text" name="Mobile" placeholder="Your Mobile No.">
                        <p>State</p>
                        <input type="text" name="State" placeholder="Your State">
                        <p>Date of birth</p>
                        <input type="date" name="DateOfBirth" placeholder="Your Date of Birth">
                        <p>City</p>
                        <input type="text" name="City" placeholder="Your City">
                        <p>Degree</p>
                        <input type="text" name="Degree" placeholder="Your Degree">
                        <p>Security Question</p>
                        <input type="text" name="securityQuestion" placeholder="Question">
                        <p>Security Answer</p>
                        <input type="text" name="securityAnswer" placeholder="Answer">
                </div>
                <br><br>
                <div style="width: 50%; margin: 0 auto;">
                <input type="submit" name="" value="Register" onclick="validation()">
                <div><a href ="login.jsp">Already have an account ?</a></div>
        
        
                </div>
                </form>
        </div>


<script type="text/javascript">

function validation(){
          
        var fullname = document.forms["RegiForm"]["FullName"];    
        var email = document.forms["RegiForm"]["Email"];
        var mobile = document.forms["RegiForm"]["Mobile"];
        var state = document.forms["RegiForm"]["State"];
        var dateofbirth = document.forms["RegiForm"]["DateOfBirth"];
        var city = document.forms["RegiForm"]["City"];
        var degree = document.forms["RegiForm"]["Degree"];



        if (fullname.value == "")                                   
    { 
        alert("Blank name not allowed"); 
        fullname.focus(); 
        return false; 
    }   
    
    if (fullname.value == "[0-9]")   
    { 
        alert("Numeric values not allowed"); 
        fullname.focus(); 
        return false; 
    }   

    if (email.value == "")                                   
    { 
        alert("Blank Email not allowed"); 
        email.focus(); 
        return false; 
    }   

     if (mobile.value == "") { 
         alert("Blank Mobile not allowed"); 
         return false; 
          }   

     if ((mobile.value).length<10 || (mobile.value).length>10) {
         alert("Enter valid phone no.");
         return false;
          } 

        var letter = /^[A-Za-z]+$/;
        if(mobile.value.match(letter)){
          alert("mobile number should contain numeric values only");
          return false;
      }  
   
    if (state.value == "")                                   
    { 
        alert("Blank State not allowed"); 
        return false; 
    }  

    if (dateofbirth.value == "")                                   
    { 
        alert("Blank Date of Birth not allowed"); 
        return false; 
    }   

    if (city.value == "")                                   
    { 
        alert("Blank City not allowed"); 
        return false; 
    }   


    if (degree.value == "")                                   
    { 
        alert("Blank Degree not allowed"); 
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





