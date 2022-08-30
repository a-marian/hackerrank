package recursion;

import java.util.Scanner;

public class StringReversal {

    public static String reverseString(String input){
        if(input.equals(""))return "";
        return reverseString(input.substring(1)) + input.charAt(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        in.close();
        System.out.println(reverseString(str));
    }
}
