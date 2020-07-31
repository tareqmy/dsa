package interview.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tareqmy on 21/7/20.
 */
public class ContainsDuplicate {

//    Given an array of integers, find if the array contains any duplicates.
//
//    Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>(nums.length);

        for (int num : nums) {
            if (visited.contains(num)) {
                return true;
            }
            visited.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("containsDuplicate() = " + containsDuplicate(nums));
    }
}
