package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxMin {

    public static int maxMin(int k, List<Integer> arr){
        int answer = Integer.MAX_VALUE;
        Collections.sort(arr);

        for (int i = 0; i + k -1 < arr.size(); i++) {
            answer = Math.min(answer, arr.get(i+k-1) - arr.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {

        List<Integer> test1= new ArrayList<>(Arrays.asList(10,100,300, 200, 1000, 20, 30));
        int k = 3;
        System.out.println(maxMin(k, test1));
    }
}
