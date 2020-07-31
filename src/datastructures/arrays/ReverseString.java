package datastructures.arrays;

public class ReverseString {

    public static String ReverseString(String string) {
        StringBuilder result = new StringBuilder();
        final int length = string.length();
        for (int i = length - 1; i >= 0; i--) {
            result.append(string.charAt(i));
        }
        return result.toString();
    }

    public static String ReverseStringWithReelJava(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseString("123456"));
        System.out.println(ReverseStringWithReelJava("123456"));
        System.out.println(reverseString("123456789"));
    }

    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        char[] chars = input.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end) { //O(n)
            char buffer = chars[start];
            chars[start] = chars[end];
            chars[end] = buffer;
            start++;
            end--;
        }

        return String.valueOf(chars);
    }
}
