package sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        AtomicInteger atomicInteger = new AtomicInteger();

        Lock lock = new ReentrantLock();

        Count count = new Count();

        Adder adder = new Adder(count, lock);
        Subtractor subtract = new Subtractor(count, lock);

        Thread adderThread = new Thread(adder);
        Thread subtractThread = new Thread(subtract);

        adderThread.start();
        subtractThread.start();

        try {
            adderThread.join();
            subtractThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count.value);
    }

}
