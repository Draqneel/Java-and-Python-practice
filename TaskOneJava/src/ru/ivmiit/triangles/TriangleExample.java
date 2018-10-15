package ru.ivmiit.triangles;

import ru.ivmiit.point.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * wiki: https://github.com/Draqneel/Java-and-Python-practice/wiki/Specification-fot-%22TaskOneJava%22-project
 * SPECIFICATION FOR TASK 2
 * We can add rectangles in collection
 * Rectangle automatic calculate sides, perimeter, area and type
 * With help "accouting" method output data in current template
 */
public class TriangleExample {
    public static void main(String[] args) {
        ArrayList<Triangle> list = new ArrayList<>(5);
        // add 1st triangle
        list.add(new Triangle(new Point(0, 4), new Point(0, 0), new Point(3, 0)));
        // add 2nd triangle
        System.out.println();
        list.add(new Triangle(new Point(3, 0), new Point(-3, 0), new Point(0, 7)));
        // add 3rd triangle
        System.out.println();
        list.add(new Triangle(new Point(3, 0), new Point(-3, 0), new Point(-5, 7)));
        // add 4th triangle
        System.out.println();
        list.add(new Triangle(new Point(3, 0), new Point(-3, 0), new Point(0, 10)));
        accounting(list);
    }

    public static void accounting(ArrayList<Triangle> list) {
        Triangle minInstance = getMax();
        Triangle maxInstance = getMin();
        List<Triangle> equiraterals = new ArrayList<>();
        List<Triangle> isosceles = new ArrayList<>();
        List<Triangle> rectangulars = new ArrayList<>();
        List<Triangle> arbitaries = new ArrayList<>();
        // sorting triangles for types
        for (Triangle triangle : list) {
            if (triangle.getType() == Type.EQUILATERAL) {
                equiraterals.add(triangle);
            } else if (triangle.getType() == Type.ISOSCELES) {
                isosceles.add(triangle);
            } else if (triangle.getType() == Type.RECTANGULAR) {
                rectangulars.add(triangle);
            } else {
                arbitaries.add(triangle);
            }
        }
        // output in correct form
        collectionsOutput(equiraterals);
        minInstance = getMax();
        maxInstance = getMin();

        collectionsOutput(isosceles);
        minInstance = getMax();
        maxInstance = getMin();

        collectionsOutput(rectangulars);
        minInstance = getMax();
        maxInstance = getMin();

        collectionsOutput(arbitaries);
        minInstance = getMax();
        maxInstance = getMin();
    }

    public static Triangle getMax() {
        return new Triangle(new Point(0, 11000), new Point(0, 0), new Point(10000, 0));
    }

    public static Triangle getMin() {
        return new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0));
    }

    public static void collectionsOutput(List<Triangle> list) {
        Triangle minInstance = getMax();
        Triangle maxInstance = getMin();
        for (Triangle triangle : list) {
            if (triangle.getS() < minInstance.getS()) {
                minInstance = triangle;
            }
            if (triangle.getS() > maxInstance.getS()) {
                maxInstance = triangle;
            }
        }
        if (list.size() > 0) {
            System.out.println(list.get(0).getType().toString() + "S:\n count: " + list.size() + "\n Max Area: " +
                    maxInstance.getS() + "\n Min Area: " + minInstance.getS());
        } else {
            System.err.println("Collection is empty");
        }
    }
}
