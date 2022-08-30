package thirtydays;

import java.util.List;

public class MiniMaxSum {



    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long min = arr.get(0);
        long max = min;
        long sum = max;

        for(int i = 1; i < 5; i++){
            long num = Long.valueOf(arr.get(i));
            sum +=  num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        System.out.println((sum-max)+" "+(sum-min));
    }
}
