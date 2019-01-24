package ru.ivmiit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        SomeClass someClass = new SomeClass("Hello, John");
        // Ways to get Class class:
        // method getClass, static variable class, load class by path
        Class clss = someClass.getClass();
        Class clss2 = SomeClass.class;
        Class clss3 = Class.forName("ru.ivmiit.SomeClass");
        // create class without "new"
        SomeClass someClass1 = (SomeClass) clss.newInstance();
        // get methods/constructors
        Constructor[] constructors = clss.getConstructors();
        Constructor[] decConstructors = clss.getDeclaredConstructors();
        Method[] methods = clss.getMethods();
        Method[] decMethods = clss.getDeclaredMethods();

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
    String s;

    SomeClass() {
    }

    SomeClass(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}