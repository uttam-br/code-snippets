import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentMergeSorter implements Callable<List<Integer>> {

    private final List<Integer> list;
    private final ExecutorService executorService;

    public ConcurrentMergeSorter(ExecutorService executorService, List<Integer> list) {
        this.executorService = executorService;
        this.list = list;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (list.size() <= 1) {
            return list;
        }

        // divide list in two parts and call sorter
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() / 2) {
                leftList.add(list.get(i));
            } else {
                rightList.add(list.get(i));
            }
        }

        Future<List<Integer>> leftSortFuture = executorService.submit(new ConcurrentMergeSorter(executorService, leftList));
        Future<List<Integer>> rightSortFuture = executorService.submit(new ConcurrentMergeSorter(executorService, rightList));

        List<Integer> leftSortedList = leftSortFuture.get();
        List<Integer> rightSortedList = rightSortFuture.get();

        // merge sorted lists
        List<Integer> sortedList = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < leftSortedList.size() && j < rightSortedList.size()) {
            if (leftSortedList.get(i) < rightSortedList.get(j)) {
                sortedList.add(leftSortedList.get(i));
                i++;
            } else {
                sortedList.add(rightSortedList.get(j));
                j++;
            }
        }

        while (i < leftSortedList.size()) {
            sortedList.add(leftSortedList.get(i));
            i++;
        }

        while (j < rightSortedList.size()) {
            sortedList.add(rightSortedList.get(j));
            j++;
        }

        return sortedList;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 8, 2, 1, 3, 2, 5, 3, 1, 3, 7, 1, 8, 2, 1, 3, 2, 5, 3, 1, 3, 7, 1, 8, 2, 1, 3, 2, 5, 3, 1, 3, 7, 1, 8, 2, 1, 3, 2, 5, 3, 1, 3, 7));

        System.out.println(list);

        ExecutorService executorService = Executors.newCachedThreadPool();

        ConcurrentMergeSorter concurrentMergeSort = new ConcurrentMergeSorter(executorService, list);

        Future<List<Integer>> sortedListFuture = executorService.submit(concurrentMergeSort);

        try {
            System.out.println(sortedListFuture.get());
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
