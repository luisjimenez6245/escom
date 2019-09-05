#pip3 install twilio
from twilio.rest import Client
import utils as Utils

account_sid = "ACcec2196de38d91f7ed91b6be65e13cd9"
auth_token  = "6fb8958a5f713375e12ec58b18791b4f"
content_ = ""
to_ = ""

def send_sms(to_, cont):
    client = Client(account_sid, auth_token)
    message = client.messages.create(
        to=to_, 
        from_="+12622882752",
        body=cont)
    return message.sid

if __name__ == "__main__":
    args = Utils.get_args_as_dcit()
    if( "-c" in args):  
        content_ = args["-c"]
    if( "-t" in args):  
        to_ = args["-t"]
    print(send_sms(to_, content_))