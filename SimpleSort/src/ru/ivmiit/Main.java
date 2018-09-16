package ru.ivmiit;

/**
 * SPECIFICATION
 * wiki: https://en.wikipedia.org/wiki/Selection_sort
 *
 * @author Draqneel
 */
public class Main {

    public static void main(String[] args) {       

    }

    public static void sort (int[] array){
        int max = array[0];
        int imax = 0;
        int temp;
        int ilast = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            // find max value in array
            for (int j = 0; j + i < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    imax = j;
                }
            }
            // swap max value with last element
            temp = array[ilast];
            array[ilast] = max;
            array[imax] = temp;
            max = -1;
            ilast--;
        }
    }

}
