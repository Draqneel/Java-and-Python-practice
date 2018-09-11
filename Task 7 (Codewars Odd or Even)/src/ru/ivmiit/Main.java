package ru.ivmiit;

/**
 * Given an array of numbers (a list in groovy), determine whether the sum of all of the numbers is odd or even.
 * Give your answer in string format as 'odd' or 'even'.
 * If the input array is empty consider it as: [0] (array with a zero).
 *
 * @author Anton Tikhonov
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
    }

    /**
     * @param array
     * @return String - "odd" or "even" in the array dependency
     */
    public static String oddOrEven(int[] array) {
        int sum = 0;
        if (array == null) {
            return "even";
        } else {
            // sum all elements
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            // parity check
            if (sum % 2 == 0) {
                return "even";
            } else {
                return "odd";
            }
        }
    }
}
