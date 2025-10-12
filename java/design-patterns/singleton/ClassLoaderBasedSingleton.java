import java.io.Serial;
import java.io.Serializable;

public class ClassLoaderBasedSingleton implements Serializable {

    private ClassLoaderBasedSingleton() {}

    private static class Singleton {
        private static final ClassLoaderBasedSingleton instance = new ClassLoaderBasedSingleton();
    }

    public static ClassLoaderBasedSingleton getInstance() {
        return Singleton.instance;
    }

    protected Object readResolve() {
        return getInstance();
    }

}
