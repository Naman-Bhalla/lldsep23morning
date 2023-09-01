package com.scaler.helloworldprinter;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World from main " + Thread.currentThread().getName());

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
//        helloWorldPrinter.run();
        Thread t = new Thread(helloWorldPrinter);
        t.start();

        System.out.println("Hi from main " + Thread.currentThread().getName());
    }
}
