var itemsAllocated = [];
function getTxtFromInput(id) {
  return document.getElementById("txt_" + id).value;
}

function getItems(textInput) {
  var text = textInput;
  itemsAllocated = [];
  if (text == undefined || text == null || text == "") {
    text = getTxtFromInput("input");
  }
  let itemInText = text.split(",");
  itemInText.forEach(item => {
    if (item >= 0 && item <= 9) {
      if (!itemsAllocated.includes(item)) {
        itemsAllocated.push(item);
      }
    }
  });
  console.log(itemsAllocated);
}
