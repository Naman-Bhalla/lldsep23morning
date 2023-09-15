package com.scaler.addersubtractoratomic;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Value value;

    public Adder(Value value) {
        this.value = value;
    }

    @Override
    public Void call() throws Exception {

        for (int i = 1; i <= 100; ++i) {
            value.value.addAndGet(i);
        }

        return null;
    }
}