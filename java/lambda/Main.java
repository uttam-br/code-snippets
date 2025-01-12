import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

//        SampleFunctionalInterface sampleFunctionalInterface = () -> System.out.println("fun1");
//
//        sampleFunctionalInterface.fun1();
//        sampleFunctionalInterface.fun2();
//
//        Runnable runnable = () -> {
//            System.out.println("Runnable");
//        };
//
//        Thread thread = new Thread(() -> System.out.println("runnable"));
//        thread.start();
//
//        List.of(1,2,3,4);
//
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(2);
//        numbers.add(1);
//        numbers.add(6);
//        numbers.add(7);
//        numbers.add(10);
//
//        System.out.println(numbers);
//        numbers.sort((n1, n2) -> n2 - n1);
//        System.out.println(numbers);
//

        long start = System.currentTimeMillis();
        IntStream.range(1, 1000000000).forEach(i -> {
            // Simulate some work
            Math.pow(i, 2);
        });
        long end = System.currentTimeMillis();
        System.out.println("Sequential execution time: " + (end - start) + " ms");

//        long start = System.currentTimeMillis();
//        IntStream.range(1, 1000000000).parallel().forEach(i -> {
//            // Simulate some work
//            Math.pow(i, 2);
//        });
//        long end = System.currentTimeMillis();
//        System.out.println("Parallel execution time: " + (end - start) + " ms");

    }

}
