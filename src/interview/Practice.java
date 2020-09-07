package interview;

/**
 * Created by tareqmy on 13/8/20.
 */
public class Practice {

    public static void main(String[] args) {
//        System.out.println(isPrime(15));
        int[] sorted = {0, 1, 2, 3, 4, 6, 8, 9, 20};
        System.out.println("find = " + findMissingNumber(sorted));
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findMissingNumber(int[] sortedPositiveNumbers) {
        if (sortedPositiveNumbers == null || sortedPositiveNumbers.length <= 0) {
            return 0;
        }
        int currentMissingLow = 0;
        int currentMissingHigh = Integer.MAX_VALUE;
        for (int i = 0; i < sortedPositiveNumbers.length; i++) {
            if (sortedPositiveNumbers[i] > currentMissingLow) return currentMissingLow;
            if (sortedPositiveNumbers[i] == currentMissingLow) {
                currentMissingLow++;
            }
        }
        return -1;
    }
}
