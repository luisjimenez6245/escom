import Sender
import Receiver

if __name__ == "__main__":
    res = Sender.Sender()
    res.enable(Receiver.Receiver())
    print(res.times)