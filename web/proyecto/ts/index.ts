interface iStack{
    push(content);
    pop();
}

class Stack implements iStack{

    iSQL;
    constructor(sqlSource){
        this.iSQL = sqlSource;
    }

    public Item = {        
        constructor(id, content, before){
        }
    }

    public push(content) {
    }

    public pop(){

    }

    public printStack() {

    }
}

interface iSQL{
    save(query, paramaters);
    set(tableName, paramaters, conditions);
    get(query, paramaters);
    delete(tableName, conditions);
}