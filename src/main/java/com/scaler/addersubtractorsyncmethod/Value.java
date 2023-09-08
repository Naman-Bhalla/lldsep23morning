package com.scaler.addersubtractorsyncmethod;

public class Value {
    private int value;

    public int getValue() {
        return value;
    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }

    public synchronized void incrementBy(int value) {
        this.value += value;
    }
}
