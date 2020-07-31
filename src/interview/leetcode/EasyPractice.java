package interview.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tareqmy on 30/7/20.
 */
public class EasyPractice {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
//        System.out.println(Arrays.toString(shuffle(nums, 4)));

//        int[] nums = {1, 2, 3, 1, 1, 3};
//        System.out.println("numIdenticalPairs(nums) = " + numIdenticalPairs(nums));

        System.out.println("numberOfSteps() = " + numberOfSteps(8));
    }

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }

        for (int i = 0; i < S.length(); i++) {
            if(jewels.contains(S.charAt(i))) count++;
        }

        return count;
    }

    public static int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            steps++;
        }
        return steps;
    }

    public String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : address.toCharArray()) {
            if (c == '.') {
                stringBuilder.append("[.]");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
        //pattern matching was slower than above algorithm
//        return address.replaceAll("\\.", "[.]");
    }


    public static int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int pairs = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    pairs++;
                }
            }
        }

        return pairs;
    }


    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || candies.length <= 0) return new ArrayList<>(0);
        List<Boolean> greatest = new ArrayList<>(candies.length);
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int candy : candies) {
            greatest.add((candy + extraCandies) >= max);
        }
        return greatest;
    }

    public static int[] shuffle(int[] nums, int n) {
        if (nums == null || nums.length <= 2) return nums;
        int[] sh = new int[nums.length];
        for (int i = 0, j = n; i < n; i++, j++) {
            sh[i * 2] = nums[i];
            sh[(i * 2) + 1] = nums[j];
        }
        return sh;
    }

    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        return sum;
    }
}
