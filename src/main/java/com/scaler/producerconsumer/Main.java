package com.scaler.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        Store store = new Store(5);

        for (int i = 0; i < 3; ++i) {
            Producer p = new Producer(store, i + 1);
            es.execute(p);
        }

        for (int i = 0; i < 100; ++i) {
            Consumer c = new Consumer(store, i + 1);
            es.execute(c);
        }
    }
}
