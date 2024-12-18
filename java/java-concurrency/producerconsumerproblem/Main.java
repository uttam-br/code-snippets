package producerconsumerproblem;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {

        Queue<Object> queue = new ConcurrentLinkedQueue<>();
        int maxSize = 5;

        Producer p1 = new Producer(queue, maxSize, "Producer 1");
        Producer p2 = new Producer(queue, maxSize, "Producer 2");
        Producer p3 = new Producer(queue, maxSize, "Producer 3");
        Producer p4 = new Producer(queue, maxSize, "Producer 4");
        Producer p5 = new Producer(queue, maxSize, "Producer 5");

        Consumer c1 = new Consumer(queue, "Consumer 1");
        Consumer c2 = new Consumer(queue, "Consumer 2");
        Consumer c3 = new Consumer(queue, "Consumer 3");
        Consumer c4 = new Consumer(queue, "Consumer 4");
        Consumer c5 = new Consumer(queue, "Consumer 5");

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);
        Thread t4 = new Thread(p4);
        Thread t5 = new Thread(p5);
        Thread t6 = new Thread(c1);
        Thread t7 = new Thread(c2);
        Thread t8 = new Thread(c3);
        Thread t9 = new Thread(c4);
        Thread t10 = new Thread(c5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        System.out.println("All thread started");
    }

}
