package sorting;
/**
 * Often, when a list is sorted, the elements being sorted are just keys
 * to other values. For example, if you are sorting files by their size,
 * the sizes need to stay connected to their respective files.
 * You cannot just take the size numbers and output them in order,
 * you need to output all the required file information.
 * The counting sort is used if you just need to sort a list of integers.
 * Rather than using a comparison, you create an integer array whose index
 * range covers the entire range of values in your array to sort.
 * Each time a value occurs in the original array, you increment the counter
 * at that index. At the end, run through your counting array, printing the
 * value of each non-zero valued index that number of times.
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class countingSort2 {

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int[] arrayValueCont = new int [100];
        Arrays.fill(arrayValueCont, 0);
        for (int i = 0; i < arr.size(); i++) {
            int valuePos = arr.get(i);
            arrayValueCont[valuePos]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayValueCont.length; i++) {
            if(arrayValueCont[i] != 0 ){
                for (int j = 0; j < arrayValueCont[i]; j++) {
                    result.add(i);
                }
            }
        }
        return result;
    }

}
