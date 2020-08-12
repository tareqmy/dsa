package interview.google_interview_questions;

import java.util.Arrays;

/**
 * Created by tareqmy on 29/7/20.
 */
public class TrappingRainWater {

    //Given n non-negative integers representing an elevation map where the width of each bar is 1,
    // compute how much water it is able to trap after raining.

    //NOTE: time limit exceeded
    //gave a huge elevation -- with hundreds of huge heights like
    //10527,740,9013,1300,29680,4898,13993,15213,18182,24254,3966,24378,11522......
    public static int trap(int[] height) {
        int water = 0;
        int start = 0;
        int end = 0;
        System.out.println(Arrays.toString(height));
        while (true) {
            for (int i = 0; i < height.length; i++) {
                if (height[i] > 0) {
                    start = i;
                    break;
                }
            }
            for (int i = height.length - 1; i > start; i--) {
                if (height[i] > 0) {
                    end = i;
                    break;
                }
            }

            System.out.println("start = " + start);
            System.out.println("end = " + end);
            if (start == 0 && end == 0) {
                break;
            }

            //count
            for (int i = start; i <= end; i++) {
                if (height[i] == 0) water++;
            }

            //minus -1 all
            for (int i = 0; i < height.length; i++) {
                if (height[i] > 0) height[i] = height[i] - 1;
            }
            start = 0;
            end = 0;
            System.out.println(Arrays.toString(height));
        }
        return water;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //result = 6
        System.out.println("trap(height) = " + trap2(height));
    }

    public static int trap2(int[] height) {
        if (height == null || height.length <= 1) return 0;

        // To store the maximum water
        // that can be stored
        int res = 0;
        int n = height.length;

        // For every element of the array
        // except first and last element
        for (int i = 1; i < n - 1; i++) {

            // Find maximum element on its left
            int left = height[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }

            // Find maximum element on its right
            int right = height[i];
            for (int j = i + 1; j < n; j++) {
                right = Math.max(right, height[j]);
            }

            // Update maximum water value
            res += Math.min(left, right) - height[i];
        }
        return res;
    }

    //improvement on version 2
    public static int trap3(int[] height) {
        if (height == null || height.length <= 1) return 0;

        int n = height.length;
        int water = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(height));
        System.out.println(Arrays.toString(right));

        for (int i = 0; i < n; i++) {
            int currentWater = Math.min(left[i], right[i]) - height[i];
            System.out.print("left = " + left[i]);
            System.out.print(",right = " + right[i]);
            System.out.print(",height = " + height[i]);
            System.out.println(",currentWater = " + currentWater);
        }

        return water;
    }
}
