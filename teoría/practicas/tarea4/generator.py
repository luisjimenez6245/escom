from random import choice, randint

if __name__ == "__main__":
    length = 100
    f = open("file.txt", "w+")
    while(length > 0):
        f.write(str((randint(0, 2) % 2)))
        length = length - 1
    f.close()