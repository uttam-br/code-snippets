public class ThreadSafeSynchronizedSingleton {

    private static ThreadSafeSynchronizedSingleton instance;

    private ThreadSafeSynchronizedSingleton() {}

    public synchronized static ThreadSafeSynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSynchronizedSingleton();
        }
        return instance;
    }

}

