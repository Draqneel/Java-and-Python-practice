package ru.ivmiit;

public class Main {

    public static void main(String[] args) {
    }

    public static int findOutlier (int[] array){
        boolean isEven = isEven(array);
        if (isEven == true) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 != 0){
                    return array[i];
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0){
                    return array[i];
                }
            }
        }
        return 0;
    }

    public static boolean isEven(int[] array){
        int countEven = 0;
        int countOdd = 0;
        for (int i = 0; i < 3; i++) {
            if(array[i] % 2 == 0){
                countEven++;
            } else {
                countOdd++;
            }
        }
        if (countEven > countOdd) {
            return true;
        }
        return false;
    }
}
/* SPECIFICATION
* You are given an array (which will have a length of at least 3, but could be very large) containing integers.
* The array is either entirely comprised of odd integers or entirely comprised of even integers except
* for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
 */