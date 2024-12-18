package producerconsumerproblem;

import java.util.Queue;

public class Producer implements Runnable {

    Queue<Object> queue;
    int maxSize;
    String name;

    public Producer(Queue<Object> queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (queue.size() < maxSize) {
//                synchronized (queue) {
                    queue.add(Thread.currentThread().getName());
//                    System.out.println(name + ", queue size : " + queue.size());
//                }
            }
        }
    }

}
