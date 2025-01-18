package strategy;

import java.util.Collections;
import java.util.List;

public class IncrementingOrderSort implements SortingStratagy {

    @Override
    public void sort(List<Integer> nums) {
        Collections.sort(nums);
    }

}
