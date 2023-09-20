package com.scaler.generics;

public class Utilities {

    public <K, V> V doSomething(K key, V value) {
        System.out.println(key);
        System.out.println(value);

        return value;
    }
}
