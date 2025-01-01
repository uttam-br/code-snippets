
public class Main {

    public static void main(String[] args) {
//
//        SampleFunctionalInterface sampleFunctionalInterface = () -> System.out.println("fun1");
//
//        sampleFunctionalInterface.fun1();
//        sampleFunctionalInterface.fun2();

//        Runnable runnable = () -> {
//            System.out.println("Runnable");
//        };

        Thread thread = new Thread(() -> System.out.println("runnable"));
        thread.start();

    }

}
