package interview.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tareqmy on 20/7/20.
 * https://leetcode.com/problems/missing-number/solution/
 */
public class MissingNumber {

    //Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

    //Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

    public static int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int missing = -1;

        for (int num : nums) {
            numSet.add(num);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("mi = " + missingNumber(nums));
        System.out.println("mi = " + missingNumberLC(nums));
    }

    //We can harness the fact that XOR is its own inverse to find the missing element in linear time.
//    Index	0	1	2	3
//    Value	0	1	3	4
//    missing =4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
//            =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
//            =0∧0∧0∧0∧2
//            =2

    public static int missingNumberLC(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
