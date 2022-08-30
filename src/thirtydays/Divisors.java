package thirtydays;


public class Divisors {

    public static int divisorSum(int n) {
        int sumdivisors = 0;
        for (int i = 1; i <= n; i++) {
            if ((n % i) == 0) {
                sumdivisors = sumdivisors +i;
            }
        }
        return sumdivisors;
    }

    public static void main(String[] args) {
        System.out.println(divisorSum(6));
    }
}
