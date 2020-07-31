package interview.leetcode;

import java.util.Arrays;

/**
 * Created by tareqmy on 25/7/20.
 */
public class ReverseBits {

//    Reverse bits of a given 32 bits unsigned integer.

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        //didnt consider the whole 32 bits
        char[] chars = Integer.toBinaryString(n).toCharArray();
        char[] array32 = new char[32];
        Arrays.fill(array32, '0');
        System.arraycopy(chars, 0, array32, 32 - chars.length, chars.length);
        System.out.println("before = " + Arrays.toString(array32));
        int start = 0;
        int end = array32.length - 1;
        while (start < end) {
            char tmp = array32[start];
            array32[start] = array32[end];
            array32[end] = tmp;
            start++;
            end--;
        }

        System.out.println("after = " + Arrays.toString(array32));

        //parsing with normal parse int failed for negative values!!
        return Integer.parseUnsignedInt(String.valueOf(array32), 2);
    }

    //improved from version 1
    public static int reverseBits2(int n) { //O(1) always 32 loops
        char[] chars = Integer.toBinaryString(n).toCharArray();
        char[] array32 = new char[32];


        for (int i = 0, j = chars.length - 1; i < 32; i++, j--) {
            if (j >= 0) { //enter the reverse of chars until length finishes
                array32[i] = chars[j];
            } else { //fill the rest with 0
                array32[i] = '0';
            }
        }

        System.out.println("after = " + Arrays.toString(array32));

        // you need treat n as an unsigned value
        //parsing with normal parse int failed for negative values!!
        return Integer.parseUnsignedInt(String.valueOf(array32), 2);
    }

    public static void main(String[] args) {

        //NOTE: following operation fails!
//        System.out.println("Integer = " + Integer.parseInt("11111111111111111111111111111101", 2)); //43261596 for unsigned... -3 for signed
        //But the next does not!
//        System.out.println("Integer = " + Integer.parseUnsignedInt("11111111111111111111111111111101", 2)); //-3


        //        System.out.println("reverseBits(10) = " + reverseBitsLC(43261596));
//        System.out.println("reverseBits(10) = " + reverseBitsLC(1320));
        System.out.println("reverseBits(10) = " + reverseBitsLC2(1320));
//        System.out.println("reverseBits(10) = " + reverseBits2(-3));
    }

    //until n is not zero... get last digit and put it at the end of result... then remove last digit of n
    //when n is zero... just add zero at the end until 32 iterations are done.
    public static int reverseBitsLC(int n) { //O(1)
        int reverse = 0;
        System.out.print(n + " = " + Integer.toBinaryString(n));
        System.out.print(" " +  reverse +" = " + Integer.toBinaryString(reverse));
        System.out.println(" n<<1 = " + (n << 1));
        for (int i = 0; i < 32; i++) {

            //n & 1 will return the last digit ... if last digit 0 --- get 0, if 1 --- get 1
            //left shift is creating a space in the last digit...
            reverse = (reverse << 1) | (n & 1); //left shift and create 0 in last place... and get last digit of n and put there.
            n = n >> 1; //remove last digit
            System.out.print(n + " = " + Integer.toBinaryString(n));
            System.out.print(" " +  reverse +" = " + Integer.toBinaryString(reverse));
            System.out.println(" n<<1 = " + (n << 1));
        }
        return reverse;
    }

    public static int reverseBitsLC2(int n) { //O(1)
        int reverse = 0, power = 31;
        while (n != 0) {
            System.out.print(n + " = " + Integer.toBinaryString(n));
            System.out.println(" " +  reverse +" = " + Integer.toBinaryString(reverse));
            reverse += (n & 1) << power; //push the last digit of n 'power' times
            n = n >> 1;
            power--;
        }
        System.out.print(n + " = " + Integer.toBinaryString(n));
        System.out.println(" " +  reverse +" = " + Integer.toBinaryString(reverse));
        return reverse;
    }

}
