package interview.amazon_interview_questions;

/**
 * Created by tareqmy on 27/7/20.
 */
public class LongestPalindromeSubString {

    //Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    public static String longestPalindrome(String s) { //O(n^3)
        if (s == null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        String longestPalindrome = "";

        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (isPalindrome(chars, i, j)) {
                    System.out.println("found pal from " + i + " " + j);
                    if (longestPalindrome.length() < j - i + 1) {
                        longestPalindrome = s.substring(i, j + 1);
                        System.out.println("longestPalindrome = " + longestPalindrome);
                    }
                }
            }
        }

        return longestPalindrome;
    }

    public static boolean isPalindrome(char[] chars, int i, int j) {
        if (i > j) return false;
        while (i < j) {
            if (chars[i] != chars[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("longestPalindrome() = " + longestPalindrome2("babad"));
        System.out.println("longestPalindrome() = " + longestPalindrome2("baabad"));
//        System.out.println("longestPalindrome() = " + longestPalindrome2("cbbd"));
    }

    //copied from leetcode
    public static String longestPalindrome2(String s) { //O(n^2)
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1); //incase palindrome center has 2samecharacters
            int len = Math.max(len1, len2);
            if (len > end - start) { //because +1 is not added, same length is replaced
                start = i - ((len - 1) / 2);
                end = i + (len / 2);

                //NOTE: tried to find myself the calculation by analysis
//                if (len % 2 == 0) {
//                    //if len even
//                    start = i - (len / 2) + 1;
//                    end = i + (len / 2);
//                } else {
//                    //if len odd
//                    start = i - (len / 2);
//                    end = i + (len / 2);
//                }
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //copied from leetcode then tried returning indices instead of lenght
    public static String longestPalindromeAlt(String s) { //O(n^2)
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] len1 = expandAroundCenterAlt(s, i, i);
            int[] len2 = expandAroundCenterAlt(s, i, i + 1); //incase palindrome center has 2samecharacters
            int len = Math.max(len1[1] - len1[0] + 1, len2[1] - len2[0] + 1);
            if (len > end - start + 1) {
                if (len1[1] - len1[0] >= len2[1] - len2[0]) {
                    start = len1[0];
                    end = len1[1];
                } else {
                    start = len2[0];
                    end = len2[1];
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private static int[] expandAroundCenterAlt(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        int[] lr = new int[2];
        lr[0] = L + 1;
        lr[1] = R - 1;
        return lr;
    }
}
