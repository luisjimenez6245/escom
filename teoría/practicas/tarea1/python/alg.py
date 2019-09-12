import files as Files

name ="/Volumes/FILES/bin-dict"
n = 27
dic = []

def get_binary(num, length):
    res = str(bin(num))[2:]
    while(len(res) < length):
        res = "0" + res
    return res

def get_res(to_add = "", file_name = ""):
    for x in range(0, n + 1):
        for y in range(0, pow(2,x)):
            f.write(bytes((get_binary(y, x) + to_add), 'utf-8'))
        print(x)
    return 

if __name__ == "__main__":
    Files.write_binary_file(name, "") 
    f = open(name, "ab")
    get_res("\n", name)
    get_res("", name + "-1")
    f.close()








