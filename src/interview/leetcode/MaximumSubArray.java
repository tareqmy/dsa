package interview.leetcode;

/**
 * Created by tareqmy on 23/7/20.
 */
public class MaximumSubArray {

    //Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    //O(N^3)
    public static int maxSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        if(nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                maximum = Math.max(maximum, getSum(nums, i, j));
            }
        }

        return maximum;
    }
//NOTE: AFTER TAKING hints from LEETCODE it was found to TIME LIMIT EXCEEDED.
    public static int getSum(int[] nums, int begin, int end) {
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum = sum + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; //[4,-1,2,1] has the largest sum = 6.
        int[] nums = {-2, -1};
        System.out.println("maxSubArray(nums) = " + maxSubArray(nums));
    }

    public static int maxSubArrayLC(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int sum = 0;
                for (int k = i; k <= j; ++k) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    //PASSED TIME LIMIT
    public int maxSubArrayLC2(int[] nums) { //O(n^2)
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE; // can't be 0
        for (int i = 0; i < n; ++i) { // starts at i
            int sum = nums[i];
            maxSum = Math.max(maxSum, sum);
            //NOTE: instead of another loop to sum... incrementally create sum
            for (int j = i + 1; j < n; ++j) { // starts from the next element
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
