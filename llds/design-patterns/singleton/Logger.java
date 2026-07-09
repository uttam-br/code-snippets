package singleton;

public class Logger {

    private Logger() {}

    private class Instance {
        public static Logger instance = new Logger();
    }

    public static Logger getInstance() throws InterruptedException {
        Thread.sleep(5000);
        // if (instance == null) {
        //     synchronized(Logger.class) {
        //         if (instance == null) {
        //             instance = new Logger();
        //         }
        //     }
        // }
        // return instance;
        return Instance.instance;
    }

    public void display() {
        System.out.println("I'm Logger Instance: " + this.hashCode());
    }

}