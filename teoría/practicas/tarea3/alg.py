import Sender
import Receiver

if __name__ == "__main__":
    res = Sender.Sender(open("./history.text", "w+"), open("./accepted.txt", "w+"), open("./unaccepted.txt", "w+"))
    res.enable(Receiver.Receiver())
    print(res.times)
    res.history.close()
    res.accepted.close()
    res.unaccepted.close()