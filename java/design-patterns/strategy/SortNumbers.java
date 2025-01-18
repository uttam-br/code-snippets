package strategy;

import java.util.List;

public class SortNumbers {

    SortingStratagy sortingStrategy;

    public SortNumbers() {
        this.sortingStrategy = new IncrementingOrderSort();
    }

    public void sort(List<Integer> nums) {
        sortingStrategy.sort(nums);
    }

}
