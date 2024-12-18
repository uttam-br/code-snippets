package producerconsumerproblem.solution.mutex;

import java.util.Queue;

public class Producer implements Runnable {

    Queue<String> queue;
    int maxSize;

    Producer(Queue<String> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true) {
            if (queue.size() < maxSize) {
                queue.add(Thread.currentThread().getName() + " : " + queue.size());
            }
        }
    }

}
