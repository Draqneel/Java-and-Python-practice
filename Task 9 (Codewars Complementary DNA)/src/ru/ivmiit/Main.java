package ru.ivmiit;

/**
 * SPECIFICATION
 * Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions"
 * for the development and functioning of living organisms.
 * If you want to know more http://en.wikipedia.org/wiki/DNA
 * In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).
 * DnaStrand.makeComplement("ATTGC") // return "TAACG"
 * DnaStrand.makeComplement("GTAT") // return "CATA"
 *
 * @author Draqneel
 */
public class Main {

    public static void main(String[] args) {
    }

    /**
     * @param dna - String with DNA code
     * @return - result - DNA after swapping
     */
    public static String makeComplement(String dna) {
        char[] arr = dna.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            /*
             * swapping loop:
             * 'A' <-> 'T'
             * 'C' <-> 'G'
             */
            switch (arr[i]) {
                case 'A': {
                    arr[i] = 'T';
                    break;
                }
                case 'T': {
                    arr[i] = 'A';
                    break;
                }
                case 'C': {
                    arr[i] = 'G';
                    break;
                }
                case 'G': {
                    arr[i] = 'C';
                    break;
                }
                default: {
                    return "error";
                }
            }
        }
        // build a String based on char array
        return new String(arr);
    }
}
