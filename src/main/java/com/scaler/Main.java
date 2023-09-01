package com.scaler;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static void doSomething() {
        int c = 20;
        int d = 41;

        System.out.println("Hi " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 13;
        System.out.println("Hello World " + Thread.currentThread().getName());

        doSomething();
    }
}