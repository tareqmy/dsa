package interview.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tareqmy on 21/7/20.
 */
public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = charCountMap.getOrDefault(s.charAt(i), 0);
            charCountMap.put(s.charAt(i), count + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(charCountMap.containsKey(c)) {
                Integer count = charCountMap.get(c);
                if(count == 1) {
                    charCountMap.remove(c);
                } else {
                    charCountMap.put(c, count - 1);
                }
            } else {
                return false;
            }
        }

        return charCountMap.size() == 0;
    }

    //Given two strings s and t , write a function to determine if t is an anagram of s.

    public static void main(String[] args) {
        System.out.println("anagram = " + isAnagram("anagram", "nagaram"));
        System.out.println("anagram = " + isAnagram("rat", "car"));
    }
}
