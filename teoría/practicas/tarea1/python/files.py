import os
import array
from os.path import isfile, join
import shutil

def  get_files_from_directory(path):
    res = [f for f in os.listdir(path) if isfile(join(path, f))]
    return res

def get_current_directory():
    path = os.getcwd()
    return path

def copy(dir, dest):
    if(os.path.exists(dir)):
        if(os.path.isdir(dir)):
            shutil.copytree(dir, dest)
        else:
            shutil.copy(dir, dest)
    else:
        print (dir + " not found")

def create_directory(path):
    try:
        os.mkdir(path)
    except OSError:
        return False
    return True


def create_directory_w_sub(path):
    try:
        os.makedirs(path)
    except OSError:
        return False
    return True


def write_file(name, content):
    if(os.path.isfile(name)):
        pass

    f = open(name, "w+")
    f.write(content)
    f.close()
    return


def write_binary_file(name, content):
    if(os.path.isfile(name)):
        pass
    arr = array.array('b')
    arr.frombytes(content.encode())
    f = open(name, "w+b")
    f.write(arr.tobytes())
    f.close()
    return

def manage_merge(name, content):
    old = read_file(name)
    if(old != content):
        print("old:")
        print(name)
        

def read_file(path):
    res = ""
    with open(path) as fp:
        line = fp.readline()
        while line:
            res += line
            line = fp.readline()
    return res
