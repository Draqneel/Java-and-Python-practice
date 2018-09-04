package ru.ivmiit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(trollFunc(input));
    }

    public static String trollFunc(String string) {
        char array[] = string.toCharArray();
        int highRegister = 65;
        int lowRegister = 97;
        int count = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == highRegister || array[j] == lowRegister) {
                    array[j] = 0;
                }
            }
            if (i >= 2) {
                lowRegister += 6;
                highRegister += 6;
            } else {
                lowRegister += 4;
                highRegister += 4;
            }
        }
        return toString(array);
    }

    public static String toString(char[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }
            result += array[i];
        }
        return result;
    }
}

/*
 *Trolls are attacking your comment section!
 *
 *A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat.
 *
 *Your task is to write a function that takes a string and return a new string with all vowels removed.
 *
 *For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
 */
