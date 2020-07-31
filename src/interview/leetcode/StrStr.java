package interview.leetcode;

/**
 * Created by tareqmy on 23/7/20.
 */
public class StrStr {

    //    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int index = -1;

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                //check rest of the needle to match
                boolean fullMatch = true;
                //TIME LIMIT EXCEEDED :(
                int j = 1, k = i + 1;
                for (; j < needle.length() && k < haystack.length(); j++, k++) {
                    if (haystack.charAt(k) != needle.charAt(j)) {
                        fullMatch = false;
                        break;
                    }
                }
                if (fullMatch && j == needle.length()) {
                    return i;
                }
            }
        }

        return index;
    }

    //THIS IS A CLASSIC PROBLEM ... use KMP algorithm
    public static void main(String[] args) {
        String hayStack = "hello";
        String needle = "ll";
        System.out.println("strStr(hayStack, needle) = " + strStr(hayStack, needle));
    }

    //from leet code
    public int strStrLC(String haystack, String needle) {
        for (int i = 0; ; i++) { // The length of haystack
            for (int j = 0; ; j++) { // The length of needle
                if (j == needle.length()) {
                    // If at this point we have navigated through the entire length of needle, we have found a solution, haystack[i].
                    return i;
                }
                if (i + j == haystack.length()) {
                    // This happens when we run out of elements in haystack, but there are still elements in needle.
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    // We stop comparing after needle[j], so 'i' will be incremented and cycle repeats itself.
                    break;
                }
            }
        }
    }
}
