package dynamicProgramming;

import java.util.Scanner;

public class Abbreviation {

    /**
     *     public static String abbreviation(String a, String b) {
     *         String res = "YES";
     *         if (a.toUpperCase().equals(b)) return res;
     *         List<Character> aresultant = new ArrayList<Character>();
     *         char[] asplit = a.toUpperCase().toCharArray();
     *         int index = 0;
     *         char valRef = b.charAt(index);
     *
     *         for (int i = 0; i < asplit.length; i++) {
     *             if (asplit[i] == valRef){
     *                 aresultant.add(asplit[i]);
     *                 if(index == b.length()-1) {
     *                     break;
     *                 } else{
     *                     index = index+1;
     *                     valRef = b.charAt(index);
     *                 }
     *             }
     *         }
     *         if (aresultant.size() != b.length()){
     *             res = "NO";
     *         }
     *         return res;
     *     }
     * */

    public static String abbreviation(String a, String b) {
        boolean[][] isValid = new boolean[a.length()+1][b.length()+1];
        isValid[0][0] = true;

        for (int i= 1; i <= a.length(); i++) {
            if (Character.isUpperCase(a.charAt(i - 1))) {
                isValid[i][0] = false;
            }
            else isValid[i][0] = true;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    isValid[i][j] = isValid[i-1][j-1];
                }else if (Character.toUpperCase(a.charAt(i-1))  ==  b.charAt(j-1)) {
                    isValid[i][j] = isValid[i-1][j-1] || isValid[i-1][j];
                }else if (Character.isUpperCase(a.charAt(i-1))) {
                    isValid[i][j] = false;
                }else {
                    isValid[i][j] = isValid[i-1][j];
                }
            }
        }
        return isValid[a.length()][b.length()]? "YES" : "NO";
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String a = sc.next();
            String b = sc.next();
        sc.close();
        System.out.println(abbreviation(a, b));

    }

}
