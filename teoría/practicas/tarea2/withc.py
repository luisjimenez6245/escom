import os
from os.path import isfile, join
word = ""

def evaluate(c, position, dictionary):
    res = list()
    for word in dictionary:
        l = list(word)
        if not (len(l) <= position):
            if l[position] == c:
                res.append(word)
    return res

def create_exiting_item(word, index, possible_words):
    return "{\"index\": " + str(index -  len(word))+ ", \"word\":\"" + str(word)+"\"}"

def scope(dictionary, text):
    is_posible = True
    possible_words = dictionary
    counter = 0
    index = 0
    word = ""
    res =  ""
    for item in text:
        if(item == " " or item == "\n" or item == "\t" or item == "\0"):
            counter = 0
            if(is_posible) and index != 0 and word in dictionary:
                res +=  create_exiting_item(word, index, possible_words) + ","
            word = ""
            possible_words = dictionary
            is_posible = True
        elif(is_posible):
            word += item
            possible_words = evaluate(item, counter, possible_words)
            is_posible = (len(possible_words)!= 0)
            if(is_posible):
                counter += 1 
        index += 1 
    return res


def read_file(path):
    res = ""
    with open(path) as fp:
        line = fp.readline()
        while line:
            res += line
            line = fp.readline()
    return res


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
    document = read_file("./program.c")
    r = scope(dictio, document)[:-1]
    r = "["+ r +"]"
    write_file("./res.json", r)