package ru.ivmiit;

/**
 * Documentation:
 * https://github.com/Draqneel/Java-and-Python-practice/wiki/Static---Non-Static
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(StaticClass.i);
        System.out.println(new StaticClass().j);
    }

    static class StaticClass {
        static int i;
        int j = 5;

        static {
            System.out.println("Static init");
        }

        {
            System.out.println("non-static init");
        }

        StaticClass() {
            System.out.println("Constructor");
        }
    }
}
