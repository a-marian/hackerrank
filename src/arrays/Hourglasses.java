//https://www.hackerrank.com/challenges/30-2d-arrays/problem?isFullScreen=true
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hourglasses {
    public static int hourglassMax(List<List<Integer>> arr){
        int maximumValue = -63;
        int cols = arr.size();

        for (int i = 0; i < arr.size() -2; i++) {
            List<Integer> row = arr.get(i);
            for (int j = 0; j  < row.size()-2 ; j++) {
               int minvalue = (arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)
                                                     + arr.get(i+1).get(j+1)
                                        + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2));
                maximumValue = Math.max(minvalue, maximumValue);
            }
        }
        return maximumValue;
    }



    public static void main(String[] args) {

        List<List<Integer>> array = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,1,1,0,0,0));
        array.add(l1);
        List<Integer> l2 = new ArrayList<>(Arrays.asList(0,1,0,0,0,0));
        array.add(l2);
        List<Integer> l3 = new ArrayList<>(Arrays.asList(1,1,1,0,0,0));
        array.add(l3);
        List<Integer> l4 = new ArrayList<>(Arrays.asList(0,0,2,4,4,0));
        array.add(l4);
        List<Integer> l5 = new ArrayList<>(Arrays.asList(0,0,0,2,0,0));
        array.add(l5);
        List<Integer> l6 = new ArrayList<>(Arrays.asList(0,0,1,2,4,0));
        array.add(l6);

        System.out.println(hourglassMax(array));
    }
}
