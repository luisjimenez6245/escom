from random import choice, randint

if __name__ == "__main__":
    length = 100000
    f = open("file.txt", "w+")
    while(length > 0):
        i = (randint(0, 2) % 2)
        if (i == 0):
            f.write('1')
        else:
            f.write('0')
        length = length - 1
    f.write('\n')
    f.close()