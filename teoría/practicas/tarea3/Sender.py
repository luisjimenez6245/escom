from random import choice
import string

class Sender():
    times = 0

    def __init__(self):
        self.time = 0

    def enable(self, reciever):
        while(self.is_active(reciever)):
            while ((reciever.recieve_word(self.construct_word()))):
                pass
            pass
            self.times += 1
        return

    def is_active(self, reciever):
        return reciever.is_active()
    
    def construct_word(self):
        x = 0
        file = list()
        while (x < 10):
            file.append(self.get_word(10000))
            x += 1
        return file
    
    def get_word(self, length):
        res = ""
        for x in range(length):
            res += (choice(string.ascii_letters))
        return res