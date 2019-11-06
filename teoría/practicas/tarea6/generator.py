from random import choice, randint

if __name__ == "__main__":
    length = 10
    f = open("file.txt", "w+")
    while(length > 0):
        i = (randint(0, 2) % 2)
        if (i == 0):
            f.write('r')
        else:
            f.write('b')
        length = length - 1
    f.close()