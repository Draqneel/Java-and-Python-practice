package ru.ivmiit.point;


public class PointsCalc {
    /**
     * You can get distance between 2 points (length of vector)
     *
     * @param firstPoint
     * @param secondPoint
     * @return variable of double data type - distance
     */
    public double getDistance(Point firstPoint, Point secondPoint) {
        return Math.sqrt(Math.pow((firstPoint.getX() - secondPoint.getX()), 2) +
                Math.pow((firstPoint.getY() - secondPoint.getY()), 2));
    }

    public boolean isOnStraightLine(Point firstPoint, Point secondPoint, Point thirdPoind) {
        if ((thirdPoind.getX() - firstPoint.getX()) / (secondPoint.getX() - firstPoint.getX()) ==
                (thirdPoind.getY() - firstPoint.getY()) / (secondPoint.getY() - firstPoint.getY())) {
            return true;
        }
        return false;
    }
}