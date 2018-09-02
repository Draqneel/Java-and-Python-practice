package ru.ivmiit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add 1st string");
        String a = scanner.nextLine();
        System.out.println("Add 2nd string");
        String b = scanner.nextLine();
        System.out.println(twoToOne(a, b));
    }

    public static String twoToOne(String a, String b) {
        final int MIN_VALUE = 97; // "a" in ASCII
        final int MAX_VALUE = 122; // "z" in ASCII
        final int MAX_ITERATION_COUNT = 26; // count of letters in ABC
        String string = a + b;
        String result = "";
        int test = MIN_VALUE;
        char[] array = string.toCharArray();
        for (int i = 0; i < MAX_ITERATION_COUNT; i++) {
            if (array[i] < MIN_VALUE || array[i] > MAX_VALUE) {
                return "incorrect string";
            }
            for (int j = 0; j < array.length; j++) {
                if (array[j] == test) {
                    result = result + array[j];
                    break;
                }
            }
            test++;
            if (test > MAX_VALUE) {
                break;
            }
        }
        return result;
    }
}

/* SPECIFICATION
* Take 2 strings s1 and s2 including only letters from ato z. Return a new sorted string, the longest possible,
* containing distinct letters,each taken only once - coming from s1 or s2.
* #Examples: ``` a = "xyaabbbccccdefww" b = "xxxxyyyyabklmopq" longest(a, b) -> "abcdefklmopqwxy"
*/