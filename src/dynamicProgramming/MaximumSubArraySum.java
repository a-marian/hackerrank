package dynamicProgramming;

import java.util.*;
//nice explanation
//https://www.quora.com/What-is-the-logic-used-in-the-HackerRank-Maximise-Sum-problem
public class MaximumSubArraySum {

    public static long maximumSum(List<Long> a, long m) {

        long[] prefix = new long[a.size()]; // set up prefix array
        prefix[0] = a.get(0) % m;
        for (int i = 1; i < a.size(); i++) prefix[i] = (prefix[i-1] + a.get(i)) % m;

        TreeSet<Long> ts = new TreeSet<>();
        long maxi = 0;
        for (int i = 0; i < a.size(); i++) {
            maxi = Math.max(maxi, prefix[i]);
            Long loo = ts.ceiling(prefix[i] + 1);
            if (loo != null) maxi = Math.max(maxi, (prefix[i] - loo + m) % m);
            ts.add(prefix[i]);
        }
        return maxi;
    }

    public static void main(String[] args) {
        List<Long> array4 = new ArrayList<>(Arrays.asList(1L, 5L, 9L));
        int mod4 = 5;
        System.out.println(maximumSum(array4, mod4));//4

        List<Long> array1 = new ArrayList<>(Arrays.asList(3L, 3L, 9L, 9L, 5L));
        int mod1 = 7;
        System.out.println(maximumSum(array1, mod1));//6

        List<Long> array2 = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        int mod2 = 2;
        System.out.println(maximumSum(array2, mod2));//1

        List<Long> array3 = new ArrayList<>(Arrays.asList(1L, 5L, 9L));
        int mod3 = 5;
        System.out.println(maximumSum(array3, mod3));//4

    }
}
