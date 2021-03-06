function getValFromPromt(title, def){
    var res = prompt(title, def);
    return res;
}
function onClickGetItemCount(){
    let val = getValFromPromt("Agrega el item", "0");
    let content = document.getElementsByTagName(val);
    if (content !== undefined){
        alert("Se tiene " + content.length + " de estos elementos " + val +". ");
    }else{
        alert("Se tiene 0 de estos elementos " + val +". ");
    }
}
function onClickFirstChild(){
    let root = document.getElementsByTagName("BODY")[0];
    alert ( root.firstChild.nodeName);
}
function onClickLastChild(){
    let root = document.getElementsByTagName("BODY")[0];
    alert (root.lastChild.nodeName);
}
function getNodeInfo(node){
    var res;
    if(node.childNodes !==  undefined && node.childNodes.length > 0){
        res = {
            "nodeName" : node.nodeName,
            "nodeType" : node.nodeType,
            "nodeValue" : node.nodeValue,
            "childs" : []
        }
    }
    else{
        res = {
            "nodeName" : node.nodeName,
            "nodeType" : node.nodeType,
            "nodeValue" : node.nodeValue            
        }
    }
    return res;
}
function getChildsInfo(parent, infoParent){
    parent.childNodes.forEach((element)=> {
        var info = getNodeInfo(element);
        if (element.childNodes.length > 0){
            getChildsInfo(element, info);
        }
        infoParent.childs.push(info);
    });
    return infoParent;
}
function onClickNodeInfo(){
    let root = document.getRootNode();
    let info = getChildsInfo(root, getNodeInfo(root));
    alert(JSON.stringify(info));
}
