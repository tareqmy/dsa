package ctci6.ch1.Q1_04_Palindrome_Permutation;

import java.util.Arrays;

public class QuestionA {
    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = Common.buildCharFrequencyTable(phrase);
        System.out.println("Arrays.toString(table) = " + Arrays.toString(table));
        return checkMaxOneOdd(table); //palindrome can allow maximum 1 odd count of character
    }

    public static void main(String[] args) {
        String pali = "Rats live on no evil star";
        System.out.println(isPermutationOfPalindrome(pali));

        int a = Character.getNumericValue('a');
        System.out.println("a = " + a);
        int b = 'b';
        System.out.println("b = " + b);
    }


}
