import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    // 1 2 3 4

    // start = 0, end = 3
    // mid = 0 + 3/2 = 0 + 1 = 1
    // start = 0, end = 1 // start = 2 end = 3

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 8, 2, 1, 3, 2, 5, 3, 1, 3, 7, 1, 8, 2, 1, 3, 2, 5, 3, 1, 3, 7, 1, 8, 2, 1, 3, 2, 5, 3, 1, 3, 7, 1, 8, 2, 1, 3, 2, 5, 3, 1, 3, 7));
        System.out.println(list);
        sort(list, 0, list.size() - 1);
        System.out.println(list);
    }

    private static void sort(List<Integer> list, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            // sort left side
            sort(list, start, mid);
            // sort right side
            sort(list, mid + 1, end);

            // merge both sorted lists
            List<Integer> finalList = new ArrayList<>();

            int i = start;
            int j = mid + 1;

            while (i <= mid && j <= end) {
                if (list.get(i) < list.get(j)) {
                    finalList.add(list.get(i));
                    i++;
                } else {
                    finalList.add(list.get(j));
                    j++;
                }
            }

            while (i <= mid) {
                finalList.add(list.get(i));
                i++;
            }

            while (j <= end) {
                finalList.add(list.get(j));
                j++;
            }

            // update list with final list
            for (int k = 0; k < finalList.size(); k++) {
                list.set(start + k, finalList.get(k));
            }
        }
    }


}
