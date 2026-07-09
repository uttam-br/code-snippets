public class SynchronizationDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        System.out.println(counter.get());

        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 1000000; i++) {
                counter.inc();
            }
        });

        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 1000000; i++) {
                counter.dec();
            }
        });

        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.get());
    }

}

class Counter {
    private int value;

    void inc() {
        synchronized (this) {
            value++;
        }
    }

    void dec() {
        synchronized (this) {
            value--;
        }
    }

    int get() {
        return value;
    }

}