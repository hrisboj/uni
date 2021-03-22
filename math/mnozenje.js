/* Prvo Prasanje*/


let firstNumberFirst = parseInt(Math.random()*10);
let secondNumberFirst = parseInt(Math.random()*10);


//get the total
let totalFirst = firstNumberFirst * secondNumberFirst;

//display numbers on the canvas
let primaryFirst = document.getElementById('primary-number');
    primaryFirst.innerHTML = firstNumberFirst;

let secondaryFirst = document.getElementById('secondary-number');
    secondaryFirst.innerHTML = secondNumberFirst;

/* Vtoro Prasanje*/

let firstNumberSecond = parseInt(Math.random()*10);
let secondNumberSecond = parseInt(Math.random()*10);


//get the total
let totalSecond = firstNumberSecond * secondNumberSecond;

//display numbers on the canvas
let primarySecond = document.getElementById('primary-number2');
    primarySecond.innerHTML = firstNumberSecond;

let secondarySecond = document.getElementById('secondary-number2');
    secondarySecond.innerHTML = secondNumberSecond;

/* Treto Prasanje*/

let firstNumberThird = parseInt(Math.random()*10);
let secondNumberThird = parseInt(Math.random()*10);


//get the total
let totalThird = firstNumberThird * secondNumberThird;

//display numbers on the canvas
let primaryThird = document.getElementById('primary-number3');
    primaryThird.innerHTML = firstNumberThird;

let secondaryThird = document.getElementById('secondary-number3');
    secondaryThird.innerHTML = secondNumberThird;

function stopFunction(){
	clearInterval(downloadTimer);
}



var timeleft = 10;
var downloadTimer = setInterval(function(){


	
  if(timeleft <= 0){
    clearInterval(downloadTimer);
    document.getElementById("countdown").innerHTML = "Времето истече";
    alert("Времето истече, обидете се повторно и бидете побрзи! :)");
    location.replace("index.html");
  } else{
    document.getElementById("countdown").innerHTML =" имате уште " + timeleft + " секунди";
  }
  timeleft -= 1;
  }, 1000);


let button = document.getElementById("btn").addEventListener('click', function(){
	
	let guessFirst = document.getElementById("guessFirst").value;
	let guessSecond = document.getElementById("guessSecond").value;
	let guessThird = document.getElementById("guessThird").value;

	var tocni=0;
	var netocni=0;

	if(guessFirst==totalFirst){
		tocni++;
		
	}else{
		netocni++;
	}

	if(guessSecond==totalSecond){
		tocni++;
		
	}else{
		netocni++;
	}

	if(guessThird==totalThird){
		tocni++;
		
	}else{
		netocni++;
	}

let tocniOdgovori = document.getElementById('tocni');
    tocniOdgovori.innerHTML = "Точни одговори: " + tocni;

let gresniOdgovori = document.getElementById('netocni');
    gresniOdgovori.innerHTML = "Неточни одговори: " + netocni;

let vreme = document.getElementById("countdown").innerHTML = timeleft + " секунди ви останаа од времето за решавање";

let uspesnost = document.getElementById('uspesnost');
    uspesnost.innerHTML = "Успешност : " + tocni/3*100 + "%";


    let poraka = document.getElementById('poraka');
if(tocni/3*100>50){
	poraka.innerHTML = "Честитки, вие го поминавте овој тест! :)";
}else{
	poraka.innerHTML = "За жал не го поминавте овој тест, не е ништо страшно, обидете се повторно додека не успеете! :)";
}

})
