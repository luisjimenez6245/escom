import matplotlib
import matplotlib.pyplot as plt
import numpy as np
import files as Files
import sys


file_name =  '/Volumes/FILES/labuena.png'
fi = Files.read_file("/Volumes/FILES/res-test")  
fi = fi[:-1]
items = fi.split("\n")

# Data for plotting
fi = fi[:-1]
items =  fi.split("\n")

to_work_x = list()
to_work_y = list()

i = 0

for item in items:
    aux = len(item.replace("0",""))
    to_work_x.append(aux)
    to_work_y.append(i)
    i = i +1

fig, ax = plt.subplots()
ax.plot(to_work_y, to_work_x)

ax.set(xlabel='', ylabel='',
       title='')
ax.grid()

fig.savefig(file_name)
