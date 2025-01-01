package guarded_blocks;

class Flag {
    boolean flag = false;

    public synchronized boolean getFlag() {
        return flag;
    }

    public synchronized void setFlag(boolean flag) {
        this.flag = flag;
    }


}

class WaitForJoy implements Runnable {

    Flag joyFlag;

    public WaitForJoy(Flag joyFlag) {
        this.joyFlag = joyFlag;
    }

    public void guardedJoy() {
        synchronized (joyFlag) {
            while (!joyFlag.getFlag()) {
                System.out.println("flag is false, waiting...");
                try {
                    joyFlag.wait();
                } catch (InterruptedException e) {
                    // ignore
                }
            }

            System.out.println("Joy is true. Out of loop");
        }
    }

    @Override
    public void run() {
        guardedJoy();
    }

}

class UpdateJoy implements Runnable {

    Flag joyFlag;

    public UpdateJoy(Flag joyFlag) {
        this.joyFlag = joyFlag;
    }

    public void updateJoy() {
        synchronized (joyFlag) {
            System.out.println("updating joyFlag to true");
            joyFlag.setFlag(true);
            joyFlag.notifyAll();
        }
    }

    @Override
    public void run() {
        updateJoy();
    }

}

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Flag joyFlag = new Flag();

        // Thread 1 to wait for joy to become true.
        WaitForJoy waitForJoy = new WaitForJoy(joyFlag);
        Thread thread1 = new Thread(waitForJoy);
        thread1.start();

        System.out.println("Waiting for 1s");
        Thread.sleep(1000);

        // Thread 2 to make joy true
        Thread thread2 = new Thread(new UpdateJoy(joyFlag));
        thread2.start();
    }

}
