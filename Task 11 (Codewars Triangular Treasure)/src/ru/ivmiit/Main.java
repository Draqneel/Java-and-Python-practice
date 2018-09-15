package ru.ivmiit;

/**
 * Triangular numbers are so called because of the equilateral triangular
 * shape that they occupy when laid out as dots. i.e.
 * You need to return the nth triangular number. You should return 0 for out of range values:
 * all [
 * triangular 0     == 0,
 * triangular 2     == 3,
 * triangular 3     == 6,
 * triangular (-10) == 0
 * ] -- True
 *
 * @author Draqneel
 */
public class Main {

    public static void main(String[] args) {
    }

    /**
     * @param n - count of Strings
     * @return - count of stars
     */
    public static int triangular(int n) {
        int count = 0;
        int decriminator = n;
        if (n < 1) {
            return 0;
        }
        // counting stars and output on display
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < decriminator; j++) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            decriminator--;
        }
        return count;
    }
}
