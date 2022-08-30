package dynamicProgramming;
/**
 * Given a string s consisting of small english letters, find and return the first instance
 * of a non-repeating character in it. If there is no such character return '_'.
 * Input string contains only lowercase english letters length : -1 <= N <= 100000
 * Example:
 *   "aaadcccc" return 'd'
 *   "aaabcccdeeeef" return 'b´
 *   "abcabcabc"  return '_'
 */

public class FindFirstCharacterNotRepeated {

    static char firstNotRepeatedCharacter(String s){
        int[] charCounts = new int[26];
        //linear time
        for (char c: s.toCharArray()) charCounts[c - 'a']++;

        for(char c: s.toCharArray()){
            if(charCounts[c - 'a'] == 1) return c;
        }
        return '_';
    }

    static char firstNotRepeatedCharacterIndex(String s){
        for (int i = 0; i < s.length() ; i++) {
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return s.charAt(i);
            }
        }
        return '_';
    }


    public static void main(String[] args) {
        System.out.println(firstNotRepeatedCharacter("aaabcccdeeeef"));

        System.out.println(firstNotRepeatedCharacter("abcabcabc"));

        System.out.println(firstNotRepeatedCharacterIndex("aaabcccdeeeef"));

    }
}
