res = dict() 

res['R_{11}^{0}'] = '0'
res['R_{12}^{0}'] = '1'
res['R_{13}^{0}'] = '11+101'
res['R_{14}^{0}'] = '10'
res['R_{21}^{0}'] = '11'
res['R_{22}^{0}'] = '(11)^{*}'
res['R_{23}^{0}'] = '1'
res['R_{24}^{0}'] = '0'
res['R_{31}^{0}'] = '1'
res['R_{32}^{0}'] = '1'
res['R_{33}^{0}'] = '(11)^{*}'
res['R_{34}^{0}'] = '110'
res['R_{41}^{0}'] = '11'
res['R_{42}^{0}'] = '11'
res['R_{43}^{0}'] = '1'
res['R_{44}^{0}'] = '(0)^{*}'


formula = "Rij}^{k} = Rij}^{k-1)+(Rij}^{k-1)(Rkk}^{k-1))^{*}Rkj}^{k-1})"
formulaS = "str(res['R_{ij}^{k-1}']) + '+' + str(res['R_{ij}^{k-1}']) + '(' + str(res['R_{kk}^{k-1}']) + ')^{*}' + str(res['R_{kj}^{k-1}'])"
def ijFill():
    for k in range(1,5):
        for i in range(1, 5):
            for j in range(1, 5):
                key = "R_{ij}^{k}".replace('k', str(k)).replace('i', str(i)).replace('j', str(j))
                if(key not in res):
                    valueAux = formulaS.replace('k-1', str(k-1)).replace('k', str(k)).replace('i', str(i)).replace('j', str(j))
                    try:
                        value = eval(valueAux)
                        res[key ] = value
                    except:
                        return False
    return True


if __name__ == "__main__":
    valid = False
    ijFill()
    f = open("file.txt", "w+")
    for key in res:
        f.write( "$" + key+ " = "+ res[key]+"$\\\\\n")
    f.close()