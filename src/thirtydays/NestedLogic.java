//https://www.hackerrank.com/challenges/30-nested-logic/problem?isFullScreen=true&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

package thirtydays;

        import java.util.*;

public class NestedLogic {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);

        int dayReturned = sc.nextInt();
        int monthReturned = sc.nextInt();
        int yearReturned = sc.nextInt();
        int dayDue = sc.nextInt();
        int monthDue = sc.nextInt();
        int yearDue = sc.nextInt();

        int monthsLate = monthDue - monthReturned;
        int daysLate =  dayDue - dayReturned;
        int yearsLate = yearDue - yearReturned;

        int response = 0;
        if (yearsLate == 0) {
            if (monthsLate >= 0) {
                if ((daysLate < 0)) {
                    response = 15 * daysLate;
                }
            } else {
                response = 500 * monthsLate;
            }
        } else if (yearsLate < 0) {
            response = 10000;
        }

        System.out.println(Math.abs(response));
    }
}
