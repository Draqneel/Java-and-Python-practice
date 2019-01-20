package ru.ivmiit;

/**
 * assert() in Java - inspection mechanism
 * in default parameter "-enableassertions (-ea)" switched off
 * but we can turn it on when we pass .class file in JVM
 * <code>java -ea Main</code>
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.method(-100));
    }

    /**
     * Let's pretend that input value must be > 0:
     *
     * @param value - input value
     */
    private int method(int value) {
        assert (value > 0);
        // some kind of business logic
        return value;
    }
}
