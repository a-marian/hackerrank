package miscellaneous.stackAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class IceCreamPArlor {

    public static void whatFlavors(List<Integer> cost, int money) {
        // Write your code here
        int[] res= getFlavoursIndex(cost, money);
        for (int i = res.length-1; i >=0; i--) {
            System.out.print(res[i]+1+" ");
        }
        System.out.println();
    }

    static int[] getFlavoursIndex(List<Integer> cost, int money){
        int []res = new int [2];
        Hashtable<Integer, Integer> memo = new Hashtable<>();
        for (int i = 0; i <cost.size(); i++) {
            Integer flavorToBuyIndex = memo.get(cost.get(i));
            if (flavorToBuyIndex != null){
                return new int[]{Integer.valueOf(i),flavorToBuyIndex};
            }
            memo.put(money-cost.get(i), i);
        }
        return  res;
    }

    public static void main(String[] args) {
        List<Integer> costs1 = new ArrayList<>(Arrays.asList(7,2,5,4,11));
        int money1 = 12 ;
        whatFlavors(costs1, money1);
        System.out.println("-------------------------");
        List<Integer> costs = new ArrayList<>(Arrays.asList(4,3,2,5,7));
        int money = 8 ;
        whatFlavors(costs, money);
        System.out.println("-------------------------");
        List<Integer> costs2 = new ArrayList<>(Arrays.asList(7, 2, 5, 4, 11));
        int money2 = 12;
        whatFlavors(costs2, money2);



    }

}

