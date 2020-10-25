import matplotlib
import matplotlib.pyplot as plt
import sys
from os import path
import inspect
import numpy as np
import math

actual_file = (path.dirname(path.abspath(
    inspect.getfile(inspect.currentframe()))))
x =  np.linspace(0, 500000, 5000000 )

values = []

"""
for n in x: 
    n = (5*n) / 3
    helper = 0
    try:
        helper = math.floor(np.log2( n) - 1)
    except:
        pass
    values.append(helper)
for n in x: 
    helper = 0
    try:
        helper = math.ceil(n/2) * math.floor(np.log2(n) -2)
    except:
        pass
    values.append(helper)
"""

for n in x: 
    helper = 0
    try:
        cal  = 0
        for i in range(0, int(n) + 1):
            cal += (n-i)
        helper = math.ceil((5*n)/2) * cal
    except Exception as e:
        print(e)
        pass
    values.append(helper)

folder_name = sys.argv[1]
file_path = path.join(actual_file, folder_name, "res.txt")

try:
    fig, ax = plt.subplots()
    ax.plot(x, values)
    ax.grid()
    file_path = path.join(actual_file, folder_name, "grafica-500000.png")
    fig.savefig(file_path)
except Exception as ex:
    print(ex)
    pass
