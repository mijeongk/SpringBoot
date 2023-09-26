var firstDay = document.getElementById('firstday').value;
console.log(firstDay);
var y=firstDay.substr(0,4);
//console.log(y);
var m=firstDay.substr(6,2);
//console.log(m);
var d=firstDay.substr(10,2);
console.log(d);
var finalDay=new Date(y,m-1,d);
console.log(finalDay);
var startDay = new Date(finalDay);
console.log(startDay);

var today = new Date();
console.log(today);
var calc = 1000 * 60 * 60 * 24;
var gap = Math.ceil((today.getTime() - startDay.getTime()) / calc);

//document.querySelector("#dday").innerHTML = gap;
document.getElementById('dday').innerText = "D+"+gap;

calcDate(100);
calcDate(200);
calcDate(300);
calcDate(365);
calcDate(730);
calcDate(1095);
calcDate(1460);
calcDate(1825);



function calcDate(num){
   var afterdate = startDay.getTime()+(calc*num);
   if(num%365==0){
      year=startDay.getFullYear()+num/365;
      month=startDay.getMonth()+1;
      day=startDay.getDate();
   }else{
      year=new Date(afterdate).getFullYear();
      month=new Date(afterdate).getMonth()+1;
      day=new Date(afterdate).getDate()-1;      
   }
   
   var dday = Math.floor((afterdate-today.getTime())/calc);
   
   if(dday>0){
      document.querySelector("#day" + num).innerHTML = "<br>"+year + "년 " + month + "월 " + day + "일";      
      document.querySelector("#days" + num).innerHTML = "D-"+dday;      
   }else if(dday=0){
       document.querySelector("#day" + num).innerHTML ="<br>"+ year + "년 " + month + "월 " + day + "일";
       document.querySelector("#days" + num).innerHTML = "D-DAY";
   }else{
       document.querySelector("#day" + num).innerHTML = year + "년 " + month + "월 " + day + "일";
   }
}
