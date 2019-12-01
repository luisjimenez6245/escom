function onClickDatabases(){
    
}

function onClickCheckSyntax(){
    let params = {
        'c_action': 'check_syntax',
        'query' : $('.CodeMirror')[0].CodeMirror.getValue()
    };
    requestHandler('/', 'POST', params, false);
}