var counter=0;
var timeleft=300;
var currentTime = 0;
var startTime= 0;

function convertSeconds(s){
    var min = floor(s / 60);
    var sec = s % 60;
    return nf(min,2) +':'+ nf(sec,2);
}

function setup(){
    noCanvas();

    startTime= millis();

    var timer = select('#timer');
    timer.html(convertSeconds(timeleft - counter));
   
   var interval = setInterval(timeIt,1000);

    function timeIt(){
        
       currentTime = floor((millis() - startTime) / 1000);
        timer.html(convertSeconds(timeleft - counter));
        if(currentTime == timeleft){
            clearInterval(interval);
        }

    }

}