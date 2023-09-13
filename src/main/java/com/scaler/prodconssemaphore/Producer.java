package com.scaler.prodconssemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    private int producerId;

    public Producer(Store store, Semaphore producerSemaphore, Semaphore consumerSemaphore, int producerId) {
        this.store = store;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.producerId = producerId;
    }

    private void produceItem() {
//        while(!(store.getItems().size() < 5)) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        try {
            producerSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        store.addItem(producerId);
        consumerSemaphore.release();
    }

    @Override
    public void run() {
        while (true) {
            produceItem();
        }
    }
}
