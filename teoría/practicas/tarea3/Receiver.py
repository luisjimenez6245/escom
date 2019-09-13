from random import randint

class Receiver():

    def __init__(self):
        pass

    def is_active(self):
        return ((randint(0, 2) % 2) == 0)
    
    def recieve_word(self, word):
        return self.verify_word(word)

    def verify_word(self, word):
        one = 0
        cero = 0
        for item in word:
            if(item == "1"):
                one += 1
            else:
                cero += 1 
        return cero%2==0 and one%2==0