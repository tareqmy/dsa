package interview.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tareqmy on 22/7/20.
 */
public class RomanToInteger {

    //Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    //Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

    public static int romanToInt(String s) {
        int result = 0;

        Map<Character, Integer> romanValueMap = new LinkedHashMap<>();
        romanValueMap.put('I', 1);
        romanValueMap.put('V', 5);
        romanValueMap.put('X', 10);
        romanValueMap.put('L', 50);
        romanValueMap.put('C', 100);
        romanValueMap.put('D', 500);
        romanValueMap.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            char roman = s.charAt(i);
            Integer value = romanValueMap.get(roman);
            if(i + 1 < s.length()) {
                char nextRoman = s.charAt(i + 1);
                Integer nextValue = romanValueMap.get(nextRoman);
                if(value < nextValue) {
                    value = nextValue - value;
                    i++;
                }
            }
            result = result + value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("romanToInt() = " + romanToInt("MCMXCIV"));
    }
}
