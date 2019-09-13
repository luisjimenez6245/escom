from tkinter import Tk, Canvas, Frame, BOTH
import math

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
    
    def add_arc(self, position_x, position_y, t0, t1):
        return canvas.create_arc(x-r, y-r, x+r, y+r, start=t0, extent=t1-t0,style='arc', width=self.width_stroke)    

    def add_circle(self, x, y, text = "", r = 40):
        diameter = r / 2
        self.canvas.create_oval(x+r, y+r, x-r, y-r, width=self.width_stroke)
        if(text !=  ""):
            self.add_text(x , y , text= text, font_size = math.ceil((r - 10) * 2 /3))
        self.canvas.update()
    
    def add_arrow(self, points):
        return self.canvas.create_line(points, width = self. width_stroke)
        
    def add_elliptical_arc(self,x, y, r1, r2, t0, t1, start_arrow=1, end_arrow=0):
        return self.canvas.create_arc(x-r1, y-r2, x+r1, y+r2, start=t0, extent=t1-t0, style='arc', width= self.width_stroke)

    def add_line(self, x1, y1, x2, y2, start_arrow=0, end_arrow=0, text = "s", font_size = 15):
        arrow_opts = start_arrow << 1 | end_arrow
        arrows = {0b10: 'first', 0b01: 'last', 0b11: 'both'}.get(arrow_opts, None)
        if(text !=  ""):
            self.add_text(x1 + (x2-x1)/2, y1 -(font_size/2), text= text, font_size = font_size)
        return self.canvas.create_line(x1, y1, x2, y2, width=self.width_stroke, arrow= arrows)

    def add_text(self, x, y, text, font_size = 15):
        return self.canvas.create_text(x, y, text=text, font=('bold', font_size))