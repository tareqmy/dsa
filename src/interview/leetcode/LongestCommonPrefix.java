package interview.leetcode;

/**
 * Created by tareqmy on 22/7/20.
 */
public class LongestCommonPrefix {
//    Write a function to find the longest common prefix string amongst an array of strings.
//
//    If there is no common prefix, return an empty string "".

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();

        if (strs == null || strs.length == 0) {
            return prefix.toString();
        }

        int lowestLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (lowestLength > str.length()) {
                lowestLength = str.length();
            }
        }

        for (int i = 0; i < lowestLength; i++) {
            char common = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                System.out.println("strs = " + strs[j]);
                if (common != strs[j].charAt(i)) {
                    return prefix.toString();
                }
            }
            prefix.append(common);
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
//        String[] strings = {"flower","flow","flight"};
//        String[] strings = {"dog","racecar","car"};
        String[] strings = {};
        System.out.println("prefix = " + longestCommonPrefix(strings));
    }
}
