let colors = ["red", "blue", "black", "purple"];
var itemsInGame = [];
var counter = -1;
var index = false;
var itemsLoaded = {};

function conectToDb() {
  var db;
  db = openDatabase(
    "estruturasLO",
    "1.0",
    "Tiene las estructuras de la práctica.",
    2 * 1024 * 1024
  );
  return db;
}

function initiliazeDB() {
  var db = conectToDb();
  db.transaction(function(tx) {
    tx.executeSql(
      "CREATE TABLE IF NOT EXISTS Pila (id unique, content, posicion)"
    );
  });
  db.transaction(function(tx) {
    tx.executeSql(
      "CREATE TABLE IF NOT EXISTS Cola (id unique, content, posicion)"
    );
  });
  db.transaction(function(tx) {
    tx.executeSql(
      "CREATE TABLE IF NOT EXISTS Lista (id unique, content, posicion)"
    );
  });
}

function deleteFromDB(tableName, id) {
  var db = conectToDb();
  db.transaction(function(tx) {
    tx.executeSql("DELETE FROM " + tableName + " WHERE id = " + id);
  });
}

function insertIntoDB(tableName, parameters) {
  var db = conectToDb();
  var query = "INSERT INTO " + tableName + " (";
  var itemToInsert = [];
  var helper = "(";
  for (var key in parameters) {
    itemToInsert.push(parameters[key]);
    query += key + ",";
    helper += "?,";
  }
  helper = helper.substr(0, helper.length - 1);
  query = query.substr(0, query.length - 1);
  helper += ")";
  query += ") VALUES " + helper;
  db.transaction(function(tran) {
    tran.executeSql(query, itemToInsert);
  });
}

function startGame() {
  initiliazeDB();
  myGameArea.start(document.getElementById("canvas"));
}

var myGameArea = {
  canvas: undefined,
  start: function(canvas) {
    this.canvas = canvas;
    this.canvas.width = 700;
    this.canvas.height = 700;
    this.context = this.canvas.getContext("2d");
    this.interval = setInterval(updateGameArea, 20);
  },
  stop: function() {
    clearInterval(this.interval);
  },
  clear: function() {
    this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
  }
};

function updateGameArea() {
  myGameArea.clear();
  for (var i = 0; i < itemsInGame.length; ++i) {
    itemsInGame[i].newPos();
    itemsInGame[i].update();
  }
}

function addToGame(elem, posicion) {
  if (posicion == undefined) {
    if (counter > -1) {
      itemsInGame.push(
        new component(
          50,
          50,
          colors[counter % colors.length],
          20,
          75,
          elem,
          itemsInGame[counter]
        )
      );
    } else {
      itemsInGame.push(new component(50, 50, colors[1], 20, 75, elem));
    }
  } else { 
    
    console.log("hola");
    for (var i = 0; i < itemsInGame.length; ++i) {
      console.log(itemsInGame[i].text);
    }
    console.log("holarr");
    itemsInGame.splice(
      posicion,
      0,
      new component(
        50,
        50,
        colors[counter % colors.length],
        20,
        75,
        elem,
        itemsInGame[posicion - 1]
      )
    );
    itemsInGame[(parseInt(posicion) + 1)].parent =  itemsInGame[posicion];
    for (var i = (parseInt(posicion) +1); i < itemsInGame.length; ++i) {
      itemsInGame[i].parent.x += 104;
      itemsInGame[i].x += 104; 
      itemsInGame[i].newPos();
      itemsInGame[i].update();
    }
  }
  ++counter;
}
