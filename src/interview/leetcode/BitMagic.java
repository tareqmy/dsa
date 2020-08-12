package interview.leetcode;

/**
 * Created by tareqmy on 26/7/20.
 */
public class BitMagic {

    public static void main(String[] args) {
//        int integer = Integer.MAX_VALUE;
//        int integer = Integer.MIN_VALUE;
//        int integer = -1;
//        int integer = -2;
//        String toBinaryString = Integer.toBinaryString(integer);
//        System.out.println("int= " + integer);
//        System.out.println("toBinaryString = " + toBinaryString);

//        System.out.println("Integer = " + Integer.parseInt("00000010100101000001111010011100", 2)); //43261596
//        System.out.println("Integer = " + Integer.parseInt("00000000111001011110000010100101", 2)); //15065253 --- my result!
//        System.out.println("Integer = " + Integer.parseInt("00111001011110000010100101000000", 2)); //964176192

//        NOTE: following operation fails!
//        System.out.println("Integer = " + Integer.parseInt("11111111111111111111111111111101", 2)); //43261596 for unsigned... -3 for signed

//        System.out.println("Integer = " + Integer.parseUnsignedInt("11111111111111111111111111111101", 2)); //-3
//
//        System.out.println(4 + " << 1 = " + (4 << 1));
//        System.out.println(4 + " >> 1 = " + (4 >> 1));
//        System.out.println(4 + " >>> 1 = " + (4 >>> 1));
//        System.out.println(-4 + " >>> 1 = " + (-4 >>> 1));
//        System.out.println(6 + " & 1 = " + (6 & 1));
//
        System.out.println("abs = " + Math.abs(Integer.MIN_VALUE));
        System.out.println("abs = " + Math.abs(-1));
//
//        System.out.println(Integer.toBinaryString(18880));

        System.out.println("NOT ~10=" + (~10));
        System.out.println("AND 6&10=" + (6 & 10));
        System.out.println("OR 6|10=" + (6 | 10));
        System.out.println("XOR 6^10=" + (6 ^ 10));

        System.out.println("isPowerOfTwo(6) = " + isPowerOfTwo(10));
        System.out.println("hammingWeight(18880) = " + hammingWeight(18880));
        System.out.println("countOne(18880) = " + countOne(18880));

        System.out.println("checkIthBitSet(20,2) = " + checkIthBitSet(20, 2));

        char[] a = {'a', 'b', 'c'};
        possibleSubsets(a);

        System.out.println("mostSignificantBit(13) = " + mostSignificantBit(Integer.MAX_VALUE));
        System.out.println("largestPower(14) = " + largestPower(Integer.MAX_VALUE));
    }

    public static boolean isPowerOfTwo(int x) { //O(1)
        // x will check if x > 0 and (x & (x - 1)) == 0 will check if x is a power of 2 or not
        return x > 0 && ((x & (x - 1)) == 0);
    }

    public static int hammingWeight(int n) { //O(K), K is the index of left most 1 in the binary
        int count = 0;
        while (n != 0) {
            //with this logic you can find the binary form of the number
            if ((n & 1) == 1) count++;
            n = n >>> 1; //logical right shift...
        }
        return count;
    }

    //NOTE: alternate way of hammingWeight
    public static int countOne(int n) { //O(K), K is the number of 1 in the binary number
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static boolean checkIthBitSet(int n, int i) {
        return (n & (i << i)) == 0;
    }

    public static void possibleSubsets(char[] elements) {
        int n = elements.length;
        for (int i = 0; i < (1 << n); ++i) {
            System.out.print("{");
            for (int j = 0; j < n; ++j)
                if ((i & (1 << j)) != 0) {
                    System.out.print(elements[j]);
                }
            System.out.println("}");
        }
    }

    public static int mostSignificantBit(int n) {
        while (n != 0) {
            if ((n & n - 1) == 0) return n;
            n = n & n - 1;
        }
        return n;
    }

    public static int largestPower(int n) {
        //changing all right side bits to 1.
        n = n | (n >>> 1);
        n = n | (n >>> 2);
        n = n | (n >>> 4);
//        n = n | (n >>> 8);
//        n = n | (n >>> 16);
        //NOTE: this too fucked up?? see mostSignificantBit
        //as now the number is 2 * x-1, where x is required answer, so adding 1 and dividing it by 2.
        return (n + 1) >> 1;
    }

    //until n is not zero... get last digit and put it at the end of result... then remove last digit of n
    //when n is zero... just add zero at the end until 32 iterations are done.
    public static int reverseBits(int n) { //O(1)
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            //n & 1 will return the last digit ... if last digit 0 --- get 0, if 1 --- get 1
            //left shift is creating a space in the last digit...
            reverse = (reverse << 1) | (n & 1); //left shift and create 0 in last place... and get last digit of n and put there.
            n = n >> 1; //remove last digit
        }
        return reverse;
    }

    //add two int without '+'
    public static int getSum(int a, int b) { //a^b is sum, a&b<<1 is carry
        if (a == 0) return b;
        if (b == 0) return a;
        return getSum(a ^ b, (a & b) << 1);
    }

    //in first iteration adding is done and if carry bit exists in the lowest level iteratively add the carry bit... until there is no carry bit
    public static int getSumIterative(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    //Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
    //Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
    //this is beyond me
    public static int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    //Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    //this is beyond me
    public int singleNumberBitManipulation(int[] nums) { //time O(n) space O(1)
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
