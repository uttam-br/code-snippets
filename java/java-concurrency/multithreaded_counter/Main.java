package multithreaded_counter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        long start = System.nanoTime();

        ReentrantLock lock = new ReentrantLock();

        Semaphore semaphore = new Semaphore(1);

        Counter counter = new Counter();

        Runnable incrementRunnable = () -> {
            for (int i = 0; i < 10000000; i++) {
//                lock.lock();
//                try {
//                    semaphore.acquire();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                counter.inc();
//                semaphore.release();
//                lock.unlock();
            }
        };

        Runnable decrementRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000000; i++) {
//                    try {
//                        semaphore.acquire();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    lock.lock();
                    counter.dec();
//                    lock.unlock();
//                    semaphore.release();
                }
            }
        };

        Thread incrementorThread = new Thread(incrementRunnable);
        Thread incrementorThread2 = new Thread(incrementorThread);
        Thread decrementThread = new Thread(decrementRunnable);
        Thread decrementThread2 = new Thread(decrementRunnable);

        System.out.println("Counter " + counter.get());

        System.out.println("Starting all threads....");

        incrementorThread.start();
        decrementThread.start();
        decrementThread2.start();
        incrementorThread2.start();

        System.out.println("Started all threads");

        incrementorThread.join();
        decrementThread.join();
        incrementorThread2.join();
        decrementThread2.join();

        System.out.println("Completed all threads");
        System.out.println("Counter " + counter.get());

        long end = System.nanoTime();

        System.out.println("Execution time: " + (end - start) / 1_000_000.0 + " ms");

    }

}
