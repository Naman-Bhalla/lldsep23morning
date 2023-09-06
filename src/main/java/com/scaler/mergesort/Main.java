package com.scaler.mergesort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Integer> arrayToSort = List.of(
                8, 2, 4, 1, 9, 6, 0, 7
        );

        ExecutorService es = Executors.newFixedThreadPool(5);

        Sorter sorter = new Sorter(arrayToSort, es);

        List<Integer> sortedArray = sorter.call();

        for (Integer in: sortedArray) {
            System.out.println(in);
        }

//        Thread t = new Thread();
//        t.stop();;

//        es.shutdown();
    }
}
