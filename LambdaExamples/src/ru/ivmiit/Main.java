package ru.ivmiit;

import java.util.ArrayList;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // Predicate<T> {boolean test(T value);}
        Predicate<Integer> isEven = x -> x % 2 == 0;
        // BinaryOperator<T> {R apply(T value1, U value2));}
        BinaryOperator<Double> mult = (x, y) -> x * y;
        // UnaryOperator<t> {R apply(T value);}
        UnaryOperator<Integer> unary = x -> x * 20;
        // Function<T, R> {R apply(T t);} p.s convert T->R
        Function<Integer, String> convert = x -> String.valueOf(x);
        // Consumer<T> {void accept(T t);}
        Consumer<String> printer = message -> System.out.println(message);
        // Supplier<T> {T get();}

        UnaryOperator<ArrayList<Integer>> bubbleSort = (ArrayList<Integer> arr) -> {
            int temp;
            for (int i = arr.size() - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr.get(j) > arr.get(j + 1)) {
                        temp = (int) arr.get(j + 1);
                        arr.set(j + 1, arr.get(j));
                        arr.set(j, temp);
                    }
                }
            }
            return arr;
        };

        /*
        BinaryOperator<Integer> binarySearch = (ArrayList<Integer> arr, Integer value) -> {
            int left = 0;
            int right = arr.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr.get(mid) == value) {
                    return mid;
                }
                if (arr.get(mid) > value) {
                    right = mid;
                }

                if (arr.get(mid) < value) {
                    left = mid;
                }
            }
            return -2;
        };

        BinaryOperator<Integer> binarySearchRec = (ArrayList<Integer> arr, int left, int right, int value) -> {
            // calculate index of middle element
            int mid = (left + right) / 2;
            // test on correct -2 - default error value
            if (left > right || arr.get(right) < value) {
                return -2;
            }
            // if value more then value with middle index - shift the border to the left
            if (arr.get(mid) > value) {
                return searchRec(arr, left, mid, value);
            }
            // if value more then value with middle index - shift the border to the right
            if (arr.get(mid) < value) {
                return searchRec(arr, mid, right, value);
            }
            if (arr.get(mid) == value) {
                return mid;
            }
            // return default value
            return -2;
        }
        */


        Operationable operation = (x, y) -> {
            return x + y;
        };

        System.out.println(operation.calculation(12, 13) + " - result of calculation lambda");
        System.out.println(isEven.test(12) + " - result of test 12 'is even?'");
        System.out.println(mult.apply(12.0, 3.4) + " - result of test multiply '12*3.4");
        System.out.println(unary.apply(10) + " - result of test multiply 10*20");
        System.out.println(convert.apply(100));
        printer.accept("Hello, world!");
        System.out.println(doubleSum(operation, 10, 12));
    }

    public static int doubleSum(Operationable o, int a, int b){
        return o.calculation(a, b) + o.calculation(b, a);
    }

}

interface Operationable {
    public int calculation(int x, int y);
}
