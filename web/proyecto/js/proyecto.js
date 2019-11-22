var pila = new Array();
var counter = -1;
function iniciar() {
	nodoTabla = document.getElementById("tabla");
}

function meterP() {
	var elem = document.getElementById("elem").value;
	if (elem == "" && elem != undefined) {
		alert("Introduce un elemento");
	}
	else {
		addToGame(elem);
		pila.unshift(parseInt(document.querySelector("#elem").value));
	}
}

function sacarP() {
	pila.shift();
	itemsInGame.pop();
	--counter;

}

function addToGame(elem){
	if (counter > -1) {
		itemsInGame.push(new component(50, 50, colors[1], 20, 75, elem, itemsInGame[counter]));
	}
	else{
		itemsInGame.push(new component(50, 50, colors[counter % colors.length], 20, 75, elem));
	}
	++counter;
}

function meterC() {
	var elem = document.getElementById("elem").value;

	if (elem == "") {
		alert("Introduce un elemento");
	}
	else {
		pila.push(parseInt(document.querySelector("#elem").value));
		addToGame(elem);
	}
}


function sacarC() {
	pila.shift();
	itemsInGame.shift();
	--counter;
}


function meterL() {
	var elem = document.getElementById("elem").value;

	if (elem == "") {
		alert("Introduce un elemento");
	}
	else {
		pila.push(parseInt(document.querySelector("#elem").value));
		printL();
	}
}

function meterpos() {
	var elem = document.getElementById("elem").value;
	var poppos = document.getElementById("pos").value;

	if (elem == "") {
		alert("Introduce un elemento");
	}
	else {
		pila[poppos] = parseInt(document.querySelector("#elem").value);
		printL();
	}
}

function posL() {
	var poppos = document.getElementById("pos").value;
	var pila2 = delete pila[poppos];
	printL();
}


function sacarL() {
	var elem = document.getElementById("elem").value;
	for (var c = 0; c < pila.length; c++) {
		if (pila[c] == elem) {
			var pila2 = delete pila[c];
		}
	}
	printL();
}

function printP() {
	document.querySelector("#result").innerHTML = "";
	for (var c = 0; c < pila.length; c++) {
		document.querySelector("#result").innerHTML += pila[c] + "<br>";
	}
}

function printC() {
	document.querySelector("#result").innerHTML = "";
	for (var c = 0; c < pila.length; c++) {
		document.querySelector("#result").innerHTML += pila[c] + " - ";
	}
}


function printL() {
	document.querySelector("#result").innerHTML = "";
	for (var c = 1; c < pila.length; c++) {
		document.querySelector("#result").innerHTML += c + " " + " .- " + pila[c] + "<br>";
	}
}
