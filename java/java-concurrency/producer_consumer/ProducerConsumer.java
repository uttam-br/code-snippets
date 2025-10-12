package producer_consumer;

import java.util.*;

public class ProducerConsumer {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;

    public void produce(int i) {

    }

    public int consume() {
    }

    public static void main(String[] args) throws InterruptedException {

        // common queue
        Deque<Integer> queue = new ArrayDeque<>();

        // producer add at the end, and consumer consumes from the head

        Runnable producer = () -> {
            while (queue.isEmpty()) {
            }
            for (int i = 0; i < 1_000_000; i++) {
                queue.add(i);
                System.out.println("Produced : " + i);
            }
        };

        Runnable consumer = () -> {
            while (!queue.isEmpty()) {
                int val = queue.pollFirst();
                System.out.println("Consumed : " + val);
            }
        };

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Threads finished execution.");

    }

}
