from random import randint

class Receiver():

    def __init__(self):
        pass

    def is_active(self):
        return ((randint(0, 2) % 2) == 0)
    
    def recieve_word(self, word):
        return self.verify_word(word)

    def verify_word(self, file):
        for word in file:
            if(len(word) is not 10000):
                return False
        return True