package interview.leetcode;

import java.util.Arrays;

/**
 * Created by tareqmy on 25/7/20.
 */
public class HouseRobber {

//    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
//    the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
//    and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//    Given a list of non-negative integers representing the amount of money of each house,
//    determine the maximum amount of money you can rob tonight without alerting the police.

    //taken from geeksforgeeks
    //NOTE: apparently this can be solved with recursion
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;

        // dp[i] represent the maximum value stolen
        // so far after reaching house i.
        int[] dp = new int[n];

        // Initialize the dp[0] and dp[1]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill remaining positions
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        System.out.println("dp = " + Arrays.toString(dp));

        return dp[n - 1]; //the last position
    }

    //assuming nums is not null
    //instead of keeping array of profits upto ith position... all we really need is last two maxProfits...
    public static int rob2(int[] nums) {
        int previousMaxProfit = 0;
        int currentMaxProfit = 0;
        int tmp;

        for (int num : nums) {
            tmp = currentMaxProfit;
            //currentMaxProfit is actually the n-1 and previousMaxProfit is n-2
            currentMaxProfit = Math.max(num + previousMaxProfit, currentMaxProfit);
            previousMaxProfit = tmp;
        }

        return currentMaxProfit; //the last position
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {2,7,9,3,1};
//        int[] nums = {2, 1, 1, 2};
//        int[] nums = {12,1,1,1,1,12};
        int[] nums = {5, 11, 7, 1, 2, 8};
//        int[] nums = {};
//        int[] nums = {6};
//        int[] nums = {6,9};

        System.out.println("rob(nums) = " + rob(nums));
        System.out.println("rob(nums) = " + rob2(nums));
    }
}
