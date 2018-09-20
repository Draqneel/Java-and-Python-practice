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
        // write your code here
        scarilyInteresting();
    }

    public static void scarilyInteresting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add N please");
        int n = scanner.nextInt();
        int indexOne = 0;
        int indexTwo = 0;
        int count = 0;
        boolean flagOne = false;
        boolean flagTwo = false;
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Add " + (i + 1) + " element for 1st team");
            arrayOne[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Add " + (i + 1) + " element for 2st team");
            arrayTwo[i] = scanner.nextInt();
        }
        for (int i = 6; i >= 0; i--) {
            if (count == n) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (arrayOne[j] == i) {
                    flagOne = true;
                    indexOne = j + 1;
                }
                if (arrayTwo[j] == i) {
                    flagTwo = true;
                    indexTwo = j + 1;
                }
            }
            if (flagOne == true && flagTwo == true) {
                System.out.println(indexOne + " " + indexTwo);
                count++;
            }
            flagOne = false;
            flagTwo = false;
        }
    }
}
