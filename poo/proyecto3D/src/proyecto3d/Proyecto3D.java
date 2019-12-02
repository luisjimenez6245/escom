/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3d;

/**
 *
 * @author luis
 */
public class Proyecto3D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Proyecto3D();
    }

    private final Turtle bob;

    public Proyecto3D() {
        Turtle.setCanvasSize(700, 700);
        bob = new Turtle(-300, -260);

        createTriangle(3, new Point(-300, -260), new Point(300, -260), new Point(0, 260));
    }

    public void createTriangle(int level, Point firstPoint, Point secondPoint, Point thirdPoint) {
        double deltaX1 = (secondPoint.x + firstPoint.x) / 2;
        double deltaY1 = (secondPoint.y + firstPoint.y) / 2;

        double deltaX2 = (thirdPoint.x + secondPoint.x) / 2;
        double deltaY2 = (thirdPoint.y + secondPoint.y) / 2;

        double deltaX3 = (firstPoint.x + thirdPoint.x) / 2;
        double deltaY3 = (firstPoint.y + thirdPoint.y) / 2;

        if (level <= 0) {
            bob.setPosition(firstPoint.x, firstPoint.y);
            bob.setPosition(secondPoint.x, secondPoint.y);
            bob.setPosition(thirdPoint.x, thirdPoint.y);
            bob.setPosition(firstPoint.x, firstPoint.y);
        } else {
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
