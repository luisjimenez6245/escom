var itemsInGame = [];

function startGame() {
    itemsInGame.push(new component(30, 30, "red", 80, 75));
    itemsInGame.push(new component(30, 30, "red", 80, 75, itemsInGame[0]));
    myGameArea.start();
}

function newCookie(name, value) {
    var cookie = [name, '=', JSON.stringify(value), '; domain=.', window.location.host.toString(), '; path=/;'].join('');
    console.log(cookie)
    document.cookie = cookie;
  }
  function readCookie(name) {
    var result = document.cookie.match(new RegExp(name + '=([^;]+)'));
    result && (result = JSON.parse(result[1]));
    return result;
   }
   function deleteCookie(name) {
    document.cookie = [name, '=; expires=Thu, 01-Jan-1970 00:00:01 GMT; path=/; domain=.', window.location.host.toString()].join('');
  }
  
  function startGame() {
    myGameArea.start(document.getElementById("canvas"));
  }

var myGameArea = {
    canvas: document.createElement("canvas"),
    start: function () {
        this.canvas.width = 480;
        this.canvas.height = 270;
        this.context = this.canvas.getContext("2d");
        document.body.insertBefore(this.canvas, document.body.childNodes[0]);
        this.interval = setInterval(updateGameArea, 20);
    },
    stop: function () {
        clearInterval(this.interval);
    },
    clear: function () {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
    }
}

function component(width, height, color, x, y, parent) {
    this.parent = parent;
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;
    this.speedX = 0;
    this.speedY = 0;
    this.gravity = 0.1;
    this.gravitySpeed = 0;
    this.bounce = 0.6;
    this.update = function () {
        ctx = myGameArea.context;
        ctx.fillStyle = color;
        ctx.fillRect(this.x, this.y, this.width, this.height);
        ctx.fillStyle = "white";
        ctx.fillText("hola",this.x, this.y+ (this.height/2), this.width, this.height);
    }
    this.newPos = function () {
        this.gravitySpeed += this.gravity;
        this.x += this.speedX;
        this.y += this.speedY + this.gravitySpeed;
        if (this.parent == null || this.parent == undefined) {
            this.hitBottom(myGameArea.canvas.height - this.height);
        }
        else {
            this.hitBottom(parent.y - parent.height - 2);
        }
    }
    this.hitBottom = function (rockbottom) {

        if (this.y > rockbottom) {
            this.y = rockbottom;
            this.gravitySpeed = -(this.gravitySpeed * this.bounce);
        }
    }
}

function updateGameArea() {
    myGameArea.clear();
    for(item in itemsInGame){
        item.newPos();
        item.update();
    }
}