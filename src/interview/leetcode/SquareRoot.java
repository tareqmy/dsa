package interview.leetcode;

/**
 * Created by tareqmy on 24/7/20.
 */
public class SquareRoot {

//    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
//
//    Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

    //NOTE: fails if the number is close to max integer
    public static int mySqrt(int x) {

        if (x == 0) return 0;
        //NOTE: after making 'i' long instead of int... it passed ...
        // because otherwise i*i will cross overflow for int.
        for (long i = 1; i < Integer.MAX_VALUE; i++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) return (int) i;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println("mySqrt(4) = " + mySqrt(4)); //2
        System.out.println("mySqrt(4) = " + mySqrt(8)); //2
        System.out.println("mySqrt(4) = " + mySqrtLCBinarySearch(278)); //2
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
    }

    //NOTE: need to know newton's method to do this
    public static int mySqrtLC(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    public static int mySqrtLCBinarySearch(int x) { //O(logn)
        if (x == 0)
            return 0;

        int lo = 1;
        int hi = x;

        while (true) {

            // find mid this way to avoid overflow.
            int mid = lo + (hi - lo) / 2; // (lo + hi)/2 >> (2lo + hi - lo)/2 >> 2lo/2 + (hi-lo)/2
            System.out.println("lo = " + lo + ", mid = " + mid+ ", hi = " + hi);
            // check if (mid*mid > x) which is the same as asking if (mid > x/mid)
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                // this means mid*mid <= x, so check if (mid+1)*(mid+1) > x,
                // which is the same as asking if (mid+1 > x/(mid+1))
                // if it is then mid is the answer
                if (mid + 1 > x / (mid + 1))
                    return mid;
                lo = mid + 1;
            }
        }

    }

}
