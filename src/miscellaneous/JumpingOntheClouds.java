package miscellaneous;
//https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpingOntheClouds {

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int response = 0;

        int jump = 0;
        int jumpCount = 0;
        int size = c.size()-2;
        while (jump <= size) {
            if (c.get(jump+1) == 1) {
                jump = jump +2;
                jumpCount++;
            } else if (c.size() > jump+2 && c.get(jump+2) == 0) {
                    jump = jump + 2;
                    jumpCount++;
                }else {
                jump = jump + 1;
                jumpCount++;
            }
        }
        return  jumpCount;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0,1,0,0,1,0));
        //
      // System.out.println( jumpingOnClouds(list));
        System.out.println( jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0))));
        System.out.println( jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 0,1, 0, 0, 0, 0, 1, 0, 0))));
    }
}


