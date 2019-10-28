from tkinter import Tk, Canvas, Frame, BOTH
from Panel import Panel
import json

class Coordinate():
    x = 0
    y = 0

    def __init__(self, x, y):
        self.x  = x
        self.y = y

class State():
    name = []
    coordinate = None
    childs = []
    is_initial = False
    is_parent = False
    def __init__(self, name, is_initial, is_final):
        self.name = name

def load_file():
    return


def json_to_states(json):
    res = []
    for item in json:
        helper = State(item["name"], item["is_initial"], item["is_final"])
        if "childs" in item:
            helper.childs.extend(json_to_states(item["childs"]))
        res.append(res)
    return res

def set_coordinates(states):
    res = []
    for state in states:
        if state.is_parent:
            pass
        elif state.is_final:
            pass
        else:
            pass

if __name__ == "__main__":
    file_name = ""
    json_loads = json.loads(load_file(file_name))
    items = json_to_states(json_loads)

