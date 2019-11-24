//let URL = "http://13.59.58.71";
//let server = "http://13.59.58.71:4004";

//let URL = "http://trabajosafm.datagrid.mx";
//let server = "http://trabajosafm.datagrid.mx:4004";

let URL = "http://localhost:8080/ROOT";
let server = "http://localhost:4004";

var id_participant = 0;
var id_document = 0;
var id_mentor = 0;


//*
// Admin main functions
//*/

function onHandleList(opt) {
    let params = {
        c_action: opt
    };
    requestHandler("/administrador/", "POST", params);
}


function onClickSaveMentor() {
    if ($('#lbl_psw').val() === $('#lbl_cpsw').val()) {
        let params = {
            c_action: 'new_mentor',
            email: $('#lbl_email').val(),
            password: $('#lbl_psw').val(),
            name: $('#lbl_name').val()
        };
        requestHandler("/administrador/", "POST", params);
    } else {
        alert('eror');
    }
}

function saveMentor() {
    let params = {
        c_action: 'save_mentor'
    };
    requestHandler("/administrador/", "POST", params);
}

function getMentorList() {
    let params = {
        c_action: 'list_mentors'
    };
    requestHandler("/administrador/", "POST", params);
}

function searchParticipantList(event) {
    let ser = $('#search').val();
    if (ser.length > 2) {
        let params = {
            c_action: 'search_participant',
            name: ser
        };
        requestHandler("/administrador/", "POST", params, true);
    }
}

function searchMentorList(event) {
    let ser = $('#search').val();
    if (ser.length > 2) {
        let params = {
            c_action: 'search_mentor',
            name: ser
        };
        requestHandler("/administrador/", "POST", params, true);
    }
}

function getParticipantList() {
    let params = {
        c_action: 'list_participants'
    };
    requestHandler("/administrador/", "POST", params);
}

function viewMentor(id) {
    if (id > 0) {
        let params = {
            c_action: 'view_mentor',
            id_mentor: id
        };
        requestHandler("/administrador/", "POST", params);
    } else {
        alert('');
    }
}

function viewParcipant(id) {
    if (id > 0) {
        let params = {
            c_action: 'view_participant',
            id_participant: id
        };
        requestHandler("/administrador/", "POST", params);
    } else {
        alert('');
    }
}

//*
// User main functions
//*/

function saveChanges(id_revision) {
    if (id_revision > 0) {
        let params = {
            c_action: 'save_changes'
        };
        requestHandler("/mentores/documento", "POST", params);
    } else {
        alert('');
    }
}


function sendRevision(id_revision) {
    if (id_revision > 0) {
        let params = {
            c_action: 'save_revision',
            id_revision: id_revision,
            id_document: id_document
        };
        requestHandler("/mentores/documento", "POST", params);
    } else {
        alert('');
    }
}

function onClickSendRevision(status, id_revision) {
    if (id_revision > 0) {
        let params = {
            c_action: 'send_revision',
            id_revision: id_revision,
            status: status,
            id_document: id_document
        };
        requestHandler("/mentores/documento", "POST", params);
    } else {
        alert('');
    }
}

function onClickViewComment(id_comment, id_revision) {
    if (id_comment > 0 && id_revision > 0) {
        let params = {
            c_action: 'view_comment',
            id_comment: id_comment,
            id_revision: id_revision,
            id_document: id_document
        };
        requestHandler("/mentores/documento", "POST", params);
    } else {
        alert('idreviosn: ' + id_revision + ',idcomment:' + id_comment);
    }
}

function deleteComment(id_comment, id_revision) {
    if (id_comment > 0 && id_revision > 0) {
        let params = {
            c_action: 'delete_comment',
            id_comment: id_comment,
            id_revision: id_revision,
            id_document: id_document
        };
        requestHandler("/mentores/documento", "POST", params);
    } else {
        alert('idreviosn: ' + id_revision + ',idcomment:' + id_comment);
    }
}

function addComment(section, revisonid) {
    if (section !== '') {
        let comment = JSON.stringify(word_comments.getContents().ops);
        let params = {
            c_action: 'add_comment',
            section: section,
            id_document: id_document,
            description: comment,
            id_revision: revisonid
        };
        requestHandler("/mentores/documento", "POST", params, true);
    } else {
        alert('');
    }
}

function onClickAddComment(id_revision, section) {
    if (id_revision && id_revision > 0) {
        let params = {
            c_action: 'new_comment',
            id_revision: id_revision,
            section: section,
            id_document: id_document
        };
        requestHandler("/mentores/documento", "POST", params);
    } else {
        alert('');
    }
}

function onHandleState(opt) {
    let params = {
        c_action: opt
    };
    requestHandler("/mentores/documentos", "POST", params);
}

function onRevisionViewClick(id, revison) {
    let params = {
        c_action: 'load_document',
        id_document: id,
        id_revision: revison
    };
    requestHandler("/mentores/documento", "POST", params);

}


//*
// User main functions
//*/

function onBackClick(valid, other) {
    id_document = 0;
    hideModal();
    if (valid) {
        viewDocuments(true);
    } else
    {
        viewDocuments(false);
    }
}

function onSaveInfoClick(uType) {
    if ($('#lbl_psw').val() === $('#lbl_cpsw').val()) {
        let params = {
            c_action: 'save',
            email: $('#lbl_email').val(),
            password: $('#lbl_psw').val(),
            name: $('#lbl_name').val()
        };
        if (uType)
            requestHandler("/mentores/perfil", "POST", params);
        else
            requestHandler("/participantes/perfil", "POST", params);
    } else {
        alert('Verifica las contraseñas');
    }
}

function succesRegister() {
    hideModal();
    onHaveAccountClick();
}

function onHaveAccountClick() {
    let params = {
        c_action: 'old_account'
    };
    requestHandler("/login", "POST", params);
}

function onSaveAccountClick() {
    if ($('#lbl_psw').val() === $('#lbl_cpsw').val()) {
        let params = {
            c_action: 'register',
            email: $('#lbl_email').val(),
            password: $('#lbl_psw').val(),
            name: $('#lbl_name').val()
        };
        requestHandler("/login", "POST", params);
    } else {
        alert('eror');
    }
}

function onResgisterClick() {
    if ($('#lbl_psw').val() === $('#lbl_cpsw').val()) {
        let params = {
            c_action: 'register',
            email: $('#lbl_email').val(),
            password: $('#lbl_psw').val(),
            name: $('#lbl_name').val()
        };
        requestHandler("/login", "POST", params);
    } else {
        alert('eror');
    }
}

function onLoginClick() {
    let params = {
        c_action: 'login',
        email: $('#lbl_emailF').val(),
        password: $('#lbl_pswF').val()
    };
    requestHandler("/login", "POST", params);
}

function onNoAccountClick() {
    let params = {
        c_action: 'new_account'
    };
    requestHandler("/login", "POST", params);

}

function viewProfile(url) {
    let params = {
        c_action: ''
    };
    requestHandler(url + "/perfil", "POST", params);
}


//*
// Participant main functions
//*/


function back(type, valid) {
    if (valid) {

    } else {

    }
}

function onNewDocumentClick() {
    let params = {
        c_action: ''
    };
    requestHandler("/participantes/trabajo", "POST", params);
}

function onDocumentClick() {
    let params = {
        c_action: ''
    };
    requestHandler("", "POST", params);
}

function deleteImage(id) {
    if (id_document > 0) {
        let params = {
            c_action: 'delete_image',
            id_image: id,
            id_document: id_document
        };
        requestHandler("/participantes/trabajo", "POST", params);
    }
}

function deleteAuthor(id) {
    if (id_document > 0) {
        let params = {
            c_action: 'delete_author',
            id_author: id,
            id_document: id_document
        };
        requestHandler("/participantes/trabajo", "POST", params);
    }
}

function deleteReference(id) {
    if (id_document > 0) {
        let params = {
            c_action: 'delete_reference',
            id_reference: id,
            id_document: id_document
        };
        requestHandler("/participantes/trabajo", "POST", params);
    }
}

function viewImage(id) {
    if (id_document > 0) {
        let params = {
            c_action: 'view_image',
            id_image: id,
            id_document: id_document
        };
        requestHandler("/participantes/trabajo", "POST", params);
    }
}

function viewAuthor(id) {
    if (id_document > 0) {
        let params = {
            c_action: 'view_author',
            id_author: id,
            id_document: id_document
        };
        requestHandler("/participantes/trabajo", "POST", params);
    }
}

function viewReference(id) {
    if (id_document > 0) {
        let params = {
            c_action: 'view_reference',
            id_reference: id,
            id_document: id_document
        };
        requestHandler("/participantes/trabajo", "POST", params);
    }
}

function viewDocuments(type) {
    hideModal();
    let params = {
        c_action: ''
    };
    if (type) {
        requestHandler("/participantes/documentos", "POST", params);
    } else {
        requestHandler("/mentores/documentos", "POST", params);
    }
}

function succesSend() {
    hideModal();
    let params = {
        c_action: '',
        id_document: id_document
    };
    requestHandler("/participantes/documentos", "POST", params);
}

function sendDocument() {
    let params = {
        c_action: 'send',
        id_document: id_document
    };
    requestHandler("/participantes/trabajo", "POST", params);
}

function onClickAddAuthor() {
    let params = {
        c_action: 'click_add_author',
        id_area: $("#select_id").children("option:selected").val(),
        id_document: id_document
    };
    requestHandler("/participantes/trabajo", "POST", params);
}

function onClickAddReference() {
    let params = {
        c_action: 'click_add_reference',
        id_area: $("#select_id").children("option:selected").val(),
        id_document: id_document
    };
    requestHandler("/participantes/trabajo", "POST", params);
}

function onClickAddImage() {
    let params = {
        c_action: 'click_add_image',
        id_area: $("#select_id").children("option:selected").val(),
        id_document: id_document
    };
    requestHandler("/participantes/trabajo", "POST", params);
}

function saveDocument() {
    let introduction = JSON.stringify(word_introduction.getContents() === null ? {} : word_introduction.getContents().ops);
    let objective = JSON.stringify(word_objective.getContents().ops === null ? {} : word_objective.getContents().ops);
    let methodology = JSON.stringify(word_methodology.getContents().ops === null ? {} : word_methodology.getContents().ops);
    let results = JSON.stringify(word_results.getContents().ops === null ? {} : word_results.getContents().ops);
    let conclusions = JSON.stringify(word_conclusions.getContents().ops === null ? {} : word_conclusions.getContents().ops);
    let thanks = JSON.stringify(word_thanks.getContents().ops === null ? {} : word_thanks.getContents().ops);
    if (validateDocument(true)) {
        let params = {
            c_action: 'save',
            id_document: id_document,
            title: $('#lbl-title').val(),
            introduction: introduction,
            objective: objective,
            methodology: methodology,
            results: results,
            conclusions: conclusions,
            thanks: thanks,
            id_area: $("#select_id").children("option:selected").val(),
            id_participant: id_participant
        };
        requestHandler("/participantes/trabajo", "POST", params);
    }
}




function modifyAuthor(id) {
    if (id > 0) {
        if ($("#first_name").val() === '') {
            alert('El nombre del autor no puede estar vacío.');
            return false;
        }
        if ($("#paternal_surname").val() === '') {
            alert('El apellido paterno del autor no puede estar vacío.');
            return false;
        }
        if ($("#maternal_surname").val() === '') {
            alert('El apellido materno del autor no puede estar vacío.');
            return false;
        }
        if ($("#authorship_type").children("option:selected").val() === 0 || $("#authorship_type").children("option:selected").val() === '0') {
            alert('Opción no valida para el tipo de autor.');
            return false;
        }
        if ($("#educational_level").children("option:selected").val() === 0 || $("#educational_level").children("option:selected").val() === '0') {
            alert('Opción no valida para el nivel educacional.');
            return false;
        }
        if (validateDocument()) {
            let params = {
                c_action: 'modify_author',
                first_name: $("#first_name").val(),
                paternal_surname: $("#paternal_surname").val(),
                maternal_surname: $("#maternal_surname").val(),
                authorship_type: $("#authorship_type").children("option:selected").val(),
                educational_level: $("#educational_level").children("option:selected").val(),
                is_studen: $("#is_student").children("option:selected").val(),
                id_document: id_document,
                id_author: id
            };
            requestHandler("/participantes/trabajo", "POST", params, true);
        }
    } else {
        console.log('estoy pendejo');
    }

}

function addAuthor() {
    if ($("#first_name").val() === '') {
        alert('El nombre del autor no puede estar vacío.');
        return false;
    }
    if ($("#paternal_surname").val() === '') {
        alert('El apellido paterno del autor no puede estar vacío.');
        return false;
    }
    if ($("#maternal_surname").val() === '') {
        alert('El apellido materno del autor no puede estar vacío.');
        return false;
    }
    if ($("#authorship_type").children("option:selected").val() === 0 || $("#authorship_type").children("option:selected").val() === '0') {
        alert('Opción no valida para el tipo de autor.');
        return false;
    }
    if ($("#educational_level").children("option:selected").val() === 0 || $("#educational_level").children("option:selected").val() === '0') {
        alert('Opción no valida para el nivel educacional.');
        return false;
    }
    if (validateDocument()) {
        let params = {
            c_action: 'add_author',
            first_name: $("#first_name").val(),
            paternal_surname: $("#paternal_surname").val(),
            maternal_surname: $("#maternal_surname").val(),
            authorship_type: $("#authorship_type").children("option:selected").val(),
            educational_level: $("#educational_level").children("option:selected").val(),
            is_studen: $("#is_student").children("option:selected").val(),
            id_document: id_document
        };
        requestHandler("/participantes/trabajo", "POST", params, true);
    }

}

function modifyReference(id) {
    if (id > 0) {
        if (validateDocument()) {
            let reference = JSON.stringify(word_reference.getContents().ops);
            let params = {
                c_action: 'modify_reference',
                text: reference,
                id_document: id_document,
                id_reference: id
            };
            requestHandler("/participantes/trabajo", "POST", params, true);
        }
    } else {
        console.log('estoy pendejo');
    }
}

function addReference() {
    if (validateDocument()) {
        let reference = JSON.stringify(word_reference.getContents().ops);
        let params = {
            c_action: 'add_reference',
            text: reference,
            id_document: id_document
        };
        requestHandler("/participantes/trabajo", "POST", params, true);
    }
}

function onDocumentEditClick(id) {
    let params = {
        c_action: 'load_document',
        id_document: id
    };
    requestHandler("/participantes/trabajo", "POST", params);

}

function deleteDocument(id) {
    let params = {
        c_action: 'delete',
        id_document: id
    };
    requestHandler("/participantes/trabajo", "POST", params);

}
function onDocumentDeleteClick(id) {
    let params = {
        c_action: 'click_delete_document',
        id_document: id
    };
    requestHandler("/participantes/trabajo", "POST", params);

}

function onDocumentHelpClick(id) {
    let params = {
        c_action: ''
    };
    requestHandler("", "POST", params);

}

function validateSendDoc() {

}

function validateDocument(required) {
    var text = word_introduction.getText() +
            word_objective.getText() +
            word_methodology.getText() +
            word_results.getText() +
            word_conclusions.getText() +
            word_thanks.getText();

    var count = text.split(' ').length;
    if (count > 610) {
        alert('La extensión máxima del resumen son 600 palabras de todo el documento, se escribieron: ' + count + '.');
        return false;
    }

    text = $('#lbl-title').val();
    count = text.split(' ').length;
    if (count > 15) {
        alert('La extensión máxima del título son 15 palabras, se escribieron: ' + count + '.');
        return false;
    }

    if (id_document > 0 && id_participant > 0) {
        return true;
    } else {
        var auxiliar;
        var res = true;
        auxiliar = $('#lbl-title').val();
        var content = "";
        if (auxiliar === '' || auxiliar === null) {
            content = "title";
            res = false;
        }
        if (required) {
            auxiliar = word_introduction.getContents().ops;
            if (auxiliar === '' || auxiliar === null || auxiliar === {}) {
                content = "introduction";
                res = false;
            }
            auxiliar = word_objective.getContents().ops;
            if (auxiliar === '' || auxiliar === null || auxiliar === {}) {
                content = "objective";
                res = false;
            }
            auxiliar = word_methodology.getContents().ops;
            if (auxiliar === '' || auxiliar === null || auxiliar === {}) {
                content = "methodology";
                res = false;
            }
            auxiliar = word_results.getContents().ops;
            if (auxiliar === '' || auxiliar === null || auxiliar === {}) {
                content = "results";
                res = false;
            }
            auxiliar = word_conclusions.getContents().ops;
            if (auxiliar === '' || auxiliar === null || auxiliar === {}) {
                content = "conclusions";
                res = false;
            }
            auxiliar = word_thanks.getContents().ops;
            if (auxiliar === '' || auxiliar === null || auxiliar === {}) {
                content = "thanks";
                res = false;
            }
            auxiliar = $('#select_id').children("option:selected").val();
            if (auxiliar === '' || auxiliar === null) {
                content = "select_id";
                res = false;
            }
        }
        if (res !== true) {
            let params = {
                c_action: 'error',
                content: content
            };
            //requestHandler("/", "POST", params);
        }
    }
    return true;
}

function modifyImage(id) {
    if (id) {
        let footer = JSON.stringify(word_image.getContents().ops);
        let params = {
            c_action: 'modify_image',
            footer: footer,
            id_document: id_document,
            id_image: id
        };
        requestHandler("/participantes/trabajo", "POST", params, true);
    } else {
        console.log('estoy pendejo');
    }
}

function addImage(url) {
    if (url) {
        if (validateDocument()) {
            let footer = JSON.stringify(word_image.getContents().ops);
            let params = {
                c_action: 'add_image',
                footer: footer,
                url: url,
                id_document: id_document
            };
            requestHandler("/participantes/trabajo", "POST", params, true);
        } else {
            hideModal();
        }
    } else {
        var file = document.querySelector('#img_input').files[0];
        if (file) {
            uploadFile(file);
        }
    }
}

//*
// JS handler functions
//*/


function deleteContent(id) {
    if (id) {
        $(id).remove();
    }
}

function showLoading() {
    $("#modal-loading").addClass("container-loading");
    $("#modal-loading").removeClass("container-hidden");
}

function hideLoading() {
    $("#modal-loading").addClass("container-hidden");
    $("#modal-loading").removeClass("container-loading");
}

function showModal() {
    $("#modal-container").addClass("container-modal");
    $("#modal-container").removeClass("container-hidden");
}

function hideModal() {
    $("#modal-container").addClass("container-hidden");
    $("#modal-container").removeClass("container-modal");

    word_image = null;
    word_reference = null;
    word_comments = null;

    toolBar = {};
    options = [];
}

function screenHandler(json) {
    try {
        if (json !== null) {
            if (json.modal !== null && json.modal !== "") {
                $('#modal-container').html(json.modal);
            }
            if (json.content !== null && json.content !== "") {
                $('#main-container').html(json.content);
            }
            if (json.script !== null && json.script !== "") {
                $('#js-handler').html(json.script);
            }

        }
    } catch (e) {
        console.log(e);
    }

    return;
}

function validate_email(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function requestHandler(url, method, params, op) {
    showLoading();
    $.ajax({
        url: URL + url,
        method: method,
        data: params,
        success: function (res) {
            if (res !== null && res !== '') {
                if (op) {
                    appendHandler(res);
                } else {
                    window.history.pushState("object or string", url, URL + url);
                    screenHandler(res);
                }
                hideLoading();
            } else {
                alert('Se requiere volver a iniciar sesión');
                exit();
            }
        }
    });
}


function exit() {
    window.location.href = URL + "/log.jsp?ex=sdsa";
}

function appendHandler(json) {
    try {
        if (json !== null) {
            $('#js-handler').html(json.script);
            $(json.modal).append(json.content);
        }
    } catch (e) {
        console.log(e);
    }

    return;
}

function changeFile() {
    var file = document.querySelector('#img_input').files[0];
    var preview = document.querySelector('#image-container');
    var reader = new FileReader();

    reader.onloadend = function () {
        preview.style.backgroundImage = "url(" + reader.result + ")";
    }
    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.style.backgroundImage = "url()";
    }
}

function uploadFile(blob) {
    if (blob) {
        showLoading();
        let url = `${server}/resources/file/`;
        $.ajax({
            url: url,
            type: 'POST',
            data: new FormData($('#photo-file-wrapper')[0]),
            cache: false,
            contentType: false,
            processData: false,
            xhr: function () {
                var myXhr = $.ajaxSettings.xhr();
                return myXhr;
            },
            success: function (res) {
                addImage(res.url);
            }
        });
    }
}

var options;

var toolBarOptions;

var word_introduction;
var word_objective;
var word_methodology;
var word_results;
var word_conclusions;
var word_thanks;

var word_image;
var word_reference;
var word_comments;

var container = [];
var contentList;

function setContent(content, conId) {
    let  opt = {
        modules: {
            toolbar: false
        },
        theme: 'bubble',
        placeholder: 'Editar',
        readOnly: true
    };
    let con = new Quill(conId, opt);
    con.setContents(content);
    var text = con.getText();
    if (text.length > 300) {
        text = text.substring(0, 300);
    }
    con.setText(text);
    con = null;
}

function stopEditor() {
    toolBar = {};
    options = [];
    word_introduction = null;
    word_objective = null;
    word_methodology = null;
    word_results = null;
    word_conclusions = null;
    word_thanks = null;

    word_image = null;
    word_reference = null;
    word_comments = null;
}


function setEditor(name, options) {
    if (options)
        return new Quill(name, options);
    else
        return new Quill(name);

}
