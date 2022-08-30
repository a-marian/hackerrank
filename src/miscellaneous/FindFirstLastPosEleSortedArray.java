package miscellaneous;

import java.util.Arrays;
import java.util.Hashtable;


public class FindFirstLastPosEleSortedArray {

    public static int[] searchRange(int[] nums, int target) {

    Hashtable<Integer, Integer> targetSet = new Hashtable<>();
    int targetCount = 0;

        for (int i = 0; i < nums.length; i++) {
                if(nums[i] == target){
                    targetSet.put(targetCount, i);
                    targetCount++;
                }
        }
        int[]result= new int[2];
        int lastTargetPos= targetSet.size()-1;
        if (targetSet.size() > 0){
            result[0] = targetSet.get(0);
            result[1]= targetSet.get(lastTargetPos);
            return  result;
        }
        result[0] = -1;
        result[1]= -1;
        return result;
    }

    public static void main(String[] args) {
        int[]example1= {5,7,7,8,8,10};
        int target1= 8;
        int[]exArray1 = searchRange(example1, target1); //[3,4]
        Arrays.stream(exArray1).forEach(r ->System.out.print(r+" "));
        System.out.println();
        int[]example2= {5,7,7,8,8,10};
        int target2= 6;
        int[]exArray2 = searchRange(example2, target2); //[-1,-1]
        Arrays.stream(exArray2).forEach(r ->System.out.print(r+" "));

    }
}
