package producerconsumerproblem.solution.mutex;

import java.util.Queue;

public class Consumer implements Runnable {

    Queue<String> queue;
    int maxSize;

    Consumer(Queue queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true) {
            if (queue.size() > 0) {
                System.out.println(queue.poll());
            }
        }
    }

}
