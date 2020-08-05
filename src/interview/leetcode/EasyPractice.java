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

    public int minTimeToVisitAllPoints(int[][] points) {
        if (points == null || points.length <= 1) return 0;
        int minTime = 0;
        int[] last = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] current = points[i];
            minTime += Math.max(Math.abs(current[0] - last[0]), Math.abs(current[1] - last[1]));
            last = current;
        }
        return minTime;
    }

    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;

        return getSumPower(head).sum;
    }

    private SumPower getSumPower(ListNode node) {
        if (node.next == null) {
            SumPower sumPower = new SumPower();
            sumPower.power = 0;
            sumPower.sum = node.val;
            return sumPower;
        }
        SumPower sumPower = getSumPower(node.next);
        sumPower.power = sumPower.power + 1;
        if (node.val == 1)
            sumPower.sum = sumPower.sum + (int) Math.pow(2, sumPower.power);
        return sumPower;
    }

    public class SumPower {
        public int sum = 0;
        public int power = 0;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int value = (root.val >= L && root.val <= R) ? root.val : 0;
        return value + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (n > 9 && n < 100) {
                count++;
            } else if (n > 999 && n < 10000) {
                count++;
            } else if (n == 100000) {
                count++;
            }
        }
        return count;
    }

    public int balancedStringSplit(String s) {
        int count = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                current++;
            } else {
                current--;
            }
            if (current == 0) {
                count++;
            }
        }
        return count;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (index[i] < i) {
                //need to shift from index[i] until i
                if (i - index[i] >= 0) System.arraycopy(target, index[i], target, index[i] + 1, i - index[i]);
                //put the nums[i] in target at index[i]
                target[index[i]] = nums[i];
            } else {
                target[i] = nums[i];
            }
        }

        return target;
    }

    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0) {
            int remainder = n % 10;
            product = product * remainder;
            sum = sum + remainder;
            n = n / 10;
        }
        return product - sum;
    }

    public int xorOperation(int n, int start) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ (start + (2 * i));
        }
        return xor;
    }

    public String restoreString(String s, int[] indices) {
        if (s == null || s.length() == 0) return "";
        char[] restored = new char[indices.length];

        for (int i = 0; i < s.length(); i++) {
            restored[indices[i]] = s.charAt(i);
        }

        return String.valueOf(restored);
    }

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }

        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) count++;
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
