import os
from os.path import isfile, join
import json 

rdic = dict()

def evaluate(c, position, dictionary):
    res = list()
    for word in dictionary:
        l = list(word)
        if not (len(l) <= position):
            if l[position] == c:
                res.append(word)
    return res

def create_existing_item(word, index, line):
    if word in rdic:
        rdic[word] += 1
    else: 
        rdic[word] = 1
    return "{\"linea\":"+str(line)+",\"caracter\": " + str(index -  len(word))+ ", \"word\":\"" + str(word)+"\"}"

def scope(dictionary, text):
    is_posible = True
    possible_words = dictionary
    counter = 0
    index = 0
    line_counter = 0
    word = ""
    res =  ""
    lines = text.split("\n")
    for line in lines:
        index = 0
        for item in line:
            if(item == " " or item == "\n" or item == "\t" or item == "\0"):
                counter = 0
                if(is_posible) and index != 0 and word in dictionary:
                    res +=  create_existing_item(word, index, line_counter) + ","
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
        line_counter += 1
    return res[:-1]


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
    r = scope(dictio, document)
    r = "{\"items\": ["+ r +"]," +  "\"repeticiones\" : " + json.dumps(rdic) + "}"

    write_file("./res.json", r)