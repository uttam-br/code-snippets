import java.io.Serial;
import java.io.Serializable;

public class ThreadSafeDoubleCheckedLockingSingleton implements Serializable {

    private static ThreadSafeDoubleCheckedLockingSingleton instance;

    private ThreadSafeDoubleCheckedLockingSingleton() {
    }

    public static ThreadSafeDoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSynchronizedSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeDoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    @Serial
    protected Object readResolve() {
        return getInstance();
    }

}
