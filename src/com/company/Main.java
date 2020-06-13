package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ProducerConsumer pc = new ProducerConsumer();

    public static void main(String[] args) throws InterruptedException {
        List<String> names = new ArrayList<>() {
            {
                add("dipendra");
                add("puja");
                add("parisha");
            }
        };
        /**
         * factory class for setting object name
         */
        Person person = Person.buildName("dipendra");

        Runnable producer = () -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable consumer = () -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        /**
         * infinite for loop
         */
        for (; ; ) {
            System.out.println("hello");
        }
    }
}
