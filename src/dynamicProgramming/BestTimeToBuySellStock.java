package dynamicProgramming;

public class BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        if(prices.length <=1) return 0;

        int N = prices.length;
        int maxProfit = 0;
        int buyProfit = prices[0];

        for(int i=0; i <  N; i++){
                buyProfit = Math.min(prices[i] , buyProfit);
                maxProfit = Math.max(prices[i]-buyProfit, maxProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
       System.out.println(maxProfit(prices));

        int[] prices1 = {7,6,4,3,1};
        System.out.println(maxProfit(prices1));
    }
}
