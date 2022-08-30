//https://www.hackerrank.com/challenges/recursive-digit-sum/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
package dynamicProgramming;

public class RecursiveDigitSum {

    public static int superDigit(String n, int k){

        if (n.length() > 1){
            long sum = 0;
            for (int i = 0; i < n.length(); i++) {
                sum+= Character.getNumericValue(n.charAt(i));
            }
            return superDigit(Long.toString(sum*k),1);
        }else{
            return Character.getNumericValue(n.charAt(0));
        }



    }

    public static void main(String[] args) {
        //9875 4
        int result1 = superDigit("9875", 4);
        System.out.println(result1);
        //148 3
        int result2 = superDigit("148", 3);
        System.out.println(result2);
    }
}
