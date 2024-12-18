package executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

    List<Integer> list;
    ExecutorService executor;

    MergeSorter(List<Integer> list, ExecutorService executor) {
        this.list = list;
        this.executor = executor;
    }

    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {

        System.out.println("Running on " + Thread.currentThread().getName());

        if (list.size() <= 1) {
            return list;
        }

        // divide into two equal halfs and sort them
        List<Integer> firstHalf = new ArrayList<>();
        List<Integer> secondHalf = new ArrayList<>();

        for (int i = 0; i < list.size() / 2; i++) {
            firstHalf.add(list.get(i));
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            secondHalf.add(list.get(i));
        }

        MergeSorter firstHalfMergeSort = new MergeSorter(firstHalf, executor);
        MergeSorter secondHalfMergeSort = new MergeSorter(secondHalf, executor);

        Future<List<Integer>> firstHalfSortedFuture = executor.submit(firstHalfMergeSort);
        Future<List<Integer>> secondHalfSortedFuture = executor.submit(secondHalfMergeSort);

        // merge sorted lists
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        List<Integer> firstHalfSorted = firstHalfSortedFuture.get(); // Blocking call.
        List<Integer> secondHalfSorted = secondHalfSortedFuture.get(); // Blocking call.

        while (i < firstHalfSorted.size() && j < secondHalfSorted.size()) {
            if (firstHalfSorted.get(i) <= secondHalfSorted.get(j)) {
                merged.add(firstHalfSorted.get(i));
                i++;
            } else {
                merged.add(secondHalfSorted.get(j));
                j++;
            }
        }

        while (i < firstHalfSorted.size()) {
            merged.add(firstHalfSorted.get(i));
            i++;
        }

        while (j < secondHalfSorted.size()) {
            merged.add(secondHalfSorted.get(j));
            j++;
        }

        return merged;
    }
}