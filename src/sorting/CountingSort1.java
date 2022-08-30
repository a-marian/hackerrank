package sorting;
/**
 * Comparison Sorting
 * Quicksort usually has a running time of  n* log(n),
 * but is there an algorithm that can sort even faster?
 * In general, this is not possible. Most sorting algorithms are comparison sorts, i.e. they sort a list just by comparing the elements to one another. A comparison sort algorithm cannot beat  (worst-case) running time, since represents the minimum number of comparisons needed to know where to place each element. For more details, you can see these notes (PDF).
 * Alternative Sorting
 * Another sorting method, the counting sort, does not require comparison. Instead, you create an integer array whose index range covers the entire range of values in your array to sort. Each time a value occurs in the original array, you increment the counter at that index. At the end, run through your counting array, printing the value of each non-zero valued index that number of times.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountingSort1 {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] arrayValue = new int[100];
        Arrays.fill(arrayValue, 0);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            int valuePos = arr.get(i);
            arrayValue[valuePos]++;
        }
        //for (int val : arrayValue) {
         //   result.add(val);
        //}
        //return result;
        //streams
        return Arrays.stream(arrayValue).boxed()
                .collect(Collectors.toList());
    }

}
