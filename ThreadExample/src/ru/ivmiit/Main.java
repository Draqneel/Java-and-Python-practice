package ru.ivmiit;

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
    public void run(){
        System.out.println("1st thread was born");
    }
}

class SecondCreatingWay implements Runnable {
    @Override
    public void run() {
        System.out.println("2nd thread was born");
    }
}
