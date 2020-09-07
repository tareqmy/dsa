package interview.leetcode;

import java.util.BitSet;

/**
 * Created by tareqmy on 4/9/20.
 */
public class FindDuplicate {

//    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//    There is only one duplicate number in nums, return this duplicate number.
//
//    Input: nums = [1,3,4,2,2]
//    Output: 2
//
//    Input: nums = [3,1,3,4,2]
//    Output: 3
//
//    Input: nums = [1,1]
//    Output: 1

//    2 <= n <= 3 * 104
//    nums.length == n + 1
//    1 <= nums[i] <= n

    public int findDuplicate(int[] nums) { //O(n^2)
        if (nums == null || nums.length <= 1) return -1;
        int duplicate = -1;

        for (int i = 1; i < nums.length; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    if (found) return i;
                    found = true;
                }
            }
        }

        return duplicate;
    }

    public int findDuplicate2(int[] nums) { //O(n)
        if (nums == null || nums.length <= 1) return -1;

        BitSet bitSet = new BitSet(nums.length);
        for (int num : nums) {
            if(bitSet.get(num)) return num;
            bitSet.flip(num);
        }

        return -1;
    }
}
