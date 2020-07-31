package interview.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tareqmy on 19/7/20.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        List<String> stringList = fizzBuzz(15);
        System.out.println("stringList = " + stringList);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> fb = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            String e = "";
            if (i % 3 == 0) {
                e = e + "Fizz";
            }
            if (i % 5 == 0) {
                e = e + "Buzz";
            }
            if (e.isEmpty()) {
                e = String.valueOf(i);
            }

            fb.add(e);
        }

        return fb;
    }
}
