res = ""
for i in range(1, 28):
    res +=  str(i) + ","

print(res)

aux = "A, B, C, D, E, F, G, H, I, J, K, L, M, N, Ñ, O, P, Q, R, S, T, U, V, W, X, Y, Z"
aux = aux.lower()
aux = aux.replace(" ", "")
aux_res = aux.split(",")
res = ""
for item in aux_res:
    res +=  "'" + item +"',"

print(res)
