package com.scaler.generics;

import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> studentInfos = new HashMap<>();

        System.out.println("Datatype of studentInfos is " + studentInfos.getClass().getName());

//        studentInfos.put("hello", "naman");

        HashMap hm = new HashMap();
        hm.put(1, "Ankit");
        hm.put("hello", "Naman");



//        for (var v: hm.keySet()) {
//            int i = (Integer) v;
//            System.out.println(i);
//        }

//        List

        Utilities utilities = new Utilities();
        int i = utilities.doSomething("hello", 1);
        String j = utilities.doSomething(1, "hello");
    }
}
