package interview.leetcode;

import java.util.*;

/**
 * Created by tareqmy on 20/7/20.
 */
public class IntersectArrays {

    //Given two arrays, write a function to compute their intersection.

//    Each element in the result should appear as many times as it shows in both arrays.
//    The result can be in any order.

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nums1IndexMap = new HashMap<>();
        for (int value : nums1) {
            Integer count = nums1IndexMap.getOrDefault(value, 0);
            nums1IndexMap.put(value, count + 1);
        }
        //NOTE: what if sorted!!!
        int k = 0;
        for (int value : nums2) {
            if (nums1IndexMap.containsKey(value) && nums1IndexMap.get(value) > 0) {
                nums1[k] = value;
                k++;
                Integer count = nums1IndexMap.get(value);
                nums1IndexMap.put(value, count - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] nums1 = {54, 93, 21, 73, 84, 60, 18, 62, 59, 89, 83, 89, 25, 39, 41, 55, 78, 27, 65, 82, 94, 61, 12, 38, 76, 5, 35, 6, 51, 48,
                61, 0, 47, 60, 84, 9, 13, 28, 38, 21, 55, 37, 4, 67, 64, 86, 45, 33, 41};
        int[] nums2 = {17, 17, 87, 98, 18, 53, 2, 69, 74, 73, 20, 85, 59, 89, 84, 91, 84, 34, 44, 48, 20, 42, 68, 84, 8, 54, 66, 62, 69,
                52, 67, 27, 87, 49, 92, 14, 92, 53, 22, 90, 60, 14, 8, 71, 0, 61, 94, 1, 22, 84, 10,
                55, 55, 60, 98, 76, 27, 35, 84, 28, 4, 2, 9, 44, 86, 12, 17, 89, 35, 68, 17, 41, 21, 65, 59, 86, 42, 53, 0, 33, 80, 20};
        int[] intersect = intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.print(i + ", ");
        }
    }

    public int[] intersectLC(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return nums1;
        if (nums2.length == 0)
            return nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums2[j] < nums1[i])
                j++;
            else if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
