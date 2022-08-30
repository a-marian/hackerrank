package thirtydays;
import java.io.*;
import java.util.Scanner;
import java.util.stream.*;

class Bitwise {

    /*
     * Complete the 'bitwiseAnd' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER K
     */

    public static int bitwiseAnd(int N, int K) {
        // Write your code here
        if ((K-1 | K) <= N){
            return K-1;
        }
        return K-2;
    }

}

public class BitwiseAND {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        IntStream.range(0, t).forEach(tItr -> {
                int count = scanner.nextInt();
                int lim = scanner.nextInt();
                int res = Bitwise.bitwiseAnd(count, lim);
                System.out.println(res);
        });


    }
}
