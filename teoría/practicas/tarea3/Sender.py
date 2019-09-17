from random import choice, randint

class Sender():
    times = 0
    history = None
    accepted = None
    unaccepted = None

    def __init__(self,  history, accepted, unaccepted):
        self.time = 0
        self.accepted = accepted
        self.unaccepted = unaccepted
        self.history = history

    def enable(self, reciever):
        x = 0
        while(x < 10):
            word = self.construct_word()
            if(self.is_active(reciever)):
                if(reciever.recieve_word(word)):
                    self.accepted.write(word + "\n")
                    self.history.write("q" + str(self.times)+  "--> q" +  str(self.times + 1) + "\n")
                    self.times += 1
                else:
                    self.history.write("q" + str(self.times)+  "--> q0\n")
                    self.unaccepted.write(word + "\n")
                    self.times == 0
            x += 1
        self.history.close()
        return

    def is_active(self, reciever):
        return reciever.is_active()
    
    def construct_word(self):
        return self.get_word(100000)
    
    def get_word(self, length):
        res = ""
        for x in range(length):
            res += str((randint(0, 2) % 2))
        return res