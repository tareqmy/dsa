package interview.leetcode;

/**
 * Created by tareqmy on 25/7/20.
 */
public class ExcelTitleToNumber {
//    Given a column title as appear in an Excel sheet, return its corresponding column number.

    //    1 <= s.length <= 7
    //    s consists only of uppercase English letters.
    //    s is between "A" and "FXSHRXW".

    //    "B" = 2
    //    "BC" = (2)26 + 3
    //    "BCM" = (2(26) + 3)26 + 13
    public static int titleToNumberLC(String s) {
        int number = 0;
        for (char c : s.toCharArray()) {
            number *= 26;
            number += c - 'A' + 1;
        }
        return number;
    }

    //523 = 3*10^0 + 2*10^1 + 5*10^2
    //common way of calculating is scan from right to left... and multiply by BASE^position*currentDigitValue
    //When determining value an alternate way is scan number 123 from left to right
    //sum = (sum * BASE) + currentDigitValue
    //5 = 5
    //52 = 5*10 + 2
    //523 = (5*10 + 2)10 + 3

    //B = 26^0*2
    //BC = 26^1*2 + 26^0*3


    //2 = 10^0*2
    //23 = 10^1*2 + 10^0*3
    //OR
    //23 = (10^0*2)*10 + 10^0*3

    public static void main(String[] args) {
        int i = 'B' - 'A' + 1;
        System.out.println("i = " + i);
        System.out.println("title = " + titleToNumber("Z"));
        System.out.println("title = " + titleToNumber("AA"));
        System.out.println("title = " + titleToNumber("AB"));
        System.out.println("title = " + titleToNumber("AZ"));
        System.out.println("title = " + titleToNumber("BA"));
        System.out.println("title = " + titleToNumber("BC"));
        System.out.println("title = " + titleToNumber("ZZ"));
        System.out.println("title = " + titleToNumber("ABC"));
    }

    public static int titleToNumber(String s) {
        int number = 0;
        for (int i = s.length() - 1, power = 0; i >= 0; i--, power++) {
            int charValue = s.charAt(i) - 'A' + 1;
            int pow = (int) Math.pow(26, power);
            number = number + pow * charValue;
        }
        return number;
    }

}
