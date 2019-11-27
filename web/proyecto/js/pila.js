let cWidth =  700;

read();
function read() {
  var db = conectToDb();
  db.transaction(function(tx) {
    tx.executeSql("Select * from Pila", [], function(tran, data) {
      if (data.rows.length > 0) {
        id = data.rows[0].id;
        for (i = 0; i < data.rows.length; i++) {
          addToGame(data.rows[i].content);
        }
      }
    });
  });
}

function meter() {
  var elem = document.getElementById("elem").value;
  if (elem == "" && elem != undefined) {
    alert("Introduce un elemento");
  } else {
    insertIntoDB("Pila", { id: counter + 1, content: elem, posicion: 0 });
    addToGame(elem);
  }
}

function sacar() {
  if (itemsInGame.length > 0) {
    deleteFromDB("Pila", counter + 1);
    itemsInGame.pop();
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
    this.x += this.speedX;
    this.y += this.speedY + this.gravitySpeed;
    if (this.parent == null || this.parent == undefined) {
      this.hitBottom(myGameArea.canvas.height - this.height);
    } else {
      this.hitBottom(parent.y - parent.height - 2);
    }
  };
  this.hitBottom = function(rockbottom) {
    if (this.y > rockbottom) {
      this.y = rockbottom;
      this.gravitySpeed = -(this.gravitySpeed * this.bounce);
    }
  };
}

