package ru.ivmiit;

import java.util.Scanner;

/**
 * Input
 * The first line contains an integer n (2 ≤ n ≤ 1 000).
 * The second line contains n integers within the range from 0 to 6,
 * which are the points monsters from “Oozma Kappa” will score.
 * The third line contains the points, monsters from “Roar Omega Roar” will score, written in the same manner.
 * Output
 * Output n lines, each containing integers oi and ri,
 * which are the numbers of monsters from “Oozma Kappa” and “Roar Omega Roar” respectively,
 * who should be called by the Dean to take part in the i-th challenge.
 * In each team monsters are numbered with integers from 1 to n in the order they appear in the input data.
 * If the problem has several solutions, output any of them
 *
 * @author Draqneel
 */
public class Main {

    public static void main(String[] args) {
        scarilyInteresting();
    }

    /**
     * Main method of Task
     */
    public static void scarilyInteresting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add N please");
        // read n
        int n = scanner.nextInt();
        // index of searching element
        int indexOne = 0;
        int indexTwo = 0;
        // counter of outputs
        int count = 0;
        // two flags - has or not value in 1st and 2nd array
        boolean flagOne = false;
        boolean flagTwo = false;
        // input arrays
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];
        // fill the 1st array
        for (int i = 0; i < n; i++) {
            System.out.println("Add " + (i + 1) + " element for 1st team");
            arrayOne[i] = scanner.nextInt();
        }
        // fill the 2nd array
        for (int i = 0; i < n; i++) {
            System.out.println("Add " + (i + 1) + " element for 2st team");
            arrayTwo[i] = scanner.nextInt();
        }
        // searching and output equals elements
        for (int i = 6; i >= 0; i--) {
            // if count of outputs equals n - break the llop
            if (count == n) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (arrayOne[j] == i) {
                    flagOne = true;
                    indexOne = j;
                }
                if (arrayTwo[j] == i) {
                    flagTwo = true;
                    indexTwo = j;
                }
            }
            // if an element was found in two arrays - output the couple
            if (flagOne == true && flagTwo == true) {
                System.out.println((indexOne + 1) + " " + (indexTwo + 1));
                count++;
                arrayOne[indexOne] = -1;
                arrayTwo[indexTwo] = -1;
            }
            flagOne = false;
            flagTwo = false;
        }
        // output another couples
        for (int i = 0; i < n - count; i++) {
            for (int j = 0; j < arrayOne.length; j++) {
                if (arrayOne[j] != -1) {
                    for (int k = 0; k < arrayTwo.length; k++) {
                        if (arrayTwo[k] != -1) {
                            System.out.println((j + 1) + " " + (k + 1));
                        }
                    }
                }
            }
        }
    }
}
