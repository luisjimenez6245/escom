var cola = new Array();
let cWidth = 700;
var id = 0;
var length = 0;

read();
function read() {
  var db = conectToDb();
  db.transaction(function(tx) {
    tx.executeSql("Select * from Cola", [], function(tran, data) {
      if (data.rows.length > 0) {
        id = data.rows[0].id;
        for (i = 0; i < data.rows.length; i++) {
          let c = { i: i, id: data.rows[i].id };
          addToGame(data.rows[i].content);
        }
      }
    });
  });
}

function meter() {
  var elem = document.getElementById("elem").value;
  if (elem == "") {
    alert("Introduce un elemento");
  } else {
    insertIntoDB("Cola", { id: counter + 1, content: elem, posicion: 0 });
    cola.push(parseInt(document.querySelector("#elem").value));
    length = length + 51;
    addToGame(elem);
  }
}

function sacar() {
  if (itemsInGame.length > 0) {
    deleteFromDB("Cola", id);
    ++id;
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
