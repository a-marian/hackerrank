package miscellaneous.stackAndQueues;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
///Given an integer array. The task is to find thre maximum of
// the minimum of every window size in the array.
//

public class MinMaxRiddle {

    static long[] riddle(long[] arr) {
        // complete this function
        int arrlen = arr.length;
        Stack<Integer> stacky = new Stack<>();

        long[] left = new long[arrlen+1];
        long[] right= new long[arrlen+1];

        Arrays.fill(left, -1);
        Arrays.fill(right, arrlen);

        for (int i = 0; i < arrlen; i++) {
            while(!stacky.empty() && arr[stacky.peek()] >= arr[i])
                stacky.pop();

            if (!stacky.empty())
                left[i] = stacky.peek();

            stacky.push(i);
        }

        while (!stacky.empty())
            stacky.pop();

        for (int i = arrlen-1; i >=0 ; i--) {
            while (!stacky.empty() && arr[stacky.peek()] >= arr[i])
                stacky.pop();

            if(!stacky.empty())
                right[i] = stacky.peek();

            stacky.push(i);
        }

        long[] response = new long[arrlen+1];

        for (int i = 0; i < arrlen; i++) {
            long len = right[i] - left[i] - 1;
            response[(int)len] = Math.max(response[(int)len], arr[i] );
        }

        for (int i = arrlen-1; i >=1 ; i--) {
            response[i] = Math.max(response[i], response[i+1] );
        }

        int targetIndex = 0;
        long[] finalResponse = new long[arrlen];
        for (int i = 0; i <=arrlen ; i++) {
            if (response[i] != 0){
                finalResponse[targetIndex++]=response[i];
            }
        }

        return finalResponse;

    }

    public static void main(String[] args) {

        long[] test1 = new long[] {3,5,4,7,6,2};
        long[] restest1= riddle(test1);
        for (long v: restest1) {
            System.out.print(v);
        }
    }
}
