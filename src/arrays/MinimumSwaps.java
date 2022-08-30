package arrays;

import java.util.Arrays;

public class MinimumSwaps {

    public static int minimumSwaps(int[] arr){
        int store;
        int swapCount = 0;
        int size = arr.length;
        int loop = 0;
        while (loop < size ){

            if (arr[loop] !=  loop+1) {
                store = arr[loop];
                arr[loop] = arr[store -1];
                arr[store-1] = store;
                swapCount++;
            }else {loop++;}

        }
        return swapCount;
    }

    public static void main(String[] args) {
        int[] array= {4, 3, 2, 1};
        int[] array2 = {2, 3, 4, 1, 5 };
        int[] array3 = {1, 3, 5, 2, 4, 6, 7};
        System.out.println("-----sample 1------");
        System.out.println(minimumSwaps(array));
        System.out.println("-----sample 2------");
       //System.out.println(minimumSwaps(array2));
        System.out.println("-----sample 3------");
       // System.out.println(minimumSwaps(array3));
    }
}
