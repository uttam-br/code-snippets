package sync;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
    public AtomicInteger value = new AtomicInteger(0);

    public void increment() {
        this.value.set(this.value.get() + 1);
    }

    public void decrement() {
        this.value.set(this.value.get() - 1);
    }
}
