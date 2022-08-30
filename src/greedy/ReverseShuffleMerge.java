package greedy;

import java.util.Stack;

public class ReverseShuffleMerge {

    public static String reverseShuffleMerge(String s) {
        // Write your code here
        int[] addCont = new int[26];
        int[] skipCont = new int[26];

        Stack<Character> stacky = new Stack<>();
        String response= "";

        char[]sarray = s.toCharArray();
        for (int i = 0; i < sarray.length; i++) {
            addCont[sarray[i]- 'a']++;
        }

        for (int i = 0; i < addCont.length; i++) {
            addCont[i] /= 2;
        }

        skipCont = addCont.clone();

        for (int i = sarray.length-1; i >=0; i--) {
            while (!stacky.empty() && stacky.peek() > sarray[i]
                    && addCont[sarray[i]-'a'] > 0
                    && skipCont[stacky.peek() - 'a'] > 0) {
                char c = stacky.pop();
                addCont[c - 'a']++;
                skipCont[c - 'a']--;
            }

            if(addCont[sarray[i]-'a'] > 0){
                stacky.push(sarray[i]);
                addCont[sarray[i]-'a']--;
            }else{
                skipCont[sarray[i]-'a']--;
            }
        }
        while (!stacky.empty()) {
            response = stacky.pop()+response;
        }

        return response;
    }

    public static void main(String[] args) {
        String st1= "eggegg";
        System.out.println(reverseShuffleMerge(st1));
        String st2 = "abcdefgabcdefg";
        System.out.println(reverseShuffleMerge(st2));
        String st3 = "aeiouuoiea";
        System.out.println(reverseShuffleMerge(st3));

    }

}
