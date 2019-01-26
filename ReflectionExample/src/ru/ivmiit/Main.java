package ru.ivmiit;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        SomeClass someClass = new SomeClass();
        // Ways to get Class class:
        // method getClass, static variable class, load class by path
        Class clss = someClass.getClass();
        Class clss2 = SomeClass.class;
        Class clss3 = Class.forName("ru.ivmiit.SomeClass");
        // create class without "new"
        SomeClass someClass1 = (SomeClass) clss.newInstance();
        // get methods/constructors
        Constructor[] constructors = clss.getDeclaredConstructors();
        Method[] methods = clss.getDeclaredMethods();
        System.out.println("methods:");
        for (Method method: methods){
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getName());
        }
        System.out.println();
        System.out.println("fields:");
        Field[] fields = clss.getDeclaredFields();
        for(Field field: fields){
            System.out.println(field.getName());
            System.out.println(field.getType().getName());
            System.out.println(Modifier.toString(field.getModifiers()));
            field.setAccessible(true);
            System.out.println(field.getInt(clss));
        }
//        Constructor[] decConstructors = clss.getDeclaredConstructors();
//        Method[] methods = clss.getMethods();
//        Method[] decMethods = clss.getDeclaredMethods();

        System.out.println("constructors:");
        for (Constructor c : constructors) {
            System.out.println(c.getName());
            Parameter[] parameters = c.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
        }
    }
}

class SomeClass {
    private static transient int i;
//    String s;

    SomeClass() {
    }

//    SomeClass(String s) {
//        this.s = s;
//    }
//
//    public String getI() {
//        return s;
//    }

    public synchronized void newMetod(){
        System.out.println("some method");
    }
}