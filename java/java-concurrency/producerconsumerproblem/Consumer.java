package producerconsumerproblem;

import java.util.Queue;

public class Consumer implements Runnable {

    Queue<Object> queue;
    String name;

    Consumer(Queue<Object> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
//            synchronized (queue) {
                if (!queue.isEmpty()) {
                    queue.remove();
//                    System.out.println(name + " consumed, queue size : " + queue.size());
                }
//            }
        }
    }

}
