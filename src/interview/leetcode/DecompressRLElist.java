package interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tareqmy on 4/9/20.
 */
public class DecompressRLElist {

    //    We are given a list nums of integers representing a list compressed with run-length encoding.
//    2 <= nums.length <= 100
//    nums.length % 2 == 0
//    1 <= nums[i] <= 100
    public int[] decompressRLElist(int[] nums) {
        if (nums == null || nums.length <= 0 || nums.length % 2 != 0) return null;

        int newSize = 0;
        for (int i = 0; i < nums.length; i += 2) {
            newSize += nums[i];
        }

        int[] decompressed = new int[newSize];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
//            for (int j = 0; j < nums[i]; j++) {
//                decompressed[index] = nums[i + 1];
//                index++;
//            }
            //same as above. using utility class... this improved from 1ms to 0ms!
            Arrays.fill(decompressed, index, index + nums[i], nums[i + 1]);
            index += nums[i];
        }

        return decompressed;
    }

    public int[] decompressRLElist2(int[] nums) { //this is worse than the version1
        if (nums == null || nums.length <= 0 || nums.length % 2 != 0) return null;

        List<Integer> decompressed = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                decompressed.add(nums[i + 1]);
            }
        }

        return decompressed.stream().mapToInt(i -> i).toArray();
    }
}
