import numpy as np
import math


arr = [-1, 0, 1, 2, 3, 5, 15, 20, 100, 409, 500, 593,
       1000, 1471, 1500, 2801, 3000, 5000, 10000, 20000]


result = []

def log2(num):
    try:
        r = (np.log2(num))
        r_str = str(r)
        if( r_str == 'inf' or r_str == 'nan' or r_str == '-inf'):
            return 0
        return r
    except:
        return 0

for n in arr:
    form = "7*(n-1)+2*n+3"
    eval("result.append(math.floor("+form+"))")


for item in result:
    print(item)
    