from tkinter import Tk, Canvas, Frame, BOTH

class Panel(Frame):

    canvas = None
    width_stroke = 1
    fill = "#ffffff"
    outline = "#000000"

    def __init__(self, title = ""):
        super().__init__()
        self.canvas = Canvas(self)
        self.pack(fill=BOTH, expand=1)
        self.canvas.pack(fill=BOTH, expand=1)
    
    def add_arc(self, position_x, position_y):
        self.canvas.create_arc(position_x, position_y, 90, 100, start= 0, extent= 210, outline= self.outline, fill= self.fill, width= self.width_stroke)  
    
    def add_circle(self, position_x, position_y, text = ""):
        radio = 40
        diameter = radio / 2
        position_x = position_x - radio
        position_y = position_y - radio
        self.canvas.create_circle(position_x , position_y, radio,  outline= self.outline, fill= self.fill, width= self.width_stroke)
        self.canvas.create_text(position_x , position_y , text= text)
        self.canvas.update()
    
    def add_line(self, points):
        return self.canvas.create_line(points, width = self. width_stroke)


def _create_circle(self, x, y, r, **kwargs):
    return self.create_oval(x-r, y-r, x+r, y+r, **kwargs)

def main():
    Canvas.create_circle = _create_circle
    root = Tk()
    panel = Panel()
    width = 330
    heigth = 220 
    panel.add_circle(100, 130, "perro")
    root.geometry("1630x220+300+300")
    root.mainloop()


if __name__ == '__main__':
    main()