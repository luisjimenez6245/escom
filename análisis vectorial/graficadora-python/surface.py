import numpy as np
from plotly.offline import download_plotlyjs, init_notebook_mode, plot
from plotly.graph_objs import *
import sys

file =  'name.html'
s = []
t = []
type = ""
x = []
y = []
z = []

def get_matrix(text):
    if text.isdigit():
        val = eval(text)
        return [val for zij in t]
    else:
        if "t" in text or "s" in text or "np" in text:
            return eval(text) 
    return []

type = sys.argv[1]
t = get_matrix(sys.argv[2])
s = get_matrix(sys.argv[3])

x = get_matrix(sys.argv[4])
y = get_matrix(sys.argv[5])
z = get_matrix(sys.argv[6])

i = 0
j = 0
k = 0

mat  = []

while i < len(t):
    x1 = x[i]
    j = 0
    k = 0
    while j < len(t):
        y1 = y [i]
        while k < len(t):
            z1 = y [i]
            mat.append( [x1, y1, z[i]])
            k += 1
        j +=1
    i += 1

vector = Surface(
    z = mat
)

data = [vector]
layout = Layout(
            margin = dict( 
               l = 0,
               r = 0,
               b = 0,
               t = 0
            )
        )

fig=dict(data=data,layout=layout)
plot(fig, filename=file, auto_open=False)
print(file)