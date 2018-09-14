package ru.ivmiit;

/**
 * SPECIFICATION
 * Write a function that accepts an array of 10 integers (between 0 and 9),
 * that returns a string of those numbers in the form of a phone number.
 * Example:
 * Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
 *
 * @author Draqneel
 */
public class Main {

    public static void main(String[] args) {
    }

    /**
     * @param array - input data
     * @return String - data in the required form (phone number)
     */
    public static String createPhoneNumber(int array[]) {
        final int LENGTH_OF_PHONE_NUMBER = 14;
        if (array.length != 10) {
            return "Incorrect input";
        }
        char pattern[] = new char[LENGTH_OF_PHONE_NUMBER];
        int count = 0;
        String result = "";
        pattern[0] = '(';
        pattern[4] = ')';
        pattern[5] = ' ';
        pattern[9] = '-';
        // fill result the String with the required data
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] != 0) {
                result = result + pattern[i];
            } else {
                result = result + array[count];
                count++;
            }
        }
        return result;
    }
}