package interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tareqmy on 19/7/20.
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] ints = {4, 1, 2, 1, 2};
//        System.out.println("singleNumber() = " + singleNumber(ints));
        System.out.println("singleNumber() = " + singleNumberNoMemory(ints));
    }

    //Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    //Your algorithm should have a linear runtime complexity.
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> visited = new HashMap<>();
        for (int num : nums) {
            Integer count = visited.get(num);
            if (count == null) {
                count = 0;
            }
            count++;
            visited.put(num, count);
        }
        return visited.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findAny().orElse(0);
    }

    // Could you implement it without using extra memory? but time O(n^2)
    public static int singleNumberNoMemory(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if(i==j) {
                    continue;
                }
                if (nums[i] == nums[j]) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                single = nums[i];
            }
        }
        return single;
    }

    //COPIED FROM LEETCODE time O(n) space O(1)
    public int singleNumberBitManipulation(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
