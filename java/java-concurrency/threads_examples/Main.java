package threads_examples;

public class Main {

    static void threadMessage(String message) {
        System.out.println(Thread.currentThread().getName() + " : " + message);
    }

    private static class MessageLoop implements Runnable {

        public void run() {
            String[] messages = {
                    "Message 01",
                    "Message 02",
                    "Message 03",
                    "Message 04"
            };

            try {
                for (String message : messages) {
                    // sleep for 4 seconds
                    Thread.sleep(4000);
                    threadMessage(message);
                }
            } catch (InterruptedException e) {
                threadMessage(e.getMessage());
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        threadMessage("Starting MessageLoop Thread");

        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop to finish");

        while (t.isAlive()) {
            threadMessage("Still waiting...");
            t.join(1000);
        }

        threadMessage("Finally!!");
    }

}
