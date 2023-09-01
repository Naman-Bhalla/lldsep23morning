package com.scaler.numberprinter;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 10000000; i++) {
            if (i == 40) {
                System.out.println("Nandish");
            }
            NumberPrinter np = new NumberPrinter(i);
            Thread t = new Thread(np);
            t.start();
        }
    }
}
