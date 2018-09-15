package ru.ivmiit;

/**
 * SPECIFICATION
 * In input function get 2 params:
 * width and length of rectangle
 * Output - list of max values of whose area
 * is contained in the square
 *
 * @author Draqneel
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
    }

    /**
     * @param lng  - length
     * @param wdth - width
     * @return Linked list od values
     */
    public static List<Integer> sqInRect(int lng, int wdth) {
        List<Integer> list = new LinkedList();
        int freeArea = lng * wdth;
        int currentSquare = 1;
        while (freeArea > 0) {
            // find max square
            while (Math.pow((currentSquare + 1), 2) <= freeArea) {
                currentSquare++;
            }
            // add value
            list.add(currentSquare);
            // reduce area
            freeArea -= Math.pow(currentSquare, 2);
            // return to default value
            currentSquare = 1;
        }
        return list;
    }
}
