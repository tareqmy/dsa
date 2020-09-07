package interview.leetcode;

import interview.ListNode;
import interview.TreeNode;

import java.util.*;

/**
 * Created by tareqmy on 30/7/20.
 */
public class EasyPractice {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
//        System.out.println(Arrays.toString(shuffle(nums, 4)));

//        int[] nums = {1, 2, 3, 1, 1, 3};
//        System.out.println("numIdenticalPairs(nums) = " + numIdenticalPairs(nums));

//        System.out.println("numberOfSteps() = " + numberOfSteps(8));
//        System.out.println((int) 'a');
//        System.out.println((int) 'A');
//        System.out.println('a' - 'A');
//        System.out.println((int) 'Z');

//        System.out.println(toLowerCase("Hello"));

//        System.out.println("removeOuterParentheses() = " + removeOuterParentheses("(()())(())((()))"));

//        int[] max = {10,2,5,2};
//        System.out.println("maxProduct(max) = " + maxProduct(max));

//        System.out.println("maximum69Number() = " + maximum69Number(9669));
//
//        String[] words = {"gin", "zen", "gig", "msg"};
//        System.out.println("uniqueMorseRepresentations(words) = " + uniqueMorseRepresentations(words));
//
//        char c = 'a' + 3 - 1;
//        System.out.println("c = " + c);
//
//        System.out.println("freqAlphabets() = " + freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
//
//        int[][] image = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
//        flipAndInvertImage(image);
//        print2dArray(image);

//        int n = ~6;
//        System.out.println("n = " + n);
//        int[] sumZero = sumZero(6);
//        System.out.println("sumZero = " + Arrays.toString(sumZero));
//        System.out.println("generateTheString(6) = " + generateTheString(5));

//        System.out.println("sortString() = " + sortString("aaaabbbbcccc"));
//        System.out.println("sortString() = " + sortString("leetcode"));

        int[] prices = {10,1,1,6};
        System.out.println("Arrays.toString(finalPrices()) = " + Arrays.toString(finalPrices(prices)));
    }

    public static int[] finalPrices(int[] prices) {
        int[] finalPrices = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int discountIndex = -1;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    discountIndex = j;
                    break;
                }
            }
            if (discountIndex > 0) {
                finalPrices[i] = prices[i] - prices[discountIndex];
            } else {
                finalPrices[i] = prices[i];
            }
        }
        return finalPrices;
    }

    public static String sortString(String s) {
        StringBuilder builder = new StringBuilder();
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        while (true) {
            boolean hasMore = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    builder.append((char) (i + 'a'));
                    arr[i]--;
                    hasMore = hasMore || arr[i] > 0;
                }
            }
            if (!hasMore) break;
            hasMore = false;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > 0) {
                    builder.append((char) (i + 'a'));
                    arr[i]--;
                    hasMore = hasMore || arr[i] > 0;
                }
            }
            if (!hasMore) break;
        }

        return builder.toString();
    }

    public static String generateTheString(int n) {
        StringBuilder builder = new StringBuilder();
        if (n % 2 == 0) {
            builder.append('y');
            n--;
        }
        for (int i = 0; i < n; i++) {
            builder.append('x');
        }
        return builder.toString();
    }

    public static int[] sumZero(int n) {
        if (n <= 0) return null;
        int[] uniqueSumZero = new int[n];
        int left = 0, right = n - 1;
        while (left < right) {
            uniqueSumZero[left] = n;
            uniqueSumZero[right] = n * (-1);
            n--;
            left++;
            right--;
        }

        return uniqueSumZero;
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int left, right;
        for (int[] row : image) {
            left = 0;
            right = row.length - 1;
            //[1,1,0]
            while (left < right) {
                int temp = row[left] ^ 1;
                row[left] = row[right] ^ 1;
                row[right] = temp;
                left++;
                right--;
            }
            if (left == right) {
                row[left] = row[right] ^ 1;
            }
        }
        return image;
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] g : grid) {
            for (int i = 0; i < g.length; i++) {
                if (g[i] < 0) {
                    count = count + g.length - i;
                    break;
                }
            }
        }
        return count;
    }

    public static String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length()) {
                if (s.charAt(i + 2) == '#') {
                    int digit1 = Character.getNumericValue(s.charAt(i));
                    int digit2 = Character.getNumericValue(s.charAt(i + 1));
                    builder.append((char) ('a' + ((digit1 * 10) + digit2) - 1));
                    i += 2;
                } else {
                    builder.append((char) ('a' + Character.getNumericValue(s.charAt(i)) - 1));
                }
            } else {
                builder.append((char) ('a' + Character.getNumericValue(s.charAt(i)) - 1));
            }
        }

        return builder.toString();
    }

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> l : paths) set.add(l.get(1));
        for (List<String> l : paths) set.remove(l.get(0));
        return set.iterator().next();
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> translations = new HashSet<>();
        String[] MORSE = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."};
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.setLength(0);
            for (char c : word.toCharArray()) {
                builder.append(MORSE[c - 'a']);
            }
            translations.add(builder.toString());
        }
        return translations.size();
    }

    public static String morsify(String word, String[] morseList) {
        StringBuilder builder = new StringBuilder();
        for (char c : word.toCharArray()) {
            builder.append(morseList[c - 'a']);
        }
        return builder.toString();
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if (startTime == null || endTime == null) return 0;
        if (startTime.length != endTime.length) return 0;
        int busyCount = 0;
        int students = startTime.length;

        for (int i = 0; i < students; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) busyCount++;
        }

        return busyCount;
    }

    public static int maximum69Number(int num) {
        int divideBy = 0;
        for (int i = 3; i >= 0; i--) {
            int power = (int) Math.pow(10, i);
            if (num / power == 0) {
                divideBy = 0;
            } else {
                if (num / (divideBy + (power * 9)) == 1) {
                    divideBy = divideBy + (power * 9);
                } else {
                    return num + (power * 3);
                }
            }
        }

        return num;
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length <= 0) return 0;
        if (nums.length == 1) return nums[0] - 1;

        int max1 = 0, max2 = 0;
        for (int num : nums) {
            if (num >= max2) {
                max1 = max2;
                max2 = num;
            } else if (num >= max1) {
                max1 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }

    //(()())(())
    //((()))
    public static String removeOuterParentheses(String s) {
        if (s == null || s.length() <= 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int started = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (started >= 1) {
                    builder.append(c);
                }
                started++;
            } else if (c == ')') {
                started--;
                if (started >= 1) {
                    builder.append(c);
                }
            }
        }

        return builder.toString();
    }

    private static void print2dArray(int[][] matrix) {
        for (int[] row : matrix)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0) return str;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                builder.append((char) (c + 32));
            } else
                builder.append(c);
        }
        return builder.toString();
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        if (arr == null || arr.length < 3) return 0;
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b
                                && Math.abs(arr[k] - arr[i]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
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

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int value = (root.val >= L && root.val <= R) ? root.val : 0;
        return value + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
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
