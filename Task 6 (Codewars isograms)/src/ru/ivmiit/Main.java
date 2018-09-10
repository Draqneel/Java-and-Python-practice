package ru.ivmiit;

/**
 * SPECIFICATION
 * An isogram is a word that has no repeating letters, consecutive or non-consecutive.
 * Implement a function that determines whether a string that contains only letters is an isogram.
 * Assume the empty string is an isogram. Ignore letter case.
 *
 * @author Anton Tikhonov
 * @version 1.0
 */

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(isIsogram("STRING"));
    }

    /**
     * @param str
     * @return boolean - is isogram or not
     */
    public static boolean isIsogram(String str) {
        char arr[] = str.toCharArray();
        Integer value;
        HashMap map = new HashMap();
        //Add ABC in HashMap
        for (int i = 65; i < 91; i++) {
            map.put((char) i, 0);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) {
                value = (int) map.get(arr[i]);
                value++;
                map.put(arr[i], value);
            } else {
                value = (int) map.get((char) (arr[i] - 32));
                value++;
                map.put((char) (arr[i] - 32), value);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if ((int) map.get(arr[i]) > 1) {
                return false;
            }
        }
        return true;
    }
}
