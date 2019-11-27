let cWidth = 700;
var dic = [];
read();
function read() {
  var db = conectToDb();
  db.transaction(function(tx) {
    tx.executeSql("Select * from Cola", [], function(tran, data) {
      if (data.rows.length > 0) {
        id = data.rows[0].id;
        for (i = 0; i < data.rows.length; i++) {
            dic[i] = {}
          addToGame(data.rows[i].content, data.rows[i].posicion);
        }
      }
    });
  });
}

function meterPosicion() {
  var posicion = document.getElementById("pos").value;
  if (posicion == "" || posicion == undefined || posicion == null) {
    alert("Introduce una posición");
  } else {
    var elem = document.getElementById("elem").value;
    if (posicion >= counter + 1) {
      addToGame(elem);
    } else {
      addToGame(elem, posicion);
    }
  }
}

function sacarPosicion() {
  var posicion = document.getElementById("pos").value;
  if (posicion == "" || posicion == undefined || posicion == null) {
    alert("Introduce una posición");
  } else {
    itemsInGame.splice(posicion, 1);
    for (var i = parseInt(posicion); i < itemsInGame.length; ++i) {
      itemsInGame[i].parent.x = itemsInGame[i - 1].x;
      itemsInGame[i].x = itemsInGame[i-1].x;
      itemsInGame[i].newPos();
      itemsInGame[i].update();
    }
  }
}

function meter() {
  var elem = document.getElementById("elem").value;
  if (elem == "" || elem == undefined || elem == null) {
    alert("Introduce un elemento");
    insertIntoDB("Cola", { id: counter + 1, content: elem, posicion: counter+1});
  } else {
    addToGame(elem);
  }
}

function sacar() {
  if (itemsInGame.length > 0) {
    for (var i = itemsInGame.length - 1; i >= 0; --i) {
      if (i - 1 >= 0) {
        itemsInGame[i].x = itemsInGame[i - 1].x;
      } else {
        itemsInGame[i].x = 0;
      }
      itemsInGame[i].newPos();
      itemsInGame[i].update();
    }
    itemsInGame.shift();
    --counter;
  } else {
    alert("No hay ningún elemento.");
  }
}

function component(width, height, color, x, y, text, parent) {
  this.parent = parent;
  this.text = text;
  this.width = width;
  this.height = height;
  this.x = x;
  this.y = y;
  this.speedX = 0;
  this.speedY = 0;
  this.gravity = 0.1;
  this.gravitySpeed = 0;
  this.bounce = 0.6;
  this.update = function() {
    ctx = myGameArea.context;
    ctx.fillStyle = color;
    ctx.fillRect(this.x, this.y, this.width, this.height);
    ctx.fillStyle = "white";
    ctx.fillText(
      text,
      this.x,
      this.y + this.height / 2,
      this.width,
      this.height
    );
  };
  this.newPos = function() {
    this.gravitySpeed += this.gravity;
    this.x += this.speedX + this.gravitySpeed;
    this.y += this.speedY;
    if (this.parent == null || this.parent == undefined) {
      this.hitBottom(this.height);
    } else {
      this.hitBottom(parent.x + parent.height + 2);
    }
  };
  this.hitBottom = function(rockbottom) {
    if (this.x > rockbottom) {
      this.x = rockbottom;
      this.gravitySpeed = -(this.gravitySpeed * this.bounce);
    }
  };
}
