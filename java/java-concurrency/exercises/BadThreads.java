package exercises;

public class BadThreads {

    private static volatile String message;

    private static class CorrectedThread extends Thread {

        @Override
        public void run() {
            try {
                sleep(100);
            } catch (InterruptedException e) { }

            message = "Mares do eat oats.";

        }
    }

    public static void main(String[] args) throws InterruptedException {
        (new CorrectedThread()).start();
        message = "Mares do not eat oats";
        Thread.sleep(99);
        System.out.println(message);
    }



}
