package interview.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tareqmy on 29/7/20.
 */
public class WordBreak {

//    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
//    determine if s can be segmented into a space-separated sequence of one or more dictionary words.

//    The same word in the dictionary may be reused multiple times in the segmentation.
//    You may assume the dictionary does not contain duplicate words.

    //NOTE: time limit exceeded
    //"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    public static boolean wordBreak(String s, List<String> wordDict) {
        System.out.println("s = " + s);
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                System.out.println("word = " + word);
                String temp = s.substring(word.length());
                if (temp.length() == 0) {
                    return true;
                }
                if (wordBreak(temp, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        String input = "leetcode";
//        String input = "applepenapple";
        String input = "catsandog";
//        List<String> dict = Arrays.asList("leet", "code");
//        List<String> dict = Arrays.asList("apple", "pen");
        List<String> dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("wordBreak(input, dict) = " + wordBreak(input, dict));
    }

    public boolean wordBreakLC(String s, List<String> wordDict) {
        //taken from discussion board
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
