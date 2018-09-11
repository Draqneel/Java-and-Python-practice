package ru.ivmiit;

/**
 * SPECIFICATION
 * Consecutive strings
 * You are given an array strarr of strings and an integer k.
 * Your task is to return the first longest string consisting of k consecutive strings taken in the array.
 * #Example: longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2)
 * --> "abigailtheta"
 * n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
 *
 * @author Draqneel
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
    }

    /**
     * @param strarr - array of String
     * @param k      - count of strings for 'gluing'
     * @return string - longest 'glued' words
     */
    public static String longestConsec(String[] strarr, int k) {
        String result = "";
        int length = 0;
        int count = 0;
        // test for correctness of input
        if (k > strarr.length) {
            System.err.println("Incorrect input");
        } else {
            // find length of longest string(s)
            for (int i = 0; i < strarr.length; i++) {
                if (strarr[i].length() > length) {
                    length = strarr[i].length();
                }
            }
            while (count < k) {
                for (int i = 0; i < strarr.length; i++) {
                    if (strarr[i].length() == length) {
                        result += strarr[i];
                        count++;
                        // if count of words in result string
                        // equals "k" - break our loop
                        if (count == k) {
                            break;
                        }
                    }
                }
                // length of word can't be less then zero
                if (length == 0) {
                    break;
                } else {
                    length--;
                }
            }
        }
        return result;
    }
}
