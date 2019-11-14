function getValFromPromt(title, def) {
    var res = prompt(title, def);
    return res;
}
function onClickGetItemCount() {
    let val = getValFromPromt("Agrega el item", "0");
    let content = document.getElementsByTagName(val);
    if (content !== undefined) {
        alert("Se tiene " + content.length + " de estos elementos " + val + ". ");
    } else {
        alert("Se tiene 0 de estos elementos " + val + ". ");
    }
}
function onClickFirstChild() {
    let root = document.getElementsByTagName("BODY")[0];
    alert(root.firstChild.nodeName);
}
function onClickLastChild() {
    let root = document.getElementsByTagName("BODY")[0];
    alert(root.lastChild.nodeName);
}
function getNodeInfo(node) {
    var res;
    if (node.childNodes !== undefined && node.childNodes.length > 0) {
        res = {
            "nodeName": node.nodeName,
            "nodeType": node.nodeType,
            "nodeValue": node.nodeValue,
            "childs": []
        }
    }
    else {
        res = {
            "nodeName": node.nodeName,
            "nodeType": node.nodeType,
            "nodeValue": node.nodeValue
        }
    }
    return res;
}
function getChildsInfo(parent, infoParent) {
    parent.childNodes.forEach((element) => {
        var info = getNodeInfo(element);
        if (element.childNodes.length > 0) {
            getChildsInfo(element, info);
        }
        infoParent.childs.push(info);
    });
    return infoParent;
}
function onClickNodeInfo() {
    let root = document.getRootNode();
    let info = getChildsInfo(root, getNodeInfo(root));
    alert(JSON.stringify(info));
}

function onClickGetValues() {
    let answer = {
        'Nombre': getTxtFromInput('nombre'),
        'Ap. Paterno': getTxtFromInput('paterno'),
        'Ap. Materno': getTxtFromInput('materno'),
        'Fecha de nacimiento Dia': getSelectedFromSelect('dia'),
        'Fecha de nacimiento Mes': getSelectedFromSelect('mes'),
        'Fecha de nacimiento Año': getSelectedFromSelect('ano'),
        'Signo Zodiacal': getSelectedFromSelect('signo'),
        'Sexo': getSelectedFromRadio('sexo'),
        'Correo': getTxtFromInput('email'),
        'Calle': getTxtFromInput('calle'),
        'Calle Numero': getTxtFromInput('calle_num'),
        'Calle CP': getTxtFromInput('calle_cp'),
        'Delegación': getSelectedFromSelect('delegacion'),
        'Lenguaje': getCheckedFromCheckBox('lenguaje'),
        'Promedio': getTxtFromInput('promedio'),
        'Semestre': getSelectedFromSelect('semestre'),
        'Materias': getSelectedFromRadio('materias'),
        'Comentarios': getTxtFromInput('comentarios'),
        'Cuenta nombre': getTxtFromInput('cuenta_nombre'),
        'cuenta psw': getTxtFromInput('cuenta_psw'),
    };
    alert(JSON.stringify(answer));

}


function getTxtFromInput(id) {
    return document.getElementById("txt_" + id).value;
}

function getSelectedFromSelect(id) {
    var res = [];
    var element = document.getElementById("select_" + id).options;
    for (i = 0; i < element.length; i++) {
        if (element[i].selected) {
            res.push(element[i].value);
        }
    }
    if (res.length === 1)
        return res[0];
    return res;
}

function getSelectedFromRadio(name) {
    var res = [];
    var e = document.getElementsByName('rd_' + name);
    for (i = 0; i < e.length; i++) {
        if (e[i].checked) {
            res.push(e[i].value)
        }
    }
    if (res.length === 1)
        return res[0];
    return res;
}

function getCheckedFromCheckBox(name) {
    var res = [];
    var e = document.getElementsByName('chb_' + name);
    for (var i = 0; e.length; ++i) {
        if (e[i].checked) {
            res.push(e[i].value);
            break;
        }
    }
    if (res.length === 1)
        return res[0];
    return res;
}