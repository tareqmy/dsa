package interview.leetcode;

/**
 * Created by tareqmy on 20/7/20.
 */
public class PowerOfThree {

    //Given an integer, write a function to determine if it is a power of three.

    //Could you do it without using any loop / recursion?

    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }

    //NOTE: this result have 17ms while the above solution gave 11ms once then 24ms!!! for the same code.
    public static boolean isPowerOfThreeLeetCode(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        //1, 3, 9, 27 are true, 15 is not
        System.out.println("isPowerOfThree(27) = " + isPowerOfThree(27));
        System.out.println("isPowerOfThree(45) = " + isPowerOfThree(45));
        System.out.println("isPowerOfThree(0) = " + isPowerOfThree(0));
        System.out.println("isPowerOfThree(9) = " + isPowerOfThree(9));
        System.out.println("isPowerOfThree(81) = " + isPowerOfThree(81));
//        System.out.println("9/3 = " + 3 / 3);
//        System.out.println("9%3 = " + 9 % 3);
//        System.out.println("5%3 = " + 5 % 3);
    }
}
