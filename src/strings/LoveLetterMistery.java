package strings;

public class LoveLetterMistery {

    public static int theLoveLetterMystery(String s) {
        // Write your code here
        int st = 0, len = s.length()-1;
        int count = 0;
        while (st < len) {
            if (s.charAt(st) != s.charAt(len)){
                count+=(Math.abs((s.charAt(st)-'0')-(s.charAt(len)-'0')));
            }
            st++;
            len--;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print(theLoveLetterMystery("abc"));//2
        System.out.print(theLoveLetterMystery("abcba"));//0
        System.out.print(theLoveLetterMystery("abcd"));//4
        System.out.print(theLoveLetterMystery("cba"));//2
    }
}
