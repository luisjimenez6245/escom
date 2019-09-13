from tkinter import Tk, Canvas, Frame, BOTH
from Panel import Panel

class Coordinate():
    x = 0
    y = 0

    def __init__(self, x, y):
        self.x  = x
        self.y = y
    
def main():
    root = Tk()
    panel = Panel()
    width = 0
    heigth = 420 
    parent = create_main_node(panel, Coordinate(x = 0, y = 0), "q0", heigth)
    r = parent
    dic = {("q1", "1"), ("q2","cadena"), ("q3", "es valida")}
    for item in dic:
        r = create_node(panel, r, item)
    final = create_main_node(panel, r, "qf", heigth)
    node_to_node(panel, final, parent, 1)
    width = final.x
    width += 50
    root.geometry( str(width) +"x"+ str(heigth) +"+300+300")
    root.mainloop()

def create_main_node(panel, coordinate, state, heigth):
    middle_heigth = (heigth/2)
    r = create_double_node(panel, Coordinate(x = coordinate.x + 100, y = middle_heigth), state)
    panel.add_line(coordinate.x,  middle_heigth, coordinate.x + 50,  middle_heigth, end_arrow=1)
    return r

def create_double_node(panel, coordinate, state):
    panel.add_circle(coordinate.x, coordinate.y, "", 50)
    panel.add_circle(coordinate.x,  coordinate.y, state, 30)
    return Coordinate(x = coordinate.x + 50, y = coordinate.y)

def create_node(panel, coordinate, state, changing_state = ""):
    width = 30
    res =  Coordinate(x = coordinate.x + 20 + (width * 2), y = coordinate.y)
    panel.add_line(coordinate.x, res.y, res.x - width, res.y, end_arrow=1)
    panel.add_circle(res.x, res.y, state, width)
    res.x += width
    return res

def node_to_node(panel, coordinate_self, coordinate_to, radio_self, radio_to = 0):
    if radio_to == 0:
        radio_to = radio_self
    mid_x = (coordinate_self.x + (coordinate_to.x /3) ) /2
    mid_y = coordinate_self.y  
    panel.add_elliptical_arc(mid_x, mid_y, coordinate_self.x - mid_x, 100, 30, 180-30)
    pass

if __name__ == '__main__':
    main()