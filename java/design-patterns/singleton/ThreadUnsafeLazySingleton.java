public class ThreadUnsafeLazySingleton {

    private static ThreadUnsafeLazySingleton instance;

    private ThreadUnsafeLazySingleton() {}

    public static ThreadUnsafeLazySingleton getInstance() {
        if (instance == null) {
            instance = new ThreadUnsafeLazySingleton();
        }
        return instance;
    }

}
