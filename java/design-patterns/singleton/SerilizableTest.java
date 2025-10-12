import java.io.*;

public class SerilizableTest {

    public static void main(String[] args) {

        ThreadSafeDoubleCheckedLockingSingleton instanceOne = ThreadSafeDoubleCheckedLockingSingleton.getInstance();

        // write instanceOne to .ser file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.ser"))) {
            out.writeObject(instanceOne);
        } catch (Exception e) {
            // ignored
            return;
        }

        ThreadSafeDoubleCheckedLockingSingleton instanceTwo = null;

        // read .ser file to instanceTwo
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.ser"))) {
            instanceTwo = (ThreadSafeDoubleCheckedLockingSingleton) in.readObject();
        } catch (Exception e) {
            // ignored
            return;
        }

        System.out.println("instanceOne hashCode " + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode " + instanceTwo.hashCode());

        if (instanceOne == instanceTwo) {
            System.out.println("Both instance are same");
        } else {
            System.out.println("Both instance are different");
        }

    }

}
