package com.scaler.prodconssema;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Store store;
    private int producerNUmber;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Producer(Store store, int producerNUmber, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.producerNUmber = producerNUmber;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() { // ps = [1 2 3 4 -] store = [1 - - - -]
        while (true) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Producing an item by producer #: " + producerNUmber);
            try {
//                store.setItemsCount(store.getItemsCount() + 1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            consumerSemaphore.release();
        }
    }
}
