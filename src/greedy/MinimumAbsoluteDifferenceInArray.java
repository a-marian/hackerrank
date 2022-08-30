package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifferenceInArray {

    public static int minimumAbsoluteDifferenceBruteForce(List<Integer>arr){
        int response=Integer.MAX_VALUE;
        if (arr.size() == 2) return  arr.get(0) - arr.get(1);

        for (int i = 0; i < arr.size() ; i++) {
            for (int j = i+1; j < arr.size() ; j++) {
                int  absResto = arr.get(i) - arr.get(j);
                if ( Math.abs(absResto) < response){
                    response = absResto;
                }
            }
        }
        return response;
    }

    public static int minimumAbsoluteDifferenceComplexityV1(List<Integer>arr){
        int minimumAbsoluteDiff = Integer.MAX_VALUE;
        if (arr.size() == 2) return  arr.get(0) - arr.get(1);

        int arrsize = arr.size();

        for (int j = 1; j < arrsize; j++) {
            int  currentAbsoluteDifference = Math.abs(arr.get(j) - arr.get(j-1));
            minimumAbsoluteDiff = Math.min(minimumAbsoluteDiff, currentAbsoluteDifference);
            }
        return minimumAbsoluteDiff;
    }

    public static void main(String[] args) {
        List<Integer> array1 = new ArrayList<>(Arrays.asList(3, -7, 0));
        System.out.println(minimumAbsoluteDifferenceBruteForce(array1));

        List<Integer> array2 = new ArrayList<>(Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75));
        System.out.println(minimumAbsoluteDifferenceComplexityV1(array2));

        List<Integer> array3 = new ArrayList<>(Arrays.asList(1, -3, 71, 68, 17));
        System.out.println(minimumAbsoluteDifferenceComplexityV1(array3));





    }
}
