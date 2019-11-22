let colors = ["red", "blue", "black", "purple"];
var itemsInGame = [];
function startGame() {
    myGameArea.start(document.getElementById("canvas_cola"));
}

var myGameArea = {
    canvas: undefined,
    start: function (canvas) {
        this.canvas = canvas;
        this.canvas.width = 100;
        this.canvas.height = 600;
        this.context = this.canvas.getContext("2d");
        this.interval = setInterval(updateGameArea, 20);
    },
    stop: function () {
        clearInterval(this.interval);
    },
    clear: function () {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
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
    this.update = function () {
        ctx = myGameArea.context;
        ctx.fillStyle = color;
        ctx.fillRect(this.x, this.y, this.width, this.height);
        ctx.fillStyle = "white";
        ctx.fillText(text, this.x, this.y + (this.height / 2), this.width, this.height);
    }
    this.newPos = function () {
        this.gravitySpeed += this.gravity;
        this.x += this.speedX;
        this.y += this.speedY + this.gravitySpeed;
        if (this.parent == null || this.parent == undefined) {
            this.hitBottom(this.height);
        }
        else {
            this.hitBottom(parent.y + parent.height + 2);
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
    for (var i = 0; i < itemsInGame.length; ++i) {
        itemsInGame[i].newPos();
        itemsInGame[i].update();
    }
}