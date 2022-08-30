package thirtydays;

import java.util.HashMap;
import java.util.Map;

public class RuntimeComplexity {

    public static int findNumsOfRepetitions(String s, char c){
        //Linear time; O(n) time
        int sum = 0;
        for (int i = 0; i < s.length(); i++) { // 1, n+1, n
            if(s.charAt(i) == c){ //n
                sum++; //n
            }
        }
        return sum; //1
    }

    public static int[] findNumsOfRepetitionsv1(String s, char[] c){
        // Quad time: O(n*m) time
        int[] sum = new int[s.length()]; //1
        for (int i = 0; i < s.length(); i++) { // 1, n+1, n
            for (int j = 0; j < c.length; j++) { // n+1, n*m +1, n*m
                if(s.charAt(i) == c[j]) { // n*m
                    sum[j] = sum[j] + 1; //n*m
                }
            }
        }
        return sum; //1
    }

    //improving complexity
    public static int[] findNumsOfRepetitionsv2(String w, char[] c){
        //

        Map<Character, Integer> memo= new HashMap<>();
        for (int i = 0; i < w.length(); i++) { // 1,
                if (memo.containsKey(w.charAt(i))){
                    memo.put(w.charAt(i), memo.get(w.charAt(i))+1);
                }else{
                    memo.put(w.charAt(i), 1);
                }
        }
        int[] sum = new int[w.length()]; //1
        for (int i = 0; i < c.length; i++) { // 1,
                if(!memo.containsKey(c[i])){
                    sum[i] = 0;
                }else{

                    sum[i] = memo.get(c[i]);
                }
        }
        return sum; //1
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(findNumsOfRepetitionsv1(
                "sdfjshdfweirsdfsdjfweoirukwerwqwweurqqwpoakjshdas8eroerscn,x",
                "sdfsdfjsdlfkjsdñflksdfwerweweroweirrsdf".toCharArray())
        );
        long endTime = System.currentTimeMillis();
        long duration= endTime - startTime;
        System.out.println("Test " + duration + " ms");
        System.out.println();

        startTime = System.currentTimeMillis();
        System.out.println(findNumsOfRepetitionsv2(
                "sdfjshdfweirsdfsdjfweoirukwerwqwweurqqwpoakjshdas8eroerscn,x",
                "sdfsdfjsdlfkjsdñflksdfwerwersdf".toCharArray()));
        endTime = System.currentTimeMillis();
        duration= endTime - startTime;
        System.out.println("Test " + duration + " ms");
    }
}
