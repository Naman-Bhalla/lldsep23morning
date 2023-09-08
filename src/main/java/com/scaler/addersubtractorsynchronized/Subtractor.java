package com.scaler.addersubtractorsynchronized;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private Value value;
//    private Lock lock;

    public Subtractor(Value value) {
        this.value = value;
//        this.lock = lock;
    }

    @Override
    public Void call() throws Exception {
        for (int i = 1; i <= 100; ++i) {
            System.out.println("Requesting lock for subtracting " + i );
//            lock.lock(); // requesting if I can get the key to this lock. Lock class will only give the key if no one else already has the key
            synchronized (value) {
                value.value -= i;
                System.out.println("Subtracted " + i);
            }

//            lock.unlock(); // giving back the key
        }

        return null;
    }
}
