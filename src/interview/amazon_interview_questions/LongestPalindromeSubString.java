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
        System.out.println("longestPalindrome() = " + longestPalindrome("babad"));
        System.out.println("longestPalindrome() = " + longestPalindrome("cbbd"));
    }

    //copied from leetcode
    public String longestPalindrome2(String s) { //O(n^2)
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1); //incase palindrome center has 2samecharacters
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
