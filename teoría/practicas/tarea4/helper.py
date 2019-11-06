import os
from os.path import isfile, join
def read_file(path):
    res = ""
    with open(path) as fp:
        line = fp.readline()
        while line:
            res += line
            line = fp.readline()
    return res

def get_selector(item, count):
    resa  = ""
    aux = list()
    for it in dictio:
        if it.startswith(item):
            aux.append(it)
    dic_aux = list()
    for it in aux:
        h = it[count-1:count]
        if h not in dic_aux:
            dic_aux.append(h)
    for it in dic_aux:
        if item+it in dictio:
            resa += "else if(c == '"+ it + "'){\n return register_word(\""+ item+it +"\");\n}\n"
        elif it is not "":
            methods.append(")
            resa += "else if(c == '"+ it + "'){\n return manage_" + item+ it+ "();\n}\n"
    resa = resa[4:]
    if(item is ""):
        resa += "else if (c == '\n')\n{\nchar_count = 0;\nlines += 1;\n}\nelse if (c == EOF)\n{\nreturn -1;\n}\nreturn 0;"
    else:
        resa += "return 0;"
    return resa


def write_file(name, content):
    if(os.path.isfile(name)):
        pass
    f = open(name, "w+")
    f.write(content)
    f.close()
    return

if __name__ == "__main__":
    file_content = read_file("dic.txt")
    dictio = file_content.split("\n")
    r = 16
    final = ""
    methods = list()
    for i in range(16):
        res = list()
        for item in dictio:
            if len(item) > i:
                h = item[0:i]
                if h not in res:
                    res.append(h)
        result = ""
        for item in res:
            result += ("\nint manage_" + item +  "()\n{\n char c = get_char();\n " + get_selector (item, i + 1)+" \n}\n")
        final += (result)
    res_aux = ""
    for item in methods:
        res_aux += "\n" + "int manage_" + item+ it+ "();"
    final = res_aux + final
    write_file("./a.txt", final)