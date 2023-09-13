package com.scaler.prodconssemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    int consumerId;

    public Consumer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore, int consumerId) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.consumerId = consumerId;
    }

    private void consumeItem() {
//        while (!(store.getItems().size() > 0)) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        try {
            consumerSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        store.removeItem(consumerId);
        producerSemaphore.release();
    }

    @Override
    public void run() {
        while (true) {
            consumeItem();
        }
    }
}
