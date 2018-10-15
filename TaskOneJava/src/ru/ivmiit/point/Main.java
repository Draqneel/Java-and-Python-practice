package ru.ivmiit.point;

/**
 * wiki: https://github.com/Draqneel/Java-and-Python-practice/wiki/Specification-fot-%22TaskOneJava%22-project
 * SPECIFICATION FOR TASK 1
 * working with Point and PointCalc classes
 * we can add points,
 * calculate distance between points,
 * get distance from each points to "zero",
 * are 3 points on the straight or not.
 */
public class Main {

    public static void main(String[] args) {
        Point pointOne = new Point(0, 4);
        Point pointTwo = new Point(0, 0);
        Point pointThree = new Point(3, 0);
        PointsCalc calc = new PointsCalc();
        System.out.println(pointOne.toString());
        System.out.println("Distance to zero from 1st point: " + pointOne.getDistanceToZero());
        System.out.println(pointTwo.toString());
        System.out.println("Distance to zero from 2nd point: " + pointTwo.getDistanceToZero());
        System.out.println("Distance between two points is " + calc.getDistance(pointOne, pointTwo));
        System.out.println("Are on the straight? (p1, p2, p3) - " + calc.isOnStraightLine(pointOne, pointThree, pointTwo));
    }
}
