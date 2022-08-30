//https://www.hackerrank.com/challenges/luck-balance/submissions/code/285475844?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
package greedy;

import java.util.*;

public class LuckBalance {
    public static int luckBalance(int k, List<List<Integer>> contests){
        int luckBalance = 0;

        Collections.sort(contests, new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer>b){
                return -1 * Integer.compare(a.get(0), b.get(0));
            }
        });

        for (int i = 0; i < contests.size(); i++) {
            int luck = contests.get(i).get(0);
            int importance = contests.get(i).get(1);

            if(importance == 1 && k > 0){
                k--;
                luckBalance += luck;
            } else if (importance == 1 && k == 0) {
                luckBalance -= luck;
            }
            if (importance == 0){
                luckBalance += luck;
            }
        }
        return  luckBalance;
    }

    public static void main(String[] args) {

        List<List<Integer>> test1 = new ArrayList<>(new ArrayList<>());
        int k = 3;
        test1.add(new ArrayList<>(Arrays.asList(5,1)));
        test1.add(new ArrayList<>(Arrays.asList(2,1)));
        test1.add(new ArrayList<>(Arrays.asList(1,1)));
        test1.add(new ArrayList<>(Arrays.asList(8,1)));
        test1.add(new ArrayList<>(Arrays.asList(10,0)));
        test1.add(new ArrayList<>(Arrays.asList(5,0)));
        System.out.println(luckBalance(k, test1));

    }

}
