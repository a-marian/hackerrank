package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class GreedyFlorist {

    static int getMinimumCost(int k, int[] c) {

        int cost = 0;
        int multiply = 1;

        Integer[] carray = Arrays.stream(c).boxed().toArray(Integer[]::new);
        Arrays.sort(carray, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1 * Integer.compare(o1, o2);
            }
        });

        for (int i = 0; i < carray.length; i++) {
            cost += carray[i] * multiply;
            if ((i+1) % k == 0){
                multiply +=1;
            }
        }
        return cost;
    }

    public static void main(String[] args) {

        int[] c = {1,3,5,7,9};
        int k= 3;
        System.out.println(getMinimumCost(k,c));

        // 1 3 5 7 9
        // 9 7 5 3 1
        // cost 9*1 + 7*1 + 5*1 + 3*2 + 1*2 = 29
    }

}
