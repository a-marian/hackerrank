package sorting;

import java.util.Arrays;
import java.util.List;

public class InsertingSort2 {

    public static void printInterim(List<Integer> arr){
        for (Integer val : arr) {
            System.out.print(val+ " ");
        }
        System.out.println();
    }

    public static void insertionSort2(int n, List<Integer> arr) {
        for(int i= 1; i<arr.size(); i++){
            int key = arr.get(i);
            int j = i-1;

            while(j>=0 && arr.get(j)>key){
                arr.set(j+1, arr.get(j));
                j--;
            }

            arr.set(j+1, key);
            printInterim(arr);
        }
    }

    public static void main(String[] args) {
        List<Integer> array3 = Arrays.asList(3, 4, 7, 5, 6, 2, 1);

        insertionSort2(array3.size(), array3);
    }
}
