package dictionaries;

import java.util.*;

public class SherlockAndAnagrams {

    public static int sherlockAndAnagrams(String s) {

        char[] sarray = s.toCharArray();
        // base cases
        if (sarray.length == 2 && sarray[0] == sarray[1]) return 1;
        if (sarray.length == 2 && sarray[0] != sarray[1]) return 0;

        Map<String, Integer> memoValuesCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char[] value = s.substring(i, j+1).toCharArray();
                Arrays.sort(value);
                String keyValue = new String(value);
                if (memoValuesCount.containsKey(keyValue)){
                    memoValuesCount.put(keyValue, memoValuesCount.get(keyValue)+1);
                }else {
                    memoValuesCount.put(keyValue, 1);
                }
            }
        }

        int result = 0;
        for (Map.Entry<String, Integer> m: memoValuesCount.entrySet()) {
            int  iterations =  (m.getValue() * (m.getValue()-1))/2;
            result = result + iterations;

        }
        return result;
    }


    public static void main(String[] args) {
    /** success
      String st1 = "abba";
        System.out.println(sherlockAndAnagrams(st1));//4
       String st2 = "abcd";
       System.out.println(sherlockAndAnagrams(st2));//0
        String st3 = "ifailuhkqq";
        System.out.println(sherlockAndAnagrams(st3));//3
        String st5 = "cdcd";
         System.out.println(sherlockAndAnagrams(st5));//5

        String st4 = "kkkk";
        System.out.println(sherlockAndAnagrams(st4));//10
        */
        String stsub1 = "ifailuhkqqhucpol";
        String stff = "ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel";
        String stf1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String stf2 = "bbcaadacaacbdddcdbddaddabcccdaaadcadcbddadababdaaabcccdcdaacadcababbabbdbacabbdcbbbbbddacdbbcdddbaaa";
        String stf3 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String stf4 = "cacccbbcaaccbaacbbbcaaaababcacbbababbaacabccccaaaacbcababcbaaaaaacbacbccabcabbaaacabccbabccabbabcbba";
        String stf6 = "bbcbacaabacacaaacbbcaabccacbaaaabbcaaaaaaaccaccabcacabbbbabbbbacaaccbabbccccaacccccabcabaacaabbcbaca";
        String stf7 = "cbaacdbaadbabbdbbaabddbdabbbccbdaccdbbdacdcabdbacbcadbbbbacbdabddcaccbbacbcadcdcabaabdbaacdccbbabbbc";
        String stf8 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String stf9 = "babacaccaaabaaaaaaaccaaaccaaccabcbbbabccbbabababccaabcccacccaaabaccbccccbaacbcaacbcaaaaaaabacbcbbbcc";
        String stf10= "bcbabbaccacbacaacbbaccbcbccbaaaabbbcaccaacaccbabcbabccacbaabbaaaabbbcbbbbbaababacacbcaabbcbcbcabbaba";

        System.out.println(sherlockAndAnagrams(stsub1));
        System.out.println(sherlockAndAnagrams(stf1));
        System.out.println(sherlockAndAnagrams(stff));
        System.out.println(sherlockAndAnagrams(stf2));
        System.out.println(sherlockAndAnagrams(stf3));
        System.out.println(sherlockAndAnagrams(stf4));
        System.out.println(sherlockAndAnagrams(stf6));
        System.out.println(sherlockAndAnagrams(stf7));
        System.out.println(sherlockAndAnagrams(stf8));
        System.out.println(sherlockAndAnagrams(stf9));
        System.out.println(sherlockAndAnagrams(stf10));
    }
}


