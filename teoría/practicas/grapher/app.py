import numpy as np
import files as Files
import matplotlib.pyplot as plt
import sys
import csv

file_name =  '/Volumes/FILES/files/'
name = "spaces"

with open(file_name + name +'.csv', 'w') as csvFile1:
    writer = csv.writer(csvFile1)
    writer.writerows([])
csvFile1.close()


path = file_name + name +'.txt'
path_c = file_name + name +'.csv'

with open(path_c, 'a') as csvFile:
    writer = csv.writer(csvFile)
    i = 0
    with open(path) as fp:
        line = fp.readline()
        while line:
            aux = len(line.replace("0",""))
            writer.writerow((aux,i))
            i = i +1
csvFile.close()


x, y = np.loadtxt(path_c, delimiter=',', unpack=True)
plt.plot(x,y, label='')

plt.xlabel('x')
plt.ylabel('y')
plt.title('Gráfica')
plt.legend()
plt.show()