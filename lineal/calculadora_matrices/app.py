import numpy as np 

a = np.array([[3,1,3], [1,2,3]])
b = np.array([9,8])
res = np.linalg.solve(a,b)

print(res)
