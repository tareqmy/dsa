package interview.facebook;

/**
 * Created by tareqmy on 24/7/20.
 */
public class MaximumProfit {

    public int maxProfit(int[] prices) { //O(n^2)
        int maxProfit = 0;         //NOTE: always check all the conditions... if there is always loss dont buy is an option

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    //NOTE: requires prior knowledge???
    public int maxProfitLC(int[] prices) { //O(n)
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice)
                minprice = price;
            else {
                maxprofit = Math.max(maxprofit, price - minprice);
            }
        }
        return maxprofit;
    }
}
