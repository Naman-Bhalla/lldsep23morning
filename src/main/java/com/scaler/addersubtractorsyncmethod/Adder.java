package com.scaler.addersubtractorsyncmethod;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;
//    private Lock lock;

    public Adder(Value value) {
        this.value = value;
//        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {

        for (int i = 1; i <= 10000; ++i) {
            System.out.println("Requesting lock for adding " + i );
            value.incrementBy(i);
            System.out.println("Added " + i);
        }

        return null;
    }
}
