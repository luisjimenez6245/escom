import files as Files

n = 27
dic = []

def get_binary(num, length):
    res = str(bin(num))[2:]
    while(len(res) < length):
        res = "0" + res
    return res

def get_res(to_add = ""):
    res = ""
    for x in range(0, n):
        for y in range(0, pow(2,x)):
            res += get_binary(y, x) + to_add
    return res

if __name__ == "__main__":
    res = get_res("\n")
    Files.write_binary_file("con", res)
    res = res.replace("\n", "")
    Files.write_binary_file("con1", res)







