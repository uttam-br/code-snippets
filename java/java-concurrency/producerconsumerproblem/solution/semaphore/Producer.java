package producerconsumerproblem.solution.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {

    Queue<String> queue;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    Producer(Queue<String> queue, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.add(Thread.currentThread().getName() + ", SIZE: " + queue.size());
            consumerSemaphore.release();
        }
    }

}
