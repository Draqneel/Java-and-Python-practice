package ru.ivmiit;

public class Main {

    public static void main(String[] args) {
    }

    public static String createPhoneNumber(int array[]) {
        if (array.length != 10) {
            return "Incorrect input";
        }
        char pattern[] = new char[14];
        int count = 0;
        String result = "";
        pattern[0] = '(';
        pattern[4] = ')';
        pattern[5] = ' ';
        pattern[9] = '-';
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

/* SPECIFICATION
* Write a function that accepts an array of 10 integers (between 0 and 9),
* that returns a string of those numbers in the form of a phone number.
* Example:
* Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
*/
