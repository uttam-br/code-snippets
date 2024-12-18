package executors;

public class NumberPrinter implements Runnable {

    int number;

    NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Number " + this.number + " and thread name " + Thread.currentThread().getName());
    }

}
