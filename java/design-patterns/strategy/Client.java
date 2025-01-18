package strategy;

import java.util.Arrays;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 4, 10, 4, 8, 1, 9);
        SortNumbers sortNumbers = new SortNumbers();
        sortNumbers.sort(nums);
        System.out.println(nums);
    }

}
