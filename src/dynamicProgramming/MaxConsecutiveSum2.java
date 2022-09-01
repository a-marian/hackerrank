package dynamicProgramming;
/** Given an array of integers, find the maximum possible sum you can get
 *  from one of its contiguous sub-arrays.
 *  The subarray from which this sum comes must contain at least 1 element.
 *  Example:
 *  For inputArray= [-2,2,5,-11, 6] the output should be 7
 *  Solution: kadane algorithm
 *
 *  Kadane algorithm is used to find:
 * (A) Maximum sum subsequence in an array
 * (B) Maximum sum subarray in an array
 * (C) Maximum product subsequence in an array
 * (D) Maximum product subarray in an array
 *  */

public class MaxConsecutiveSum2 {

    public int maxSubArray1(int[] nums) {
        if(nums.length <= 1) return nums[0];

        int maxSum = nums[0];
        int currentSum = maxSum;
        for(int i = 1 ; i < nums.length; i++){
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    static int arrayMaxConsecutiveSum2(int[] inputArray){
        int maxSum = inputArray[0];
        int currentSum = maxSum;
        for (int i = 0; i < inputArray.length; i++) {
            currentSum = Math.max(inputArray[i]+ currentSum, inputArray[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-2, 2,5, -11, 6};
        System.out.println(arrayMaxConsecutiveSum2(array));
    }

}
