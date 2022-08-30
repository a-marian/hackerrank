package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Candies {

    public static long candies(int n, List<Integer> arr) {
        // Write your code here
        if(n == 0) return 0;
        int[] candyBox = new int[n];
        Arrays.fill(candyBox, 1);
        long candies = 1;
        for (int i = 0; i < n-1; i++) {
            if (arr.get(i+1) > arr.get(i)) {
                candyBox[i+1]= candyBox[i] +1;
            }
        }

        for (int i = n-1; i > 0 ; i--) {
            if((arr.get(i-1)> arr.get(i)) && (candyBox[i-1] <= candyBox[i])){
              candyBox[i-1]= candyBox[i] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            candies+=candyBox[i];
        }
        return candies;
    }


    private  static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        //int[] arr = new int[n];
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = in.nextInt();
           arr.add(arrItem);
        }

        long res= candies(n, arr);
        System.out.println(res);
        in.close();

    }

}
