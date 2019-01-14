package ru.ivmiit;

/**
 * We have two ways co create a thread:
 * 1) Create new class that extends class "Thread"
 * 2) Create new class that implements method runnable, than create instance of Thread class and transfer new class
 * in constructor.
 * <p>
 * The way to start project only one - call of start() method (we can't do it twice). After finish thread was "dead".
 * Threads contains in pull and called by random.
 *
 * Thread.sleep(int ms) - thread proceed from Running statement into Sleeping for ms (millisecond);
 */

public class Main {

    public static void main(String[] args) {
        FirstCreatingWay threadOne = new FirstCreatingWay();
        Thread threadTwo = new Thread(new SecondCreatingWay());
        threadOne.start();
        threadTwo.start();
    }
}

class FirstCreatingWay extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1st thread was born");
    }
}

class SecondCreatingWay implements Runnable {
    @Override
    public void run() {
        System.out.println("2nd thread was born");
    }
}

