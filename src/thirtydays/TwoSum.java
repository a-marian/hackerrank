package thirtydays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and a integer target, return indices of the two
 * numbers such that they add up to target.
 * You may assume that each input would have exactly one solution and you may not use
 * the same element twice.
 * You can return the answer in any order.
 * Example:
 *  Input: nums = [2, 7, 11, 15], target=9
 *  Output: [0,1]
 *  Explanation: Because nums[0] + num[1] == 9 => we return [0,1]
 *  */
public class TwoSum {

    public static int[] sumtwo(int [] arr, int target){

        for (int i = 0; i < arr.length; i++) {

            for (int j = i+1; j < arr.length ; j++) {
                return new int[]{i,j};
            }
        }
        return arr;
    }

    public static int[] sumtwoFaster(int [] arr, int target){
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer complementIndex = memo.get(arr[i]);
            if(complementIndex != null){
                return new int[]{i, complementIndex};
            }
            memo.put(target-arr[i], i);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] array1 = {2, 7, 11, 15};
        int target1 = 9;
       int [] result = sumtwoFaster(array1, target1);
        Arrays.stream(result).forEach(r -> System.out.print(r+" "));
    }
}
