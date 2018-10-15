package ru.ivmiit.point;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString() {
        return "The coordinates of this point: (" + x + " ; " + y + ")";
    }

    public double getDistanceToZero() {
        return Math.sqrt(x * x + y * y);
    }


}
