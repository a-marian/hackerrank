package miscellaneous;

public class RepeatedString {

    public static long repeatedString(String s, long n ){


        if (s.length()  ==1 && s.charAt(0)== 'a') return n;
        if (s.length()  ==1 && s.charAt(0) != 'a') return 0;

        int slength = (int) n;
        char[] newWord = new char[slength];
        char[] sword = s.toCharArray();
        int incrementNW = 0 ;
        int countA = 0;
        while (incrementNW <= n-1){
            for (char schar : sword) {
                newWord[incrementNW] = schar;
                if (newWord[incrementNW] == 'a') {countA = countA + 1;}
                incrementNW++;
                if(incrementNW == n){
                    break;
                }
            }
        }
        return countA;
    }

    public static long repeatedStringComplexity(String s, long n ){
        int count=0, countRemaining=0;
        int rem = (int) n % s.length();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a')
                count++;

            if (i == rem -1)
                countRemaining = count;
        }
        return  ((long) count*(n/s.length())+(long) countRemaining);
    }


    // streams
    //linear time complexity on the length of the string
    //constant space complexity (chars works with the string underlying bytearrray)
    public static long repeatedStringStreams(String s, long n ){
        if (s.length()  ==1 && s.charAt(0)== 'a') return n;
        if (s.length()  ==1 && s.charAt(0) != 'a') return 0;

        long  countAInString = s.chars().filter(c -> c == 'a').count();
        long repeats = n / s.length();
        long remaining = n % s.length();
        long countAInRemaining = s.chars().limit(remaining).filter(c -> c == 'a').count();
        return repeats * countAInString + countAInRemaining;
    }

    public static void main(String[] args) {
        System.out.println("Brute force works for some cases");
        System.out.println(repeatedString("aba", 10));
        long n2 = 1000000000000L;
        System.out.println(repeatedStringStreams("a", n2 ));
        System.out.println("Improved complexity");
        System.out.println(repeatedStringComplexity("baa", 10 ));
        System.out.println(repeatedStringComplexity("aab", 10 ));
        System.out.println("workng with streams");
        System.out.println(repeatedStringStreams("baa", 10 ));
        System.out.println(repeatedStringStreams("aab", 10 ));
    }
}
