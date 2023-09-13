package com.scaler.prodconssemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        ExecutorService es = Executors.newCachedThreadPool();
        Semaphore prodSemaphore = new Semaphore(5);
        Semaphore consSemaphore = new Semaphore(0);

        for (int i = 1; i <= 10; ++i) {
            Producer producer = new Producer(store, prodSemaphore, consSemaphore, i);
            es.execute(producer);
        }

        for (int i = 1; i <= 20; ++i) {
            Consumer consumer = new Consumer(store, prodSemaphore, consSemaphore, i);
            es.execute(consumer);
        }
    }
}
