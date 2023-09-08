package com.scaler.addersubtractorsyncmethod;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private Value value;
//    private Lock lock;

    public Subtractor(Value value) {
        this.value = value;
//        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 1; i <= 10000; ++i) {
            System.out.println("Requesting lock for subtracting " + i );
//            value.setValue(100);
            value.incrementBy(-i);
            System.out.println("Subtracted " + i);
        }

        return null;
    }
}
