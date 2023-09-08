package com.scaler.producerconsumer;

public class Consumer implements Runnable {
    private Store store;
    private int consumerNumber;

    public Consumer(Store store, int consumerNumber) {
        this.store = store;
        this.consumerNumber = consumerNumber;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (store) {
                if (store.getItemsCount() > 0) {
                    System.out.println("Consuming by Consumer #: " + consumerNumber);
                    try {
                        store.setItemsCount(store.getItemsCount() - 1);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
