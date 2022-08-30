package greedy;

/**Variation problem
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * [0,1,2,4,5,6,7]  might become [4,5,6,7,0,1,2]
 * find the minimum element.
 * You may assume no duplicate exists in the array.
 * Example: Input [3,4,5,1,2] -> Output: 1
 * */

public class FindMinimumRotatedSortedArray {

    public static int findMin(int[] nums){
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        int left = 0;
        int right = nums.length -1;

        while (left < right){
            int midpoint = left + (right -left)/2;
            if(midpoint > 0 && nums[midpoint] < nums[midpoint-1]){
                return nums[midpoint];
            } else if (nums[left] <= nums[midpoint] && nums[midpoint] > nums[right]) {
                left = midpoint + 1;
            } else {
                right = midpoint -1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {

        int[]array = { 3, 4, 5, 1, 2};
        System.out.println(findMin(array));

    }
}

