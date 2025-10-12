
public class Main {

    public static void main(String[] args) {

        Test test = new Test("Uttam", 27);

        ClassLoader classloader = test.getClass().getClassLoader();

        System.out.println("Inspect classloader object");

    }

}