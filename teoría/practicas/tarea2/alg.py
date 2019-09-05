word = ""

def evaluate(c, position, dictionary):
    res = list()
    print(position)
    for word in dictionary:
        l = list(word)
        if not (len(l) <= position):
            if l[position] == c:
                res.append(word)
    return res

def create_exiting_item(word, index, possible_words):
    print("se encontro en el index :" + str(index))    
    print(possible_words)

def scope(dictionary, text):
    is_posible = True
    possible_words = dictionary
    counter = 0
    index = 0
    for item in text:
        if(item == " " or item == "\n" or item == "\t" or item == "\0"):
            counter = 0
            if(is_posible) and index != 0 and word in dictionary:
                create_exiting_item(word, index, possible_words)
            word = ""
            possible_words = dictionary
            is_posible = True
        elif(is_posible):
            word += item
            possible_words = evaluate(item, counter, possible_words)
            is_posible = (len(possible_words)!= 0)
            if(is_posible):
                counter += 1 
        index += 1 

if __name__ == "__main__":
    dictio = {"include", "main", "fabi", "luis"}
    document =  " skskk includ sjl fabi include main luis"
    scope(dictio, document)