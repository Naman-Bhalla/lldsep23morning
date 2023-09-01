package com.scaler.numberprinterthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 1000; i++) {
            if (i == 800) {
                System.out.println("Nandish");
            }
            NumberPrinter np = new NumberPrinter(i);
//            Thread t = new Thread(np);
//            t.start();

            executorService.execute(np);
        }
    }
}
