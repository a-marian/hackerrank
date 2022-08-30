package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class CountingInversions {


    static long count = 0;

        public static long countInversions(List<Integer> arr) {

              return mergeSort(arr, 0, arr.size()-1);
        }

        public static long mergeSort(List<Integer> arr, int left, int right){
            long countInvTotal = 0;

            if(left >= right){
                return 0;
            }
                int middle = (right+left)/2;
                countInvTotal += mergeSort(arr, left, middle);
                countInvTotal += mergeSort(arr, middle+1, right);

                countInvTotal += merge(arr, left, right);

            return countInvTotal;
        }
        public static long merge(List<Integer> arr, int left, int right){

            List<Integer> merged = new ArrayList<>(right-left+1);
            long swaps = 0;
            int middle = (right+left)/2;
            int i = left, j= middle+1;

            while(i <= middle &&  j <= right){
                if(arr.get(i) > arr.get(j)){
                    merged.add(arr.get(j++));
                    swaps += middle-i+1;
                } else {
                    merged.add(arr.get(i++));
                }
            }
            while (i <= middle) {
                merged.add(arr.get(i++));
            }
            while (j <= right){
                merged.add(arr.get(j++));
            }
            for (int k = 0; k <= right-left; k++) {
                arr.set(k+left, merged.get(k));
            }
            System.out.println(Arrays.toString(arr.toArray()));

            return swaps;
        }

        public static void main(String[] args) {
            List<Integer> testCase01 = Arrays.asList(1,1,1,2,2);
            System.out.println(countInversions(testCase01));
            List<Integer> testCase02 = Arrays.asList(2,1,3,1,2);
            System.out.println(countInversions(testCase02));

            List<Integer> testCase21 = Arrays.asList(1,3,5,7);
            System.out.println(countInversions(testCase21));
            List<Integer> testCase22 = Arrays.asList(3,2,1);
            System.out.println(countInversions(testCase22));

            List<Integer> testCase11 = Arrays.asList(1, 5, 3, 7);
            System.out.println(countInversions(testCase11));
            List<Integer> testCase12 = Arrays.asList(7, 5, 3, 1);
            System.out.println(countInversions(testCase12));

        }

}

