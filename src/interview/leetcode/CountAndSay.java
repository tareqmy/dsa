package interview.leetcode;

/**
 * Created by tareqmy on 23/7/20.
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String say = "1";

        for (int i = 2; i <= n; i++) {
            say = getNextSay(say);
        }

        return say;
    }

    public static String getNextSay(String say) {
        StringBuilder next = new StringBuilder();
        for (int i = 0; i < say.length(); i++) {
            char c = say.charAt(i);
            int count = 1; //count including the current character 'c'
            if (i + 1 < say.length()) { // are any more characters left?
                int j = i + 1;
                //find the consecutive appearance of this char
                while (j < say.length()) { //find the next char that is not equal.
                    if (c != say.charAt(j)) {
                        break;
                    }
                    count++;
                    j++;
                }
                i = j - 1;
                //although j is next nonequal index and we need to start from j index in the next iteration...
                // 'i' will be increased by one before next iteration, so i should be positioned at the last equal index.
            }
            next.append(count);
            next.append(c);
        }
        System.out.println("next = " + next);
        return next.toString();
    }

    public static void main(String[] args) {
        System.out.println("countAndSay = " + countAndSay(30));
//        StringBuilder x = new StringBuilder();
//        x.append(2);
//        x.append(4);
//        System.out.println("x = " + x);
    }
}
