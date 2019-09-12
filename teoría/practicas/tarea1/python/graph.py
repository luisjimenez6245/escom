import files as Files
import numpy as np
from plotly.offline import download_plotlyjs, init_notebook_mode, plot
from plotly.graph_objs import *
import plotly.graph_objects as go
import math
from IPython.display import display, HTML
import sys


file_name =  '/Volumes/FILES/name2.html'
fi = Files.read_file("/Volumes/FILES/res-test")  
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



layout = Layout(
        margin = layoutMargin,
        xaxis=dict(
            autorange = True,
        ),
        yaxis=dict(
            autorange = True,
        )
    )  

fig= go.Figure(data=go.Scatter(x= to_work_y, y=to_work_x))
plot(fig, filename=file_name, auto_open=False)

print(file_name)