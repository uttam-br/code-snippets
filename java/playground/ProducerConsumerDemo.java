import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumerDemo {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        Semaphore producerSemaphore = new Semaphore(5);
        Semaphore consumerSemaphore = new Semaphore(0);

        Thread producer1 = new Thread(new ProducerOne(queue, producerSemaphore, consumerSemaphore));
        Thread producer2 = new Thread(new ProducerTwo(queue, producerSemaphore, consumerSemaphore));
        Thread consumer1 = new Thread(new Consumer(queue, producerSemaphore, consumerSemaphore));
        Thread consumer2 = new Thread(new Consumer(queue, producerSemaphore, consumerSemaphore));

        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();

    }

}

class Consumer implements Runnable {
    private Queue<Integer> queue;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumer(Queue<Integer> queue, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consumerSemaphore.acquire();
//                synchronized (queue) {
                int val = queue.poll();
                System.out.println(val + " consumed by " + Thread.currentThread().getName());
//                }
                producerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ProducerOne implements Runnable {

    private final Queue<Integer> queue;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public ProducerOne(Queue<Integer> queue, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 500; i++) {
            try {
                producerSemaphore.acquire();
//                synchronized (queue) {
                queue.add(i);
//                }
                consumerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class ProducerTwo implements Runnable {

    private final Queue<Integer> queue;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public ProducerTwo(Queue<Integer> queue, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        for (int i = 501; i <= 1000; i++) {
            try {
                producerSemaphore.acquire();
                synchronized (queue) {
                    queue.add(i);
                }
                consumerSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}