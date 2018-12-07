package ru.ivmiit;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {
    // Predicate<T> {boolean test(T value);}
    Predicate<Integer> isEven = x -> x % 2 == 0;
    // BinaryOperator<T> {R apply(T value1, U value2));}
    BinaryOperator<Double> mult = (x,y) -> x * y;
    // UnaryOperator<t> {R apply(T value);}
    UnaryOperator<Integer> unary = x -> x * 20;
    // Function<T, R> {R apply(T t);} p.s convert T->R
    Function<Integer, String> convert = x -> String.valueOf(x);
    // Consumer<T> {void accept(T t);}
    Consumer<String> printer = message -> System.out.println(message);
    // Supplier<T> {T get();}


        Operationable operation = (x, y) -> {
	       return x + y;
        };

        System.out.println(operation.calculation(12, 13) + " - result of calculation lambda");
        System.out.println(isEven.test(12) + " - result of test 12 'is even?'");
        System.out.println(mult.apply(12.0, 3.4) + " - result of test multiply '12*3.4");
        System.out.println(unary.apply(10) + " - result of test multiply 10*20");
        System.out.println(convert.apply(100));
        printer.accept("Hello, world!");
    }

}

interface Operationable {
    public int calculation(int x, int y);
}
