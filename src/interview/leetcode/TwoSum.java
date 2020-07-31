package interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tareqmy on 19/7/20.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        twoSum(nums, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complements.containsKey(nums[i])) {
                indices[0] = complements.get(nums[i]);
                indices[1] = i;
                break;
            }
            complements.put(complement, i);
        }

        return indices;
    }
}
