package interview.leetcode;

/**
 * Created by tareqmy on 23/7/20.
 */
public class RemoveDuplicates {

    //    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
//
//    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        //NOTE: the array is sorted.
        for (int i = 0; i < length; i++) {
            int j = 1;
            while (i + j < length && nums[i] == nums[i + j]) {
                j++;
            }
            if (j > 1) {
                //migrate
                int l = i + 1;
                for (int k = i + j; k < length; k++, l++) {
                    nums[l] = nums[k];
                }
                length = length - j + 1;
            }
        }

        return length;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("removeDuplicates(nums) = " + removeDuplicates(nums));
        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }

    //THESE ARE ALL EASIER WHEN DRAWN ON PAPER TO FIGURE OUT THE STRATEGY
    //copied from leetcode... a simplified solution
    public static int removeDuplicatesLC(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
