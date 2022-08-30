//https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
package sorting;

import java.util.Arrays;
import java.util.List;

public class BubbleSortHack {

    public static void printInterim(List<Integer> arr){
        for (Integer val : arr) {
            System.out.print(val+ " ");
        }
        System.out.println();
    }

    private static void swap(int current, int minor){
        int temp = current;
        current =  minor;
        minor = temp;
    }
    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int size = a.size();
        int swapsCount = 0;
        for (int i = 0; i < size; i++) {
            int minPosition = i;
            for (int j = i+1; j < size; j++) {
                //swap adjacent elements if they are in decreasing
                if(a.get(j) < a.get(minPosition)){
                    //swap(a.get(j), a.get(minPosition));
                    int temp = a.get(j);
                    a.set(j, a.get(minPosition));

                    a.set(minPosition, temp);
                    printInterim(a);

                    swapsCount++;
                }
            }
        }
        int firstElement = a.get(0);
        int lastElement = a.get(size-1);
        System.out.println("Array is sorted in "+ swapsCount +" swaps.");
        System.out.println("First Element: "+ firstElement);
        System.out.println("Last Element: "+ lastElement);

    }

    public static void main(String[] args) {

        List<Integer> array = Arrays.asList( 1, 2, 3);
        List<Integer> array2 = Arrays.asList( 2, 1, 3,1, 2);
        countSwaps(array2);
        System.out.println("-----------------------");
        List<Integer> array3 = Arrays.asList(3, 2, 1);
        countSwaps(array3);
    }
}
