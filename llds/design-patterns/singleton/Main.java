package singleton;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        long startMillis = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            Logger logger1;
            try {
                logger1 = Logger.getInstance();
                logger1.display();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            Logger logger2;
            try {
                logger2 = Logger.getInstance();
                logger2.display();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(System.currentTimeMillis() - startMillis);
    }

}