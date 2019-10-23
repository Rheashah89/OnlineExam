<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
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
    <div class="examname"><h1>Idr eaxm ka name aayega</h1> </div>
    <div >Time left = <p id="timer"> </p></div>
   <div id="questionbar"> 
       <button>1</button>
       <button>2</button>
       <button>3</button>
       <button>4</button>
       <button>5</button>
       <button>6</button>
       <button>7</button>
       <button>8</button>
       <button>9</button>
       <button>10</button>  
   </div>
   <div class="card">
      <div><h3>Question</h3></div>
      <hr>
      <div><p>Idr question aayega database se</p> </div>
      <h4>Options</h4>
      <div>
            <ol class="answers">
                <li>
                    <span class="radio">
                    <input type="radio" name="option" value="option1" ><span>opt1</span>
                    </span>
                </li>
                <li>
                        <span class="radio">  
                            <input type="radio" name="option" value="opttion2" ><span>opt2</span>
                        </span>
                    </li>
                <li>
                        <span class="radio">
                                <input type="radio" name="option" value="option3" ><span>opt3</span>
                        </span> 
                </li>
                <li>
                        <span class="radio">
                                <input type="radio" name="option" value="option4" ><span>opt4</span>
                        </span>
                    
                </li>
            </ol>
        </div>
        <div ><button id="nextquestion">Next Question</button></div>
   </div>

   <div>
        <button id="submitexam">Submit Exam</button>
        </div>
</div>
</body>
</html>