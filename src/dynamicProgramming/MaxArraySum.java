package dynamicProgramming;

import java.util.Scanner;

public class MaxArraySum {

    private  static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
       int n = in.nextInt();
       int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = in.nextInt();
            arr[i] = arrItem;
        }

        int res= maxSubsetSum(arr);
        System.out.println(res);
        in.close();

    }


    private static int maxSubsetSum(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[1];

            int n = arr.length;
             arr[0] = Math.max(0, arr[0]);
             arr[1] = Math.max(arr[0], arr[1]);

            for (int i = 2; i < n; i++) {
                    arr[i] = Math.max(arr[i-1], arr[i] + arr[i-2]);
                }
            return arr[n-1];
    }

}
