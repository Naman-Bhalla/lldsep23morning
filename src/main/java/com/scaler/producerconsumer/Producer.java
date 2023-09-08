package com.scaler.producerconsumer;

public class Producer implements Runnable {
    private Store store;
    private int producerNUmber;

    public Producer(Store store, int producerNUmber) {
        this.store = store;
        this.producerNUmber = producerNUmber;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (store) {
                if (store.getItemsCount() < store.getMaxItemsCount()) {
                    System.out.println("Producing an item by producer #: " + producerNUmber);
                    try {
                        store.setItemsCount(store.getItemsCount() + 1);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
