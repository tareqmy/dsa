package interview.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tareqmy on 1/8/20.
 */
public class SmallerThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        Arrays.sort(nums);
        int[] smallerCount = new int[nums.length];
        smallerCount[0] = 0;
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[lastIndex]) {
                lastIndex = i;
                smallerCount[i] = i;
            } else {
                smallerCount[i] = smallerCount[lastIndex];
            }
        }
        return smallerCount;
    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        smallerNumbersThanCurrent2(nums);
    }

    //tried with sorting... but although count was correct... but not in the unsorted order it is expected in result
    //solution with sorting taken from discuss
    public static int[] smallerNumbersThanCurrent2(int[] nums) { //O(nlogn), O(n)
        if (nums == null || nums.length <= 1) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        int[] copy = nums.clone();

        System.out.println(Arrays.toString(nums));
        //8,1,2,2,3
        Arrays.sort(copy);
        //1,2,2,3,8
        System.out.println(Arrays.toString(copy));
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(copy[i], i); //even when multiple is found only the smallest index is needed for that value.
        }
        System.out.println(map);
        for (int i = 0; i < nums.length; i++) {
            copy[i] = map.get(nums[i]);
        }
        System.out.println(Arrays.toString(copy));
        return copy;
    }

    //discuss... limitation on 0 <= nums[i] <= 100
    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= 100; i++) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else
                res[i] = count[nums[i] - 1];
        }

        return res;
    }
}
