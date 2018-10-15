package ru.ivmiit.triangles;

import ru.ivmiit.point.Point;
import ru.ivmiit.point.PointsCalc;

public class Triangle {
    private Point vertexOne;
    private Point vertexTwo;
    private Point vertexThree;
    private double sideOne;
    private double sideTwo;
    private double sideThree;
    private double P;
    private double S;
    private Type type;
    private PointsCalc calc = new PointsCalc();

    public Triangle(Point vertexOne, Point vertexTwo, Point vertexThree) {
        // identity vertexes
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
        this.vertexThree = vertexThree;
        // calculation sides
        sideOne = calc.getDistance(vertexOne, vertexTwo);
        sideTwo = calc.getDistance(vertexOne, vertexThree);
        sideThree = calc.getDistance(vertexTwo, vertexThree);
        // calculation perimeter
        P = sideOne + sideTwo + sideThree;
        // Heron's formula (calc area)
        S = Math.sqrt(P / 2.0 * (P / 2.0 - sideOne) * (P / 2.0 - sideTwo) * (P / 2.0 - sideThree));
        // searching type
        if (sideOne == sideTwo && sideOne == sideThree && sideTwo == sideThree) {
            type = Type.EQUILATERAL;
        } else if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree) {
            type = Type.ISOSCELES;
        } else if ((Math.sqrt(sideOne * sideOne + sideTwo * sideTwo) == sideThree) ||
                (Math.sqrt(sideTwo * sideTwo + sideThree * sideThree) == sideOne) ||
                (Math.sqrt(sideOne * sideOne + sideThree * sideThree) == sideTwo)) {
            type = Type.RECTANGULAR;
        } else {
            type = Type.ARBITARY;
        }
    }


    public Point getVertexOne() {
        return vertexOne;
    }

    public void setVertexOne(Point vertexOne) {
        this.vertexOne = vertexOne;
    }

    public Point getVertexTwo() {
        return vertexTwo;
    }

    public void setVertexTwo(Point vertexTwo) {
        this.vertexTwo = vertexTwo;
    }

    public Point getVertexThree() {
        return vertexThree;
    }

    public void setVertexThree(Point vertexThree) {
        this.vertexThree = vertexThree;
    }

    public double getP() {
        return P;
    }

    public double getS() {
        return S;
    }

    public Type getType() {
        return type;
    }

    public String toString() {
        return "This triangle is :\n " + type.toString() + "\n area: " + S +
                "\n perimeter: " + P + "\n and sides: " + sideOne + " " + sideTwo + " " + sideThree;
    }
}
