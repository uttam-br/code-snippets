package sync;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    Count count;
    Lock lock;

    public Adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
//            lock.lock();
            System.out.println("Adder " + Thread.currentThread().getName());
            this.count.increment();
//            lock.unlock();
        }
    }
}
