package interview.leetcode;

import java.util.Arrays;

/**
 * Created by tareqmy on 19/7/20.
 */
public class MoveZeroes {
    //Given an array nums, write a function to move all 0's
    // to the end of it while maintaining the relative order of the non-zero elements.


    //    You must do this in-place without making a copy of the array.
    //    Minimize the total number of operations.
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i + 1 < nums.length) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        Input: [0,1,0,3,12]
//        Output: [1,3,12,0,0]
        int[] nums = {1, 2, 0, 4, 0, 5, 12};
//        moveZeroes(nums);
        Arrays.stream(nums).forEach(value -> {
            System.out.print(value + ", ");
        });
        System.out.println();
        moveZeroesLeetCode(nums);
        Arrays.stream(nums).forEach(value -> {
            System.out.print(value + ", ");
        });
    }

    //from leetcode ---- this is absolutely unreadable.
    public static void moveZeroesLeetCode(int[] nums) {
        int j = 0;
        //NOTE: it maintains starting of sequence of zero with j
        //but until the first zero is found it makes a swap of the current location with itself!
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
