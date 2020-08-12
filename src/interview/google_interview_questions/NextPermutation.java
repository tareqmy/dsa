package interview.google_interview_questions;

import java.util.Arrays;

/**
 * Created by tareqmy on 28/7/20.
 */
public class NextPermutation {

//    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//    The replacement must be in-place and use only constant extra memory.

    //NOTE: could not solve it, because could not dissect how the next permutation is found by my head in steps.
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        //find first decreasing element position
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        //did we find any?
        if (i >= 0) {
            //find the element greater than decreasing element
            int j = nums.length - 1;
            //because the rest are descending order, find the first element that is greater than ith from right
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1); //reverse is same as sorting as this portion was descending order
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {1, 3, 2};
//        int[] nums = {3,2,1};
//        int[] nums = {1,1,5};
//        int[] nums = {2, 3, 1};
//        int[] nums = {4, 2, 0, 2, 3, 2, 0};
//        System.out.println(Arrays.toString(nums));
//        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < 120; i++) {
            nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
        }

    }
}
