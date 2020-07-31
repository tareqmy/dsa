package interview.leetcode;

/**
 * Created by tareqmy on 24/7/20.
 */
public class MaximumProfit2 {

//    Design an algorithm to find the maximum profit.
//    You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

    //[7,1,5,3,6,4]
    public static int maxProfit(int[] prices) { //O(n)
        int minprice = Integer.MAX_VALUE;
        int totalProfit = 0;
        int maxprofit = 0;
        //NOTE: this is also peak valey approach..
        for (int price : prices) {
            if (price < minprice) {
                if (maxprofit > 0) { //NOTE: always check with edgecases
                    totalProfit += maxprofit;
                    maxprofit = 0;
                }
                minprice = price;
            } else {
                if (price - minprice > maxprofit) {
                    maxprofit = price - minprice;
                } else {
                    totalProfit += maxprofit;
                    maxprofit = 0;
                    minprice = price;
                }
            }
        }
        return totalProfit + maxprofit;
    }

    public int maxProfitLCAnother(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            //for each increment add in profit.
            int profit = prices[i] - prices[i - 1];
            if (profit > 0)
                maxprofit += profit;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = {2, 1, 2, 0, 1};
        System.out.println("maxProfit(prices) = " + maxProfit(prices));
    }

    public int maxProfitLCPeakValey(int[] prices) {
        int i = 0;
        int valley;
        int peak;
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
