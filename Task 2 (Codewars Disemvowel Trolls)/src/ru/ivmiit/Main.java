package ru.ivmiit;

/**
 * SPECIFICATION
 * Trolls are attacking your comment section!
 * A common way to deal with this situation is to remove all of the vowels from the trolls' comments, neutralizing the threat.
 * Your task is to write a function that takes a string and return a new string with all vowels removed.
 * For example, the string "This website is for losers LOL!" would become "Ths wbst s fr lsrs LL!".
 *
 * @author Draneel
 */

public class Main {

    public static void main(String[] args) {
    }

    /**
     * @param string - input String
     * @return String without vowels letters
     */
    public static String trollFunc(String string) {
        char array[] = string.toCharArray();
        int highRegister = 65;
        int lowRegister = 97;
        int count = 1;
        // loop from 0 to 4 because english ABC have 5 vowels letters
        // if char is vowel - appointment by zero
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == highRegister || array[j] == lowRegister) {
                    array[j] = 0;
                }
            }
            // 6 or 4 - distance between vowel letters in ASCII
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

    /**
     * @param array - input array
     * @return String - excluding chars equal to zero (vowel chars)
     */
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

