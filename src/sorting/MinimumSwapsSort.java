package sorting;

import java.util.Arrays;
import java.util.List;

public class MinimumSwapsSort {

    public static int lilysHomework(List<Integer> arr) {
        int res = 0;
        // Write your code here
        for(int i= 1; i<arr.size(); i++){
            int key = arr.get(i);
            int j = i-1;

            while(j>=0 && arr.get(j)>key){
                arr.set(j+1, arr.get(j));
                j--;
                res++;
            }

            arr.set(j+1, key);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList( 1, 2, 3);
        List<Integer> array2 = Arrays.asList( 2, 5, 3, 1);
        List<Integer> array3 = Arrays.asList(3, 4, 2,5,1);

        System.out.println( lilysHomework(array2));
        System.out.println( lilysHomework(array3));


    }
}
