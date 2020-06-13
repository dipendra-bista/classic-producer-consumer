package com.company;

import java.util.LinkedList;

public class ProducerConsumer {
    LinkedList<Integer> queue = new LinkedList<>();
    int capacity = 2;

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {

            synchronized (this) {
                while (queue.size() == capacity)
                    wait();
                System.out.println("Producer produced- " + value);
                queue.add(value++);
                /**
                 * notify consumer thread that it can
                 * start consuming
                 */
                notify();

                /**
                 *makes the working of program easier to understand
                 */
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0)
                    wait();
                int val = queue.removeFirst();
                System.out.println("Consumer Consumed -" + val);
                notify();
                Thread.sleep(1000);

            }
        }
    }
}
