package interview.amazon_interview_questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tareqmy on 27/7/20.
 */
public class LongestSubStringWORepeat {

    //Given a string, find the length of the longest substring without repeating characters.

    public static int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        Set<Character> subSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            longestLength = Math.max(longestLength, subSet.size());
            subSet.clear();
            subSet.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (subSet.contains(s.charAt(j))) {
                    longestLength = Math.max(longestLength, subSet.size());
                } else {
                    subSet.add(s.charAt(j));
                }
            }
        }

        return Math.max(longestLength, subSet.size());
    }

    public static int lengthOfLongestSubstringLC(String s) {
        //sliding window
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstringLC2(String s) {
        //sliding window optimized
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println("lengthOfLongestSubstring() = " + lengthOfLongestSubstringLC("au"));
        System.out.println("lengthOfLongestSubstring() = " + lengthOfLongestSubstringLC("abcabcbb"));
//        System.out.println("lengthOfLongestSubstring() = " + lengthOfLongestSubstringLC("pwwkew"));
        System.out.println("lengthOfLongestSubstring() = " + lengthOfLongestSubstringLC("abba"));
    }

}
