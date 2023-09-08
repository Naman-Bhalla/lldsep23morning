package com.scaler.prodconssema;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        int maxSlotsInStore = 5;

        Store store = new Store(maxSlotsInStore);
        Semaphore prodSemaphore = new Semaphore(maxSlotsInStore);
        Semaphore consSemaphore = new Semaphore(0);

        for (int i = 0; i < 3; ++i) {
            Producer p = new Producer(store, i + 1, prodSemaphore, consSemaphore);
            es.execute(p);
        }

        for (int i = 0; i < 100; ++i) {
            Consumer c = new Consumer(store, i + 1, prodSemaphore, consSemaphore);
            es.execute(c);
        }
    }
}
