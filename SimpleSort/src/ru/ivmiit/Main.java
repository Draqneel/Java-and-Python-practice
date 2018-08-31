package ru.ivmiit;

public class Main {

    public static void main(String[] args) {       

    }

    public static void sort (int[] array){
        int max = array[0];
        int imax = 0;
        int temp;
        int ilast = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j + i < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    imax = j;
                }
            }
            temp = array[ilast];
            array[ilast] = max;
            array[imax] = temp;
            max = -1;
            ilast--;
        }
    }

}
