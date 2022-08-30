package miscellaneous;

import java.util.Arrays;
import java.util.TreeSet;

public class PlatesBetweenCandles {
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        char[] starray = s.toCharArray();
        int []res = new int [queries.length];
        for (int i = 0; i < starray.length; i++) {
            int platesCount = 0;
            for (int k = 0; k < queries.length; k++) {
                    if((i >= queries[k][0] && i <= queries[k][1]) && starray[i] == '*'){
                        platesCount++;
                        res[k] += platesCount;
                    }
                platesCount=0;
            }
            }
        return  res;
        }

    public static int[] platesBetweenCandlesTree(String s, int[][] queries) {
        int len = s.length();
        int[] left = new int[len];
        TreeSet<Integer>candles = new TreeSet<>();
        int leftPlateCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|'){
                candles.add(i);
                left[i]= leftPlateCount;
            }else {
                leftPlateCount++;
            }
        }
        int[] result = new int[queries.length];
        int i=0;
        for (int query[]:queries) {
            Integer leftMostCandle= candles.ceiling(query[0]);
            Integer rightMostCandle= candles.floor(query[1]);
            if(leftMostCandle!= null && rightMostCandle != null && leftMostCandle < rightMostCandle)
                result[i] = left[rightMostCandle]-left[leftMostCandle];
            i++;
        }
        return result;
    }


    public static void main(String[] args) {
        String st1 = "**|**|***|";
        int[][] queries1 = {{2,5},{5,9}};
        int[] res = platesBetweenCandles(st1, queries1);
        Arrays.stream(res).forEach(r -> System.out.print(r+" "));
        System.out.println();
        System.out.println("======================");
        String st2 = "***|**|*****||**|*";
        int[][] queries2 = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        int[] res2 = platesBetweenCandlesTree(st2, queries2);
        Arrays.stream(res2).forEach(r -> System.out.print(r+" "));
    }
}
