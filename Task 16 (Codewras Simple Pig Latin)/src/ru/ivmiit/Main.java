package ru.ivmiit;

/**
 * SPECIFICATION
 * Move the first letter of each word to the end of it,
 * then add "ay" to the end of the word.
 * Leave punctuation marks untouched.
 * Examples
 * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
 * pigIt('Hello world !'); // elloHay orldway !
 */
public class Main {

    public static void main(String[] args) {
    }

    /**
     * Main method
     * @param str - input String
     * @return input String after transformation
     */
    public static String pigIt(String str) {
        // split the String by " " in Strings array
        String[] words = str.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < 2) {
                result += words[i];
                continue;
            }
            if (words[i].endsWith(",")) {
                words[i] = words[i].replaceAll(",", "");
                result += words[i].substring(1, words[i].length()) + words[i].substring(0, 1) + "ay" + ",";
            } else {
                result += words[i].substring(1, words[i].length()) + words[i].substring(0, 1) + "ay";
            }
            if (i != (words.length - 1)) {
                result += " ";
            }
        }
        return result;
    }
}
