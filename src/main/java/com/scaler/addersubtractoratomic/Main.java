package com.scaler.addersubtractoratomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {
        Value value = new Value();

        Adder adder = new Adder(value);
        Subtractor subtractor = new Subtractor(value);

        ExecutorService es = Executors.newCachedThreadPool();
//        List<Integer>
        Future<Void> adderFuture =  es.submit(adder);
        Future<Void> subtractorFuture = es.submit(subtractor);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(value.value);

        es.shutdown();
    }

//    public static double getAreaOfCircle(int radius) {
//        return  * radius * radius;
//    }
}
