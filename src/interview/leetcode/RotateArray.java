package interview.leetcode;

/**
 * Created by tareqmy on 25/7/20.
 */
public class RotateArray {

//    Given an array, rotate the array to the right by k steps, where k is non-negative.

//    1 <= nums.length <= 2 * 10^4
//    It's guaranteed that nums[i] fits in a 32 bit-signed integer.
//    k >= 0

//    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//    Could you do it in-place with O(1) extra space?

    public static void rotate(int[] nums, int k) { //O(n*k)
        if(nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int shift = nums[nums.length - 1];
            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = shift;
        }
    }

    public static void shift(int[] nums) {
        int shift = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = shift;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate2(nums, 3);
        for (int n : nums) {
            System.out.print(n + ", ");
        }
    }

    public static void rotate2(int[] nums, int k) { //O(n)? ... space O(k)
        if(nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        int[] temp = new int[k];
        for (int i = k - 1, j = nums.length - 1; i >= 0; i--,j--) {
            temp[i] = nums[j];
        }
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }


    //taken from leetcode
    public void rotateLC(int[] nums, int k) { //O(n), space:O(1)
        k %= nums.length;
        reverse(nums, 0, nums.length - 1); //reverse whole
        reverse(nums, 0, k - 1); //reverse first k elements
        reverse(nums, k, nums.length - 1); //reverse rest of element
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
