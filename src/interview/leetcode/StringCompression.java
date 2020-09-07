package interview.leetcode;

import java.util.Arrays;

/**
 * Created by tareqmy on 4/9/20.
 */
public class StringCompression {

//    Given an array of characters, compress it in-place.
//
//    The length after compression must always be smaller than or equal to the original array.
//
//    Every element of the array should be a character (not int) of length 1.
//
//    After you are done modifying the input array in-place, return the new length of the array.
//
//
//    Follow up:
//    Could you solve it using only O(1) extra space?

//    ["a","a","b","b","c","c","c"] = 6
//    ["a"] = 1
//    ["a","b","b","b","b","b","b","b","b","b","b","b","b"] = 4 --- because ["a","b","1","2"]

//    All characters have an ASCII value in [35, 126].
//    1 <= len(chars) <= 1000.

    public static int compress(char[] chars) { //NOTE: it expects the result in place... just counting the result is not good enough
        if (chars == null || chars.length <= 0) return -1;

        char current = 0;
        int currentCount = 0;
        int currentIndex = 0;
        for (char aChar : chars) {
            if (current == aChar) {
                currentCount++;
            } else {
                if (currentCount >= 1) {
                    currentIndex = applyCompression(chars, currentIndex, currentCount, current);
                }
                current = aChar;
                currentCount = 1;
            }
        }

        if (currentCount >= 1) {
            currentIndex = applyCompression(chars, currentIndex, currentCount, current);
        }

        return currentIndex;
    }

    //    Runtime: 1 ms, faster than 97.01% of Java online submissions for String Compression.
//    Memory Usage: 39.2 MB, less than 75.71% of Java online submissions for String Compression.
    public static int applyCompression(char[] chars, int currentIndex, int currentCount, char current) {
        chars[currentIndex++] = current;
        StringBuilder builder = new StringBuilder();
        if (currentCount > 1) {
            while (currentCount / 10 != 0) {
                builder.insert(0, currentCount % 10);
                currentCount = currentCount / 10;
            }
            builder.insert(0, currentCount % 10);
        }
        builder.getChars(0, builder.length(), chars, currentIndex);
        currentIndex = currentIndex + builder.length();
        return currentIndex;
    }

    public static void main(String[] args) {
//        System.out.println("5/10 = " + 5 / 10);
//        System.out.println("5%10 = " + 5 % 10);
////        System.out.println("getDigitCount(5) = " + getDigitCount(5));
////        System.out.println("getDigitCount(5) = " + getDigitCount(55));
//        System.out.println("getDigitCount(5) = " + getDigitCount(555555));

        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
        System.out.println("compress(chars) = " + compress(chars));
        System.out.println("chars = " + Arrays.toString(chars));
//        System.out.println("1 = " + Character.forDigit(1, 10));
    }
}
