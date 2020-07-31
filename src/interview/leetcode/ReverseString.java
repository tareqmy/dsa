package interview.leetcode;

/**
 * Created by tareqmy on 19/7/20.
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'1', '2', '3', '4', '5'};
        reverseString(s);
    }
    //O(1) memory
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        char tmp;
        while (start < end) {
            tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
        System.out.println("s = " + String.valueOf(s));
    }
}
