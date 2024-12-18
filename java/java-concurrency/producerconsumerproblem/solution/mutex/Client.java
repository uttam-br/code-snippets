package producerconsumerproblem.solution.mutex;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Client {

    public static void main(String[] args) {

        Queue<String> queue = new ConcurrentLinkedQueue<>();
        int maxSize = 5;

        Producer p1 = new Producer(queue, maxSize);
        Consumer c1 = new Consumer(queue, maxSize);
        Producer p2 = new Producer(queue, maxSize);
        Consumer c2 = new Consumer(queue, maxSize);
        Producer p3 = new Producer(queue, maxSize);
        Consumer c3 = new Consumer(queue, maxSize);
        Producer p4 = new Producer(queue, maxSize);
        Consumer c4 = new Consumer(queue, maxSize);
        Producer p5 = new Producer(queue, maxSize);
        Consumer c5 = new Consumer(queue, maxSize);

        Thread thread = new Thread(p1);
        thread.start();
        thread = new Thread(c1);
        thread.start();

        thread = new Thread(p2);
        thread.start();
        thread = new Thread(c2);
        thread.start();

        thread = new Thread(p3);
        thread.start();
        thread = new Thread(c3);
        thread.start();

        thread = new Thread(p4);
        thread.start();
        thread = new Thread(c4);
        thread.start();

        thread = new Thread(p5);
        thread.start();
        thread = new Thread(c5);
        thread.start();

        System.out.println("All threads are running...");

    }

}
