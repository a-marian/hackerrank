package sorting;

import java.util.Collections;
import java.util.List;

public class FindMedianArray {

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int arrsize = arr.size();
        int median = 0;
        int middle = arrsize/2;
        if(arrsize %2 == 0){
            median = (arr.get(middle-1)+arr.get(middle))/2;
            return median;
        }else{
            return arr.get(middle);
        }
    }

}
