package dynamicProgramming;

import java.util.ArrayList;

/**
 * https://www.geeksforgeeks.org/perfect-sum-problem-print-subsets-given-sum/
 * Given an array arr[] of integers and an integer K, the task is to print all subsets
 * of the given array with the sum equal to the given target K
 *
 * Input: arr[] = {5, 10, 12, 13, 15, 18}, K = 30
 * Output: {12, 18}, {5, 12, 13}, {5, 10, 15}
 * Explanation:
 * Subsets with sum 30 are:
 * 12 + 18 = 30
 * 5 + 12 + 13 = 30
 * 5 + 10 + 15 = 30
 *
 * Input: arr[] = {1, 2, 3, 4}, K = 5
 * Output: {2, 3}, {1, 4}
 * */

public class PerfectSum {

    static boolean[][] dp;
    
    public static void main(String[] args) {
        int arr[] = {5, 10, 12, 13, 15, 18};
        int K = 30;
        findSubSets(arr, K);
    }

    private static void findSubSets(int[] arr, int k) {
        int arrsize = arr.length;
        if(arr.length == 0 || k == 0) return;

        //sum 0 can always be achieved with 0 elements
        dp = new boolean[arrsize][k+1];
        for (int i = 0; i < arrsize; i++) {
            dp[i][0]= true;
        }
        //sum arr[0] can be achieved with single element
        if(arr[0] <= k)
            dp[0][arr[0]] = true;
        
        //fill rest of the entries in dp[][]
        for (int i = 1; i < arrsize; ++i) {
            for (int j = 0; j < k+1; ++j) {
                dp[i][j] =(arr[i] <= j) ? (dp[i-1][j] || dp[i-1][j-arr[i]]):dp[i-1][j];
            }
        }
        if(dp[arrsize-1][k] == false){
            System.out.println("There are no subsets with " + k);
            return;
        }
        
        //now recursively traverse dp[][] to find all paths from dp[n-1][k]
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(arr, arrsize-1, k, p);
    }

    private static void printSubsetsRec(int[] arr, int i, int k, ArrayList<Integer> p) {
        //if we reached end and sum is non-zero. We print p[] only if arr[0] is equal
        // to k or dp[0][k] is true
        if(i == 0 && k!= 0 && dp[0][k]){
            p.add(arr[i]);
            display(p);
            p.clear();
            return;
        }
        //if k becomes 0
        if (i == 0 && k == 0) {
            display(p);
            p.clear();
            return;
        }
        //if given k can be achieved after ignoring current element
        if(dp[i-1][k]){
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, i-1, k, b);
        }

        //if given k can be achieved after considering current element.
        if(k >= arr[i] && dp[i-1][k-arr[i]]){
            p.add(arr[i]);
            printSubsetsRec(arr, i-1, k -arr[i], p);
        }
    }

    private static void display(ArrayList<Integer> pv) {
        System.out.println(pv);
    }
}
