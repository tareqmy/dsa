package interview.leetcode;

import java.util.Arrays;

/**
 * Created by tareqmy on 24/7/20.
 */
public class MergeSortedArrays {

//    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

//    The number of elements initialized in nums1 and nums2 are m and n respectively.
//    You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

    public static void merge(int[] nums1, int m, int[] nums2, int n) { //O(nlogn)
        for (int j = 0, i = m; j < n; j++, i++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
//        nums1 = [1,2,3,0,0,0], m = 3
//        nums2 = [2,5,6],       n = 3
//
//        Output: [1,2,2,3,5,6]

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeLC(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i + ",");
        }
    }

    //O(n)
    public static void mergeLC(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            if ((nums1[tail1] > nums2[tail2])) {
                nums1[finished] = nums1[tail1];
                tail1--;
            } else {
                nums1[finished] = nums2[tail2];
                tail2--;
            }
            finished--;
        }

        //NOTE: if tails1 >= 0 which means... the remaining elements are correctly in position already
        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
    }
}
