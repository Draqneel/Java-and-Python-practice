package ru.ivmiit;

/**
 * Access modifier is Contravariance
 * Expected data type and exceptions are Covariant
 * Signature of method and static/no-static is Invariance
 */
public class Main {

    public static void main(String[] args) {
        Parent child = new Child();
        System.out.println(child.method());
    }

}

class Parent{
    protected Number method(){
        return 100;
    }
}

class Child extends Parent {
    @Override
    public Integer method(){
        return 10;
    }
}
