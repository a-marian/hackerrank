package thirtydays;
import java.util.*;

public class PrimeComplexity {

    public static String isPrimeBF(int number){


        for (int i = 2; i*i <= number; i++) {
            if(number % i == 0) number =1;
        }
        return (number == 1) ?  "Not prime" : "Prime";

    }



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            int divisors = 0;
            System.out.println(isPrimeBF(number));
        }
        sc.close();
    }
}
