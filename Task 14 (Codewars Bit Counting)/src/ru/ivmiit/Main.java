package ru.ivmiit;

/**
 * SPECIFICATION
 * Write a function that takes an (unsigned) integer as input,
 * and returns the number of bits that are equal to one in the binary representation of that number and print that.
 * Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
 *
 * @author Draqneel
 */
public class Main {

    public static void main(String[] args) {
    }

    /**
     * Function counting "1" in binary code of decimal value
     *
     * @param value - decimal value
     * @return int value - count of "1"
     */
    public static int bitCounter(int value) {
        int exp = 0;
        int bit = 0;
        // find max exponent of 2 non-primary value
        while (Math.pow(2, exp) <= value) {
            exp++;
        }
        boolean arr[] = new boolean[exp];
        exp--;
        int i = 0;
        // translate in binary code and counting "1"
        while (value > 0) {
            if ((value - Math.pow(2, exp)) >= 0) {
                value = (int) (value - Math.pow(2, exp));
                bit++;
                arr[i] = true;
            }
            i++;
            exp--;
        }
        // print in command line
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == true) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        System.out.println();
        return bit;
    }

}
