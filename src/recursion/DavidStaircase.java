/**
 *
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
 * */
package recursion;

import java.util.*;

public class DavidStaircase {
    private  static final Scanner in = new Scanner(System.in);
    public static Map<Integer, Integer> memo = new HashMap<>();
    public static int stepPerms(int n) {

        //What is the base case??
        ///When can I no longer continue?
        //What is the smallest amount of work I can do in each iteration?
        ////What is the smallest amount of work I can do to contribute the goal?

         int res = 0;
         if (n == 0) return 1;
         if (memo.containsKey(n)) return memo.get(n);

         if (n >= 0)
             res = stepPerms(n - 1) + stepPerms(n-2) + stepPerms(n-3);
            memo.put(n, res);
         return res;


     }



    public static void main(String[] args) {
        List<Integer> memo = new ArrayList<>();

        System.out.println(stepPerms(5));
        System.out.println(stepPerms(7));
        System.out.println(stepPerms(12));
        in.close();
    }
}
