package strings;

import java.util.Scanner;

public class AlternativeCharacters {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        in.close();
        System.out.println(alternatingCharacters(input));
    }

    private static int alternatingCharacters(String word){
        int deleteCounter = 0;
        char eqz = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char val = word.charAt(i);
            if(val == eqz){
                deleteCounter++;
            }
            eqz = val;
        }
        return deleteCounter;
    }
}
