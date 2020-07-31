package interview.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by tareqmy on 21/7/20.
 */
public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> uniq = new LinkedHashSet<>();
        uniq.add(n);
        while (n != 1) {
            n = getHappy(n);
//            System.out.println("n = " + n);
            //NOTE: when a number is not happy it goes in circle??
            if(uniq.contains(n)){
                return false;
            }

            uniq.add(n);
        }
        System.out.println("uniq = " + uniq);
        return true;
    }

    public static int getHappy(int n) {
        int sum = 0;
        while(n != 0){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println("i = " + i + " --> " + isHappy(i));
        }
    }

    public boolean isHappyLC(int n) {

        int sum = n;
        Set<Integer> uniq = new HashSet<>();

        while (sum != 1) {

            int temp = sum;
            sum = 0;
            long divisor = 1;

            while (temp > divisor) {
                divisor *= 10;
                sum += Math.pow(Math.floorDiv(temp % divisor, divisor/10), 2);
                temp -= temp % divisor;
            }

            sum += Math.pow(Math.floorDiv(temp, divisor), 2);

            if(uniq.contains(sum)){
                return false;
            }

            uniq.add(sum);
        }
        return true;
    }
}
