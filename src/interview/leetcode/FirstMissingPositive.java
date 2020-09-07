package interview.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by tareqmy on 4/9/20.
 */
public class FirstMissingPositive {

    //Given an unsorted integer array, find the smallest missing positive integer.

//    Input: [1,2,0]
//    Output: 3

//    Input: [3,4,-1,1]
//    Output: 2

//    Input: [7,8,9,11,12]
//    Output: 1

    public static int firstMissingPositive(int[] nums) { //O(n), space O(n)
        if (nums == null || nums.length <= 0) return 1;

        HashSet<Integer> positiveIntegers = new HashSet<>();
        for (int num : nums) {
            if (num > 0) positiveIntegers.add(num);
        }

        for (int i = 1; i <= positiveIntegers.size(); i++) {
            if (!positiveIntegers.contains(i)) return i;
        }

        return positiveIntegers.size() + 1;
    }

    public static void main(String[] args) {
//        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1}; //8
        int[] nums = {12, 7, 1, 8, 9, 3, 11}; //2
//        int[] nums = {3, 4, -1, 1}; //2
//        int[] nums = {1, 2, 0}; //3
        System.out.println("mi = " + firstMissingPositiveLC(nums));
    }

    //follow-up: Your algorithm should run in O(n) time and uses constant extra space.
    public static int firstMissingPositiveLC(int[] nums) {
        //try to put i+1 value in ith index
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length)
                i++;
            else if (nums[nums[i] - 1] != nums[i]) {
//                System.out.println("nums[nums[i] - 1] = " + nums[nums[i] - 1]);
                swap(nums, i, nums[i] - 1);
                System.out.println("Arrays.toString(A) = " + Arrays.toString(nums));
            }
            else
                i++;

        }

        i = 0;
        while (i < nums.length && nums[i] == i + 1)
            i++;
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        System.out.println("swapping " + i + "=" + nums[i] + " " + j + "=" + nums[j]);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
