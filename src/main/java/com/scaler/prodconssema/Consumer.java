package com.scaler.prodconssema;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Store store;
    private int consumerNumber;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumer(Store store, int consumerNumber, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.store = store;
        this.consumerNumber = consumerNumber;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consuming by Consumer #: " + consumerNumber);
                try {
                    store.setItemsCount();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            producerSemaphore.release();
        }
    }
}
