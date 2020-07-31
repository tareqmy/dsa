package interview.leetcode;

/**
 * Created by tareqmy on 26/7/20.
 */
public class PowerOfTwo {

    static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        //NOTE: faltu solution
        //x^2=y ---- log2(y) = x... so if log2(y) is integer, it should be power of 2
        return (int) (Math.ceil(Math.log(n) / Math.log(2))) == (int) (Math.floor(Math.log(n) / Math.log(2)));
    }

    static boolean isPowerOfTwo2(int n) {
        if (n == 0)
            return false;

        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        //divide number until result 1. if remainder is not zero, then it is not divisible by 2, thus not power of 2
        return true;
    }


    //because all power of two only has 1 digit set e.g 4 > 100, 8 > 1000
    //and x-1 will have alternate 1s e.g 3 > 011 and 7 > 0111
    //so if bitwise and is applied between x & x-1 it should be = 0, if power of 2
    static boolean isPowerOfTwo3(int x) {
      /* First x in the below expression is
        for the case when x is 0 */
        return x != 0 && ((x & (x - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println("Math.log(4) = " + Math.log(4));
        System.out.println("Math.log(4) = " + Math.log(4) / Math.log(2));
        System.out.println("Math.log(4) = " + (int) Math.ceil(Math.log(4)));
        System.out.println("Math.log(4) = " + (int) Math.ceil(Math.log(4) / Math.log(2)));
        System.out.println("Math.log10(100) = " + Math.log10(100));

        System.out.println("isPowerOfTwo(4) = " + isPowerOfTwo(4));
        System.out.println("isPowerOfTwo(4) = " + isPowerOfTwo3(4));

        System.out.println("4 = " + Integer.toBinaryString(4));
        System.out.println("3 = " + Integer.toBinaryString(3));
        int x = 4;
        System.out.println("x & (x-1) = " + (x & (x - 1)));

        System.out.println("isPowerOfTwoNew(4) = " + isPowerOfTwoNew(-2147483648));
    }

    public static boolean isPowerOfTwoNew(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
