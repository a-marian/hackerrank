package miscellaneous;

import java.io.*;

public class CountingValleys {
    //We only care about the number of valleys..
    // So just figure out the number of times you came back to sea level.
    public static int countingValleys(int steps, String path) {
        // Write your code here
        int countValleys = 0;
        int valley = 0;

        for (int s = 0; s < path.length(); s++) {

            if (path.charAt(s) == 'U') {
                valley = valley +1;
            }else if (path.charAt(s) == 'D') {
                valley = valley -1;
            }
            if (valley == 0 && path.charAt(s) == 'U') {countValleys++;}
        }

        return  countValleys;

    }
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //int steps = sc.nextInt();
        //String path = sc.next();

        //int result = countingValleys(steps, path);
        //System.out.println(result);
        System.out.println(countingValleys(10, "UDUUUDUDDD"));
        System.out.println(countingValleys(10, "DUDDDUUDUU"));
        System.out.println(countingValleys(10, "DDUDDUUDUU"));
        System.out.println(countingValleys(100, "DDUUDDDUDUUDUDDDUUDDUDDDUDDDUDUUDDUUDDDUDDDUDDDUUUDUDDDUDUDUDUUDDUDUDUDUDUUUUDDUDDUUDUUDUUDUUUUUUUUU"));
        System.out.println(countingValleys(100, "UDUDDUUUDUDUDUUDUUDDDDDUDUDDDDUUDDUDDUUUUDUUDUDDDDUDUDUUUDDDUUUDUDDUUDDDUUDDUDDDUDUUDUUDUUDUDDDUUUUU"));



    }
}

