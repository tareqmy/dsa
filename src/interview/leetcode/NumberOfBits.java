package interview.leetcode;

/**
 * Created by tareqmy on 26/7/20.
 */
public class NumberOfBits {

    //Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n = n >>> 1; //logical right shift...
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("hammingWeight(3) = " + hammingWeight(3));
        System.out.println("hammingWeight(1) = " + hammingWeight(1));
        System.out.println("hammingWeight(-3) = " + hammingWeight(-3));
        System.out.println("hammingWeight(-3) = " + hammingWeight2(-3));
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }
}
