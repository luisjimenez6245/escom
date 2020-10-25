import matplotlib
import matplotlib.pyplot as plt
import sys
from os import path
import inspect

actual_file = (path.dirname(path.abspath(
    inspect.getfile(inspect.currentframe()))))

arr = [-1, 0, 1, 2, 3, 5, 15, 20, 100, 409, 500, 593,
       1000, 1471, 1500, 2801, 3000, 5000, 10000, 20000]

items = []
folder_name = sys.argv[1]
file_path = path.join(actual_file, folder_name, "res.txt")
fil = open(file_path, "+r")
for line in fil.readlines():
    line = line.replace("\n", "").replace(" ", "")
    if(line != ""):
        items.append(int(line))
fil.close()

try:
    fig, ax = plt.subplots()
    ax.plot(arr, items)
    ax.grid()
    file_path = path.join(actual_file, folder_name, "grafica.png")
    fig.savefig(file_path)
except Exception as ex:
    print(ex)
    pass
