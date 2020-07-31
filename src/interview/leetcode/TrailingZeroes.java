package interview.leetcode;

/**
 * Created by tareqmy on 25/7/20.
 */
public class TrailingZeroes {

    //Given an integer n, return the number of trailing zeroes in n!.

    //Your solution should be in logarithmic time complexity.

    public static int trailingZeroes(int n) {
        int factorial = factorial(n);
        System.out.println("factorial = " + factorial);
        int count = 0;

        while (factorial != 0) {
            if(factorial % 10 == 0) {
                count++;
            } else {
                break;
            }
            factorial = factorial / 10;
        }

        return count;
    }
    //NOTE: this solution fails for beyond 12(int)/20(long)
    public static int factorial(int n) { //NOTE: highest 12 for int; 20 for long
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        System.out.println("trailingZeroes(5) = " + trailingZeroes(13));
    }

    //https://www.purplemath.com/modules/factzero.htm
    public int trailingZeroesLC(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}
