package ru.ivmiit;

/**
 * Ask: Which method will be called first?
 * Answer: https://github.com/Draqneel/Java-and-Python-practice/wiki/Overload-method-(deep-level)
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        short v = 10;
        main.method(v);
    }

    public void method(int v){
        System.out.println("int");
    }

    public void method(Object v){
        System.out.println("Object");
    }

    public void method(long v){
        System.out.println("long");
    }

    public void method(double v){
        System.out.println("double");
    }

    public void method(Short v){
        System.out.println("Short");
    }

    public void method(short v){
        System.out.println("short");
    }

    public void method(Integer v){
        System.out.println("Integer");
    }

    public void method(Object... v){
        System.out.println("Object...");
    }

    public void method(short... v){
        System.out.println("short...");
    }

    public void method(Short... v){
        System.out.println("Short...");
    }

    public void method(byte v){
        System.out.println("byte");
    }
}
