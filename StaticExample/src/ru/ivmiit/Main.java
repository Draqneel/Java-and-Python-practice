package ru.ivmiit;

/**
 * Documentation:
 * https://github.com/Draqneel/Java-and-Python-practice/wiki/Static---Non-Static
 */

public class Main {

    public static void main(String[] args) {
        System.out.println(StaticClass.i);
        System.out.println(new StaticClass(10,15).j);
    }

    static class StaticClass {
        static int i;
        int j;
        int x;
        int n;

        static {
            System.out.println("Static init");
        }

        {
            System.out.println("non-static init");
        }

        StaticClass(int j, int x, int n) {
            this.j = j;
            this.x = x;
            this.n = n;
            System.out.println("Constructor");
        }

        StaticClass() {
            this(0, 0, 0);
        }

        StaticClass(int x) {
            this(0, x, 0);
        }

        StaticClass(int j, int n) {
            this(j, 0, n);
        }
    }
}
