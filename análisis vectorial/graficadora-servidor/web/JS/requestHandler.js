let URL = DOMAIN + ":8080/grapher";
let server = DOMAIN + ":4004";

var point = 0;
var p = -1;
//*
// JS handler functions
//*/

function animate() {
    let params = {
        c_action: 'exec',
        g_type: $("#select").children("option:selected").val(),
        x_parameter: $('#x_val').val(),
        y_parameter: $('#y_val').val(),
        z_parameter: $('#z_val').val(),
        t_parameter: $('#t_val').val(),
        s_parameter: $('#s_val').val(),
        g_point: point
    };
    requestHandler('/dev', 'POST', params, true);
    ++point;
    window.setTimeout(animate, 2000);
}

function handleSelect(event) {
    var x = document.getElementById("select").value;
    let params = {
        c_action: 'option',
        option: x
    };
    requestHandler('/dev', 'POST', params, true);
}

function graph() {
    let params = {
        c_action: 'exec',
        g_type: $("#select").children("option:selected").val(),
        x_parameter: $('#x_val').val(),
        y_parameter: $('#y_val').val(),
        z_parameter: $('#z_val').val(),
        t_parameter: $('#t_val').val(),
        s_parameter: $('#s_val').val()
    };
    requestHandler('/dev', 'POST', params, true);
}

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
    return true;
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