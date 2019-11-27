function iniciar() {
  nodoTabla = document.getElementById("tabla");
}

function meterL() {
  var elem = document.getElementById("elem").value;

  if (elem == "") {
    alert("Introduce un elemento");
  } else {
    pila.push(parseInt(document.querySelector("#elem").value));
    printL();
  }
}

function meterpos() {
  var elem = document.getElementById("elem").value;
  var poppos = document.getElementById("pos").value;

  if (elem == "") {
    alert("Introduce un elemento");
  } else {
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
