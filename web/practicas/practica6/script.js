function onClickCalcFactorial() {
    var numero = prompt("Ingrese elnúmero", "0");
    numero = factorial(numero);
    alert("El factorial es:" + numero);
}

function factorial(numero) {
    if (numero === 0) {
        return 1;
    }
    else {
        return numero * factorial(numero - 1);
    }

}

var isParagraphChanged = false;

function onClickChangeItems() {
    if (isParagraphChanged) { 
        var elements = document.getElementsByClassName("aCambiar");
        elements.forEach(function(element) {
            element.classList.remove('cambio');
          });
    }
    else {
        document.getElementsByClassName("aCambiar").classList.add('cambio');
    }
}


