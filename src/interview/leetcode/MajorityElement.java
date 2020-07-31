package interview.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tareqmy on 25/7/20.
 */
public class MajorityElement {

//    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//    You may assume that the array is non-empty and the majority element always exist in the array.

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int majorElement = 0;
        int majorCount = 0;
        for (int num : nums) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
            if (count > majorCount) {
                majorCount = count;
                majorElement = num;
            }
        }

        return majorElement;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 3};
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println("majorityElement(nums) = " + majorityElement(nums));
    }

    //through sorting... it must be in location n/2
    public int majorityElementLC(int[] nums) {
        Arrays.sort(nums); //O(nlogn)
        return nums[nums.length/2];
    }

    //O(n)
    //space O(1)
    public int majorityElementLCBoyerMoore(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) { //when current candidate count become 0, consider the current num as new candidate
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
