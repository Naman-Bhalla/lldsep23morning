package com.scaler.addersubtractor;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private Value value;

    public Subtractor(Value value) {
        this.value = value;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 1; i <= 100; ++i) {
            value.value -= i;
        }

        return null;
    }
}
