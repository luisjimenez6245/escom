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
    res["cols"] =  get_table_by_meta(input, ncols)
    res["headers"] = headers
    return res

if __name__ == "__main__":
    args = Utils.get_args_as_dcit()
    file_name = args["-f"]
    text  = Files.read_file(file_name)
    if ( "-m" in args): 
        meta =  Json.loads(args["-m"])
        table = get_table_by_bank(text, meta)
    else:
        table = get_table(text)
    print(table)

#test-case:python3 app.py -f /Users/lusi/Downloads/OneDrive-2019-08-28/ABBYYpage12_santander.txt -m "{\"bank\":\"Santander\"}"