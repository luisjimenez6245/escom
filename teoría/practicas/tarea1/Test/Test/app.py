import files as Files
import numpy as np
import math 

text  = Files.read_file("/Users/lusi/Downloads/OneDrive-2019-08-28/ABBYYpage12_santander.txt")

def fill_cols(arr, n_cols):
    while len(arr) < n_cols:
        arr.append(None)
    return arr

def clean_element(element):
    if element[0:1] is " ":
        element =  element[1:]
    return element

def get_cols(input):
    input = input.replace("   ", "  ").replace("  ", "\t")
    res = list()
    arr =  input.split("\t")
    for element in arr:
        to_work =  element.replace(" ", "")
        if (to_work is not ""):
            res.append(clean_element(element))
    return res

def get_average_cols(cols):
    size = list()
    for col in cols:
        size.append(len(col))
    return math.ceil(np.average(size))


def get_cols_by_meta(input, cols):
    input = input.replace("   ", "  ").replace("  ", "\t")
    res = list()
    arr =  input.split("\t")
    for element in arr:
        to_work =  element.replace(" ", "")
        if (to_work is not ""):
            res.append(element)
    if(len(res) < cols):
        res =  fill_cols(res, cols)
    return res

def get_table(input):
    actual_line = 0
    arrs =  input.split("\n")
    cols = list()
    for element in arrs:
        col = get_cols(element)
        cols.append(col)
    aver = get_average_cols(cols)
    cols = list()
    for element in arrs:
        col = get_cols_by_meta(element, aver)
        cols.append(col)
    return cols


table = get_table(text)

print(table)