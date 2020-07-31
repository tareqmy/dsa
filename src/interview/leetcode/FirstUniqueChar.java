package interview.leetcode;

import java.util.*;

/**
 * Created by tareqmy on 20/7/20.
 */
public class FirstUniqueChar {

    //Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
    //Note: You may assume the string contains only lowercase English letters.

    public static void main(String[] args) {
        System.out.println("index = " + firstUniqCharImproved(null));
        System.out.println("index = " + firstUniqCharImproved("leetcode"));
        System.out.println("index = " + firstUniqCharImproved("loveleetcode"));
    }

    //NOTE: where does it consider that these are lower case letters!!!
    public static int firstUniqChar(String s) { //O(n)
        int index = -1;
        if (s == null || s.length() <= 0) {
            return index;
        }

        Map<Character, List<Integer>> single = new LinkedHashMap();
        for (int i = 0; i < s.length(); i++) {
            single.computeIfAbsent(s.charAt(i), list -> new ArrayList<>()).add(i);
        }

        //the linkedHashMap will maintain the order
        for (Map.Entry<Character, List<Integer>> entry : single.entrySet()) {
            if(entry.getValue().size() == 1) {
                index = entry.getValue().get(0);
                break;
            }
        }

        return index;
    }

    public static int firstUniqCharImproved(String s) { //O(n)
        int index = -1;
        if (s == null || s.length() <= 0) {
            return index;
        }

        Set<Character> rejected = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!rejected.contains(c)) {
                if(i == s.lastIndexOf(c)) {
                    return i;
                } else {
                    rejected.add(c);
                }
            }
        }

        return index;
    }

    public int firstUniqCharLeetCode(String s) {

        int min = Integer.MAX_VALUE;
        if (s.length() == 1) {
            return 0;
        }

        for (char c = 'a'; c <= 'z'; c++) {

            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);

            if (first != -1 && first == last) {
                min = Math.min(min, first);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
