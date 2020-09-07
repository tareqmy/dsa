package ctci6.ch1.Q1_01_Is_Unique;

public class QuestionB {

    /* Assumes only letters a through z. */
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            int bit = 1 << val;
            if ((checker & bit) > 0) return false; //means that exact bit was set before
            checker |= bit;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }

}
