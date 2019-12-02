package proyecto3d;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Container {

    private Turtle fabi;
    private int level;

    public Container(int level) {
        this.level = level;
        init();
    }

    public void init() {
        JMenuItem menuItem1 = new JMenuItem("Seleccionar");
        menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                level = fabi.getNumber();
                close();
                Turtle.setActiion(menuItem1);
                fabi = new Turtle(-300, -260);
                createTriangle(level, new Point(-300, -260), new Point(300, -260), new Point(0, 260));
            }
        });
        Turtle.setActiion(menuItem1);
        Turtle.setCanvasSize(700, 700);
        fabi = new Turtle(-300, -260);
        createTriangle(level, new Point(-300, -260), new Point(300, -260), new Point(0, 260));
    }

    public void close() {
        fabi.setPosition(-300, -260);
        fabi.clear();
        Turtle.update();
        fabi.exit();
    }

    public void createTriangle(int level, Point firstPoint, Point secondPoint, Point thirdPoint) {
        if (level <= 0) {
            fabi.penColor(Color.white);
            fabi.setPosition(firstPoint.x, firstPoint.y);
            fabi.penColor(Color.red);
            fabi.setPosition(secondPoint.x, secondPoint.y);
            fabi.setPosition(thirdPoint.x, thirdPoint.y);
            fabi.setPosition(firstPoint.x, firstPoint.y);
            fabi.setPosition(secondPoint.x, secondPoint.y);
            Turtle.update();

        } else {
            double deltaX1 = (secondPoint.x + firstPoint.x) / 2;
            double deltaY1 = (secondPoint.y + firstPoint.y) / 2;

            double deltaX2 = (thirdPoint.x + secondPoint.x) / 2;
            double deltaY2 = (thirdPoint.y + secondPoint.y) / 2;

            double deltaX3 = (firstPoint.x + thirdPoint.x) / 2;
            double deltaY3 = (firstPoint.y + thirdPoint.y) / 2;
            createTriangle(level - 1, new Point((secondPoint.x), (secondPoint.y)), new Point((deltaX2), (deltaY2)), new Point((deltaX1), (deltaY1)));
            createTriangle(level - 1, new Point((thirdPoint.x), (thirdPoint.y)), new Point((deltaX3), (deltaY3)), new Point((deltaX2), (deltaY2)));
            createTriangle(level - 1, new Point((firstPoint.x), (firstPoint.y)), new Point((deltaX1), (deltaY1)), new Point((deltaX3), (deltaY3)));
        }

    }

    private class Point {

        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

}
