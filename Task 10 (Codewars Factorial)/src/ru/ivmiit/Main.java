package ru.ivmiit;

/**
 * SPECIFICATION
 * In mathematics, the factorial of a non-negative integer n, denoted by n!,
 * is the product of all positive integers less than or equal to n.
 * For example: 5! = 5 * 4 * 3 * 2 * 1 = 120. By convention the value of 0! is 1.
 * Write a function to calculate factorial for a given input.
 * If input is below 0 or above 12 throw an exception of type
 * ArgumentOutOfRangeException (C#) or
 * IllegalArgumentException (Java) or
 * RangeException (PHP) or
 * throw a RangeError (JavaScript).
 *
 * @author Draqneel
 */
public class Main {

    public static void main(String[] args) {
    }

    /**
     * @param n the number from which we want to take factorial
     * @return factorial of n
     */
    public static int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException();
        }
        // equals:
        // if (n <= 1){
        //  return 1;
        // } else {
        //  return n * factorial(n - 1);
        // }
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}
