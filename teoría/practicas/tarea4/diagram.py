import os
from os.path import isfile, join

item_list = dict()
item_container = list()

class contianer:
    name = ""
    childs = []

    def __init__(self, name =""):
        self.name = name

def read_file(path):
    res = ""
    with open(path) as fp:
        line = fp.readline()
        while line:
            res += line
            line = fp.readline()
    return res

def add_to_child(parent, item_to_add, length_st):
    con = False
    for p in parent.childs:
        if(len(p.name) < length_st):
           con =  add_to_child(p, item_to_add, length_st)
        if(p.name is item_to_add):
            con = True
    if (con is False):
        parent.childs.append(contianer(item_to_add))
    


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
        for item in res:
            item_helper =  item[0:1]
            if item_helper not in item_list:
                item_list[item_helper] = contianer(item_helper)
            else:
                add_to_child(item_list[item_helper], item, len(item))
                

        