import java.util.concurrent.locks.ReentrantLock;

public class ThreadsDemo {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();

        Thread evenThread = new Thread(() -> {
            reentrantLock.lock();
            System.out.println("Thread: " + Thread.currentThread().getName());
            for (int i = 0; i <= 100; i+=2) {
                System.out.println(i);
            }
            reentrantLock.unlock();
        });
        Thread oddThread = new Thread(() -> {
            reentrantLock.lock();
            System.out.println("Thread: " + Thread.currentThread().getName());
            for (int i = 1; i <= 100; i+=2) {
                System.out.println(i);
            }
            reentrantLock.unlock();
        });

        evenThread.start();
        oddThread.start();

        System.out.println("Hello from " + Thread.currentThread().getName());

    }

}

