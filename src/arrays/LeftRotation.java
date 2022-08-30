package arrays;

import java.util.Arrays;
import java.util.List;


public class LeftRotation {

// brute force
    public static List<Integer> rotLeft(List<Integer> a, int d) {

       if (d> 0){
           int firstValue = a.get(0);
           for (int j = 0; j < a.size()-1; j++) {
               a.set(j, a.get(j+1));
           }
           a.set(a.size()-1, firstValue);
           return rotLeft(a, d-1);
       } else {
           return a;
        }
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);
        int rotations = 4;
        System.out.println(rotLeft(a, rotations));

    }
}
