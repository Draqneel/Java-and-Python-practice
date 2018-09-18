package ru.ivmiit;

/**
 * SPECIFICATION
 * Write a function that accepts a string, and returns true if it is in the form of a phone number
 * Assume that any integer from 0-9 in any of the spots will produce a valid phone number.
 * Only worry about the following format
 * (123) 456-7890 (don't forget the space after the close parentheses)
 *
 * @author Draqneel
 */
public class Main {

    public static void main(String[] args) {
    }

    /**
     * method to find out whether the phone is correct or not
     *
     * @param phoneNumber - input String
     * @return boolean variable - correct or not
     */
    public static boolean validPhoneNumber(String phoneNumber) {
        // TODO: Return whether phoneNumber is in the proper form
        if (phoneNumber.length() != 14) {
            return false;
        }
        char number[] = phoneNumber.toCharArray();
        for (int i = 0; i < number.length; i++) {
            if (number[0] != '(') {
                return false;
            } else if (number[4] != ')') {
                return false;
            } else if (number[5] != ' ') {
                return false;
            } else if (number[9] != '-') {
                return false;
            } else if (i != 0 && i != 4 && i != 5 && i != 9) {
                if (number[i] > 57 || number[i] < 48) {
                    return false;
                }
            }
        }
        return true;
    }
}
