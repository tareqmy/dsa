package interview.leetcode;

/**
 * Created by tareqmy on 24/7/20.
 */
public class ValidPalindrome {

//    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//    Note: For the purpose of this problem, we define empty string as valid palindrome.

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int start = 0;
        int end = s.length() - 1;
        String toLowerCase = s.toLowerCase();
        while (start < end) {

            if(!Character.isLetterOrDigit(toLowerCase.charAt(start))) {
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(toLowerCase.charAt(end))) {
                end--;
                continue;
            }

            if(toLowerCase.charAt(start) != toLowerCase.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("isPalindrome = " + isPalindrome(s));
    }
}
