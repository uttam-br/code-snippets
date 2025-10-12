public class Main {

    public static void main(String[] args) {

        EagerSingleton eagerSingleton =
                EagerSingleton.getInstance();

        ThreadUnsafeLazySingleton lazySingleton =
                ThreadUnsafeLazySingleton.getInstance();

        ThreadSafeSynchronizedSingleton threadSafeSynchronizedSingleton =
                ThreadSafeSynchronizedSingleton.getInstance();

        ThreadSafeDoubleCheckedLockingSingleton threadSafeDoubleCheckedLockingSingleton =
                ThreadSafeDoubleCheckedLockingSingleton.getInstance();


        WeekEnum weekEnum = WeekEnum.MONDAY;
        System.out.println(weekEnum.name());

    }

}


enum Singleton {
    INSTANCE;

    public void someMethod() {
        // business logic
        System.out.println("Hello World !!!");
    }
}