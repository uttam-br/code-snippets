package producer_consumer_wait_notify;

import java.util.LinkedList;

class SharedQueue {

    private final LinkedList<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            System.out.println("Queue is full. Producer is waiting...");
            wait();
        }
        queue.add(value);
        System.out.println("Produced " + value);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.size() == 0) {
            System.out.println("Queue is empty. Consumer is waiting...");
            wait();
        }
        int value = queue.removeFirst();
        notifyAll();
        return value;
    }

}

class Consumer implements Runnable {

    private final SharedQueue sharedQueue;

    public Consumer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int value = sharedQueue.consume();
                System.out.println("Consumed " + value);
//                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Producer implements Runnable {

    private final SharedQueue sharedQueue;

    public Producer(SharedQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                sharedQueue.produce(value++);
//                Thread.sleep(500); // wait for half second.
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

public class Main {

    public static void main(String[] args) {

        SharedQueue sharedQueue = new SharedQueue();

        Thread producerThread = new Thread(new Producer(sharedQueue));
        Thread consumerThread = new Thread(new Consumer(sharedQueue));

        producerThread.start();
        consumerThread.start();

    }

}
