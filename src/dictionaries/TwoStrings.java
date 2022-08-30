package dictionaries;

import java.util.HashMap;
import java.util.Map;

public class TwoStrings {
    static Map<Character, Integer> memo = new HashMap<>();

    private static Map<Character, Integer> getCharactersFromString(char[] array){

        for (int i = 0; i < array.length; i++) {
            if (!memo.containsKey(array[i])){
                memo.put(array[i], 1);
            }
        }
        return memo;
    }
    private static String findSubstringInMemo(char[] array){
        for (int i = 0; i < array.length; i++) {
            if( memo.containsKey(array[i])){
                return "YES";
            }
        }
        return "NO";
    }
    public static String twoStrings(String s1, String s2) {
        // Write your code here
        String response = "NO";
        //taking into account this constraint s1 ,s2 >= 1
        if (s1.length() == 1 && s2.length() == 1 && s1.equals(s2)) return "YES";
        if (s1.length() == 1 && s2.length() == 1 && !s1.equals(s2)) return response;

        //For strings  with more than one character
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        memo.clear();
        if(s1Array.length >= s2Array.length){
            getCharactersFromString(s2Array);
           return findSubstringInMemo(s1Array);
        }else{
            getCharactersFromString(s1Array);
            return  findSubstringInMemo(s2Array);
        }

    }

    public static void main(String[] args) {
        String st1 = "hello";
        String st2 = "world";
        System.out.println("---sol1--");
        System.out.println(twoStrings(st1,st2));
        String stA = "hi";
        String stB = "world";
        System.out.println("---sol2--");
        System.out.println(twoStrings(stA,stB));
    }
}
