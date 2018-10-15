package ru.ivmiit.quads;

import ru.ivmiit.point.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuadExample {
    /**
     * wiki: https://github.com/Draqneel/Java-and-Python-practice/wiki/Specification-fot-%22TaskOneJava%22-project
     * SPECIFICATION FOR TASK 2
     * We can add quads in collection
     * Quad automatic calculate sides, perimeter, area, diagonals and type
     * With help "main" method output data in current template
     */
    public static void main(String[] args) {
        List<Type> typesList = new LinkedList<>();
        double maxArea = 0;
        int count = 0;
        typesList.add(Type.ARBITARY);
        typesList.add(Type.ISOSCELES_TRAPEZIUM);
        typesList.add(Type.PARALLELOGRAM);
        typesList.add(Type.RECTANGLE);
        typesList.add(Type.RHOMBUS);
        typesList.add(Type.SQUARE);

        List<Quad> list = new ArrayList<>();
        list.add(new Quad(new Point(-2, 2), new Point(2, 2), new Point(2, -2), new Point(-2, 2)));
        list.add(new Quad(new Point(-2, 0), new Point(0, 4), new Point(2, 0), new Point(0, -4)));
        list.add(new Quad(new Point(-2, 2), new Point(4, 2), new Point(2, -2), new Point(-4, 2)));
        list.add(new Quad(new Point(-2, 2), new Point(4, 2), new Point(4, -2), new Point(-2, -2)));

        for (Type type : typesList) {
            System.out.print(type.toString() + " ");
            for (Quad quad : list) {
                if (quad.getType() == type) {
                    count++;
                }
                if ((quad.getS() > maxArea) && (quad.getType() == type)) {
                    maxArea = quad.getS();
                }
            }
            System.out.println("Count: " + count + " max area: " + maxArea);
            maxArea = 0;
            count = 0;
        }
    }
}
