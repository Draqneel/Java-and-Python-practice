package ru.ivmiit.quads;

import ru.ivmiit.point.Point;
import ru.ivmiit.point.PointsCalc;

public class Quad {
    private Point vertexOne;
    private Point vertexTwo;
    private Point vertexThree;
    private Point vertexFour;
    private double sideOne;
    private double sideTwo;
    private double sideThree;
    private double sideFour;
    private double P;
    private double S;
    private double dOne;
    private double dTwo;
    private Type type;
    private PointsCalc calc = new PointsCalc();

    public Quad(Point vertexOne, Point vertexTwo, Point vertexThree, Point vertexFour) {
        this.vertexOne = vertexOne;
        this.vertexTwo = vertexTwo;
        this.vertexThree = vertexThree;
        this.vertexFour = vertexFour;
        // identity vertexes
        sideOne = calc.getDistance(vertexOne, vertexTwo);
        sideTwo = calc.getDistance(vertexTwo, vertexThree);
        sideThree = calc.getDistance(vertexThree, vertexFour);
        sideFour = calc.getDistance(vertexFour, vertexOne);
        dOne = calc.getDistance(vertexOne, vertexThree);
        dTwo = calc.getDistance(vertexTwo, vertexThree);
        // calculate perimeter and area
        P = sideOne + sideTwo + sideThree + sideFour;
        S = Math.sqrt((P / 2 - sideOne) * (P / 2 - sideTwo) * (P / 2 - sideThree) * (P / 2 - sideFour));
        // identity type
        if (sideOne == sideTwo && sideOne == sideThree && sideOne == sideFour && dOne == dTwo) {
            type = Type.SQUARE;
        } else if (sideOne == sideTwo && sideOne == sideThree && sideOne == sideFour && dOne != dTwo) {
            type = Type.RHOMBUS;
        } else if (sideOne == sideThree && sideTwo == sideFour && dOne == dTwo) {
            type = Type.RECTANGLE;
        } else if (sideOne == sideThree && sideTwo == sideFour && dOne != dTwo) {
            type = Type.PARALLELOGRAM;
        } else if ((((sideOne == sideThree) && (sideTwo != sideFour)) ||
                ((sideTwo == sideFour) && (sideOne != sideThree))) && dOne == dTwo) {
            type = Type.ISOSCELES_TRAPEZIUM;
        } else {
            type = Type.ARBITARY;
        }
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

    public Point getVertexFour() {
        return vertexFour;
    }

    public void setVertexFour(Point vertexFour) {
        this.vertexFour = vertexFour;
    }
}
