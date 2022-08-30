package sorting;


import java.lang.reflect.Array;
import java.util.*;

public class Toys {

    static boolean[][] dp;

    public static void main(String[] args) {


        List<Integer> values3 = Arrays.asList(3, 7, 2, 9, 4);
        int k3 = 15;
        int result3 = findMaximumToysToBuy(values3, k3);
        System.out.println(result3);
        //response 4

        List<Integer> values4 = Arrays.asList(1,2,3,4);
        int k4= 7;
        System.out.println(findMaximumToysToBuy(values4, k4));

        List<Integer> values2 = Arrays.asList(1, 12, 5, 111,  200,  1000, 10);
        int k2 = 50;
        int result2 = findMaximumToysToBuy(values2, k2);
        System.out.println(result2);
        //response 3

        List<Integer> values = Arrays.asList(1, 2, 3, 4);
        int k = 7;
        int result = findMaximumToysToBuy(values, k);
        System.out.println(result);
        //response -> 3

    }


    private static int findMaximumToysToBuy(List<Integer> arr, int k) {
        int[] toysToBuy = new int[arr.size()+1];
        int maxPrice = k/2;
        int gifts = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (k - arr.get(i) >= maxPrice){
                toysToBuy[i] = arr.get(i);
            }
        }
        Arrays.sort(toysToBuy);
        int moneyspent = 0;
        for (int toy: toysToBuy) {
            if(toy > 0 && moneyspent + toy <= k){
                moneyspent += toy;
                gifts++;
            }
        }
        return gifts;
    }

}
