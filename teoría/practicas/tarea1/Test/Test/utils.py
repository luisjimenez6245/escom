import sys

def get_args_as_dcit():
    items = list()
    res = dict()
    script_name = sys.argv[0]
    for item in sys.argv:
        if (item is not script_name):
            items.append(item)
    counter =  0
    key = ""
    for item in items:
        if (counter % 2) == 0:
            res[item] = ""
            key  =  item
        else:
            res[key] = item
        counter += 1
    return res