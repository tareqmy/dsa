package interview.amazon;

/**
 * Created by tareqmy on 24/7/20.
 */
public class ClimbingStairs {

//    You are climbing a stair case. It takes n steps to reach to the top.
//
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//    1 <= n <= 45

    public int climbStairs(int n) {
        return climbStairs(0, n); //O(2^n)
    }

    public int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    /**
     * explanation how this is similar to fibonacci
     * n = 1 ... steps = 1 > {1}
     * n = 2 ... steps = 2 > {1,1}, {2}
     * n = 3 ... steps = 3 > {1,1,1}, {1,2}, {2,1}
     * n = 4 ... steps = 5 > {1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1}, {2,2}
     * n = 5 ... steps = 8 > {1,1,1,1,1}, {1,1,1,2}, {1,1,2,1}, {1,2,1,1}, {2,1,1,1}, {1,2,2}, {2,1,2}, {2,2,1}
     */


    //NOTE: apparently this is a fibonacci problem.. with a tweak...
    public static int climbStairs2(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1]; //n+1 because we will ignore the 0th index to match step with iteration
        dp[1] = 1;
        dp[2] = 2;//NOTE: although fibonacci... the third value is 2; not 1
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //because only last two elements are required
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
}
