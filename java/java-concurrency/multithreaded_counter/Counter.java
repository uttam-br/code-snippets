package multithreaded_counter;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private final AtomicInteger count = new AtomicInteger(0);

    public void inc() {
        count.getAndIncrement();
    }

    public void dec() {
        count.getAndDecrement();
    }

    public int get() {
        return count.get();
    }

}
