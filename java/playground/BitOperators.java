import java.util.Scanner;

public class BitOperators {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int num = scanner.nextInt();

        // odd or even using & operator
        if ((num & 1) == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }

        // left shift operator (multiply by 2 thrice)
        System.out.println(num << 3);

        // right shift operator (divide by 2 thrice)
        System.out.println(num >> 3);

        System.out.println(Integer.toBinaryString(num));
    }

}
