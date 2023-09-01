package com.scaler.helloworldprinter;

public class HelloWorldPrinter implements Runnable {

    private void doSomething() {
        System.out.println("Hi from HWP " + Thread.currentThread().getName());
    }

//    @Override
    public void run() {
        System.out.println("Hello World from HWP " + Thread.currentThread().getName());
        doSomething();
    }
}
