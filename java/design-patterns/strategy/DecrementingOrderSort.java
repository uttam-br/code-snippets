package strategy;

import java.util.Collections;
import java.util.List;

public class DecrementingOrderSort implements SortingStratagy {

    @Override
    public void sort(List<Integer> nums) {
        nums.sort(Collections.reverseOrder());
    }

}
