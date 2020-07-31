package interview.leetcode;

/**
 * Created by tareqmy on 24/7/20.
 */
public class ClimbingStairs {

//    You are climbing a stair case. It takes n steps to reach to the top.
//
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//    1 <= n <= 45


    //NOTE: apparently this is a fibonacci problem.. with a tweak...
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;//NOTE: although fibonacci... the third value is 2; not 1
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
