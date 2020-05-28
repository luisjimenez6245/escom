import numpy as np
from plotly.offline import download_plotlyjs, init_notebook_mode, plot
from plotly.graph_objs import *
import math
from IPython.display import display, HTML
import sys

N=50

def get_matrix(text):
    if text.isdigit():
        val = eval(text)
        return [val for zij in t]
    else:
        if "t" in text or "s" in text or "np" in text:
            return eval(text) 
    return []

class Point:
    def __init__(self, x , y,  z):
        self.x = x
        self.y = y
        self.z = z

pointA = Point(0,0,0)

file =  'name.html'
type = ""
x = []
y = []
z = []

type =  ""

file  = sys.argv[1]
type = sys.argv[2]

t = get_matrix(sys.argv[3])
s = get_matrix(sys.argv[4])

x = get_matrix(sys.argv[6])
y = get_matrix(sys.argv[7])
z = get_matrix(sys.argv[8])

i = 100
vector = None
r = None
N = int(len(t)/100)

colorVector = "rgb(84,128,5)"
colorR = "rgb(84,11,5)"

lineDictV = dict( 
                color = colorVector,
                width = 6
            )
lineDictR = dict( 
                color = colorR,
                width = 6
            )
markerV = dict( size = 1,
            color = colorVector)

markerR = dict( size = 1,
            color = colorR)

layoutMargin = dict( 
            l = 0,
            r = 0,
            b = 0,
            t = 0
        )

properties = [{'type': 'buttons',
                'buttons': [{'label': 'Play',
                                        'method': 'animate',
                                        'args': [None]}
                                        ]}
            ]

if type == "3d":
    if(len(z) > 0 and len(y) > 0 and len(x) > 0) :
        vector = Scatter3d( 
            x = x,
            y = y,
            z = z,
            marker = markerV,
            line = lineDictV
        )
        r = Scatter3d(
            x = [0, x[1]],
            y = [0, y[1]],
            z = [0, z[1]],
            marker = markerR,
            line = lineDictR
        )
        frames=[dict(data=[
                Scatter3d(
                    x = [0, x[k*(i+1)]],
                    y = [0, y[k*(i+1)]],
                    z = [0, z[k*(i+1)]],
                    marker = markerR,
                    line = lineDictR
                ),
                vector
                ],
        ) for k in range(N)]   
    elif (len(z) <= 0 ):
        vector = Scatter3d( 
            x = x,
            y = y,
            marker = markerV,
            line = lineDictV
        )
        r = Scatter3d(
            x = [0, x[1]],
            y = [0, y[1]],            
            marker = markerR,
            line = lineDictR
        )
        frames=[dict(data=[
                Scatter3d(
                    x = [0, x[k*(i+1)]],
                    y = [0, y[k*(i+1)]],
                    marker = markerR,
                    line = lineDictR
                ),
                vector
                ],
            ) for k in range(N)] 
    elif (len(y) <= 0 ):   
        vector = Scatter3d( 
            x = x,
            z = z,
            marker = markerV,
            line = lineDictV
        )
        r = Scatter3d(
            x = [0, x[1]],
            z = [0, z[1]],
            marker = markerR,
            line = lineDictR
        )
        frames=[dict(data=[
                Scatter3d(
                    x = [0, x[k*(i+1)]],
                    z = [0, z[k*(i+1)]],
                    marker = markerR,
                    line = lineDictR
                ),
                vector
                ],
            ) for k in range(N)] 
    elif (len(x) <= 0 ):   
        vector = Scatter3d( 
            y = y,
            z = z,
            marker = markerV,
            line = lineDictV
        )
        r = Scatter3d(
            y = [0, y[1]],
            z = [0, z[1]],
            marker = markerR,
            line = lineDictR
        )
        frames=[dict(data=[
                Scatter3d(
                    y = [0, y[k*(i+1)]],
                    z = [0, z[k*(i+1)]],
                    marker = markerR,
                    line = lineDictR
                ),
                vector
                ],
            ) for k in range(N)]
    layout = Layout(
        margin = layoutMargin,
        updatemenus= properties
    )
else:
    N =int(N/5)
    i = i * 5
    vector = Scatter( 
            x = x,
            y = y,
            marker = markerV,
            line = lineDictV
        )
    r = Scatter(
            x = [0, x[1]],
            y = [0, y[1]],
            marker = markerR,
            line = lineDictR
    )
    maxX = max(y)
    if(max(x) >= max(y)):
        maxX = max(x)
    minX = min(y)
    if(max(x) <= max(y)):
        minX = min(x)
    rangeP = [minX*2, maxX*2]
    frames=[dict(data=[
                Scatter(
                    x = [0, x[k*(i+1)]],
                    y = [0, y[k*(i+1)]],
                    marker = markerR,
                    line = lineDictR
                ),
                vector
                ],
            ) for k in range(N)]
    layout = Layout(
        margin = layoutMargin,
        updatemenus= properties,
        xaxis=dict(
            autorange = False,
            range=rangeP
        ),
        yaxis=dict(
            autorange = False,
            range=rangeP
        )
    )    

data = [vector, r]


fig=dict(data=data,layout=layout, frames=frames )
plot(fig, filename=file, auto_open=False)

print(file)