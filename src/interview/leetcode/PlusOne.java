package interview.leetcode;

/**
 * Created by tareqmy on 23/7/20.
 */
public class PlusOne {

//    Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
//
//    The digits are stored such that the most significant digit is at the head of the list,
//    and each element in the array contains a single digit.
//
//    You may assume the integer does not contain any leading zero, except the number 0 itself.

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        int[] plusOne = new int[digits.length + 1];
        plusOne[0] = 1;
        return plusOne;
    }

    public static void main(String[] args) {
//        int[] digits = {1, 2, 3}; //123 + 1 = 124
//        int[] digits = {9,9,9}; //123 + 1 = 124
//        int[] digits = {4, 3, 2, 1}; //4321 + 1 = 4322
        int[] digits = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; //4321 + 1 = 4322

        int[] ints = plusOne(digits);
        for (int i : ints) {
            System.out.print(i + ", ");
        }
    }

    //A cleaner solution
    public int[] plusOneLC(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}
