package com.scaler.addersubtractorlocks;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws Exception {
        Value value = new Value();
        Lock lock = new ReentrantLock();

        Adder adder = new Adder(value, lock);
        Subtractor subtractor = new Subtractor(value, lock);

        ExecutorService es = Executors.newCachedThreadPool();
//        List<Integer>
        Future<Void> adderFuture =  es.submit(adder);
        Future<Void> subtractorFuture = es.submit(subtractor);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(value.value);
    }
}
