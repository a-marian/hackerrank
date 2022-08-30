package strings;

import java.util.HashMap;
import java.util.Scanner;

public class StringManipulation {
    public static int commonChild(String s1, String s2) {
        //Initialize char counter occurrences in strings
        char[] st1= s1.toCharArray();
        char[] st2= s2.toCharArray();
        int st1Length = s1.length();
        int st2Length = s2.length();

        int mem[] = new int[st2Length+1];
        for (int i = 1; i <=  st1Length; i++) {
            int prev=0;
            for (int j = 1; j <= st2Length ; j++) {
                int temp= mem[j];
                if(st1[i-1] == st2[j -1]){
                    mem[j] = prev +1;
                } else {
                    mem[j] = Math.max(mem[j], mem[j-1]);
                }
                prev = temp;
            }
        }

    return  mem[st2Length];

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();
        System.out.println(commonChild(a, b));
    }
}

