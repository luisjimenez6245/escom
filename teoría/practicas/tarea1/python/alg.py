import files as Files

name ="/media/luis/FILES/bin-dict"
n = 27
dic = []

def get_binary(num, length):
    res = str(bin(num))[2:]
    while(len(res) < length):
        res = "0" + res
    return res

def get_res(to_add = "", file_name = ""):
    Files.write_binary_file(file_name, "")
    for x in range(0, n + 1):
        for y in range(0, pow(2,x)):
            Files.append_to_file(file_name, get_binary(y, x) + to_add)
        print(x)
    return 

if __name__ == "__main__":
    get_res("\n", name)
    get_res("", name + "-1")







