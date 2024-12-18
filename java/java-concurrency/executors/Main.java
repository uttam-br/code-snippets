package executors;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Integer> list = List.of(3, 2, 5, 8, 2, 1, 2);

        MergeSorter mergeSorter = new MergeSorter(list, executorService);

        Future<List<Integer>> sortedFuture = executorService.submit(mergeSorter);

        System.out.println(sortedFuture.get());

        executorService.shutdown();
    }

}
