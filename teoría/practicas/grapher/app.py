import numpy as np
import files as Files
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
