import files as Files
import numpy as np
import utils as Utils
import json as Json
import math 

file_name = ""
text  = ""

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
    return math.floor(np.average(size))


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
    print(aver)
    cols = list()
    for element in arrs:
        col = get_cols_by_meta(element, aver)
        cols.append(col)
    return cols

def get_table_by_meta(input, n_cols):
    arrs =  input.split("\n")
    cols = list()
    for element in arrs:
        col = get_cols_by_meta(element, n_cols)
        cols.append(col)
    return cols


def is_blank_space(input):
    input = input.lower().replace('\t', '').replace(' ', '').replace('\n', '')
    return input == ""

def has_many_blank_cols(input, wait = 0):
    if wait != 0:
        if (len(input) < wait):
            return False
    aux = clean_list(input)
    orig = len(input) -2
    calc = len(aux)
    return (calc >= orig)

def clean_list(input):
    aux = list()
    for item in input:
        if not (is_blank_space(item)) and item is not '':
            aux.append(clean_element(item))
    return aux

def clean_input(input):
    res = input
    while('\t\t' in res):
        res = res.replace("\t\t", "\t")
    return res

def get_cols_by_length(cols, ncols):
    res = list()
    for item in cols:
        if (len(item)) == ncols:
            res.append(item)
    return res

def search_for_table(input, first_col, last_col):
    pass


def fixed_columns(input, heads, table):
    good_cols = get_cols_by_length(table, len(heads))
    first_col = table[0]
    last_col = table[len(table) - 1]
    print(first_col)
    print(last_col)

    
def get_table_by_cols(input, heads):
    arrs =  input.split("\n")
    res = list()
    for item in heads:
        aux  =  list()
        aux.append(item)
        res.append(aux)
    elements = list()
    for item  in arrs:
        item = item.replace("   ", "\t").replace("  ", "\t").replace("\t\t\t", "\t").replace("\t\t", "\t")
        item = clean_element(item)
        if not (is_blank_space(item)):
            aux = clean_list(item.split('\t'))
            elements.append(aux)
    elements_aux = list()
    ncols = get_average_cols(elements)
    for elem in elements:
        if has_many_blank_cols(elem, ncols):
            elements_aux.append(elem)
    print(elements_aux)
    fixed_columns(input, res, elements_aux)    
    print(res)
    

def get_table_by_bank(input, meta):
    bank =  meta["bank"]
    bank = bank.lower()
    ncols = 0 
    headers = []
    res =  dict()
    if(bank == "santander"):
        headers = ["Fecha de transaction", "Identificador", "Titulo", "Numero de Participaciones", "Moneda", "Precio",  "Valor de Mercado", "Valor en divisa de referencia"]
    elif(bank == "morgan stanley"):
        headers = ["Transaction Date", "Settlement Date", "Activity Type", "Description", "Comments" , "Quantity", "Price", "Credits/fDebits)"]
    elif(bank == "hsbc"):
        headers = ["Description", "Settlement Date", "Trade Date", "Activity Type", "Quantity", "Price", "Accrued Interest", "Dividend Share", "Amount" ]
    elif(bank == "creditsuisse"):
        headers = ["Settlement Date", "Transaction Date", "Activity Type", "Description", "Quantity", "Price", "Accured Interest", "Ammount", "Currency"]
    ncols = len(headers)
    res["cols"] =  get_table_by_cols(input, headers)
    res["headers"] = headers
    return res

if __name__ == "__main__":
    args = Utils.get_args_as_dcit()
    file_name = args["-f"]
    text  = Files.read_file(file_name)
    print(text)
    if ( "-m" in args): 
        meta =  Json.loads(args["-m"])
        table = get_table_by_bank(text, meta)
    else:
        table = get_table(text)
    print(table)

#test-case:python3 r.py -f /Users/lusi/Downloads/OneDrive-2019-08-28/ABBYYpage12_santander.txt -m "{\"bank\":\"Santander\"}"
#test-case:python3 r.py -f /Users/lusi/Downloads/OneDrive-2019-08-28/ABBYYpage11_hsbc.txt -m "{\"bank\":\"hsbc\"}"
#test-case:python3 r.py -f /Users/lusi/Downloads/OneDrive-2019-08-28/ABBYYpage16_morganstanley.txt -m "{\"bank\":\"morgan stanley\"}"
#test-case:python3 r.py -f /Users/lusi/Downloads/OneDrive-2019-08-28/ABBYYpage10_creditsuisse.txt -m "{\"bank\":\"creditsuisse\"}"
