package interview.leetcode;

/**
 * Created by tareqmy on 22/7/20.
 */
public class ReverseInteger {

    //Given a 32-bit signed integer, reverse digits of an integer.

    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int remainder = x % 10;
            x = x / 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && remainder > 7)) {
                //2147483647
                return 0;
            }
            //NOTE: Needed to learn this boundary condition logic.
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && remainder < -8)) {
                //-2147483648
                return 0;
            }
            reverse = reverse * 10 + remainder;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println("reverse(1) = " + reverse(1));
        System.out.println("reverse(1) = " + reverse(12));
        System.out.println("reverse(1) = " + reverse(-123));
        System.out.println("reverse(1) = " + reverse(-12));
        System.out.println("reverse(1) = " + reverse(1534236469));

        System.out.println("MAX = " + Integer.MAX_VALUE);
        System.out.println("MIN = " + Integer.MIN_VALUE);
    }
}
