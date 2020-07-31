package interview.leetcode;

/**
 * Created by tareqmy on 21/7/20.
 */
public class CountPrime {

    //Count the number of prime numbers less than a non-negative number, n.

    //2 is the beginning prime
    public static int countPrimes(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            boolean prime = isPrime(i);
            if (prime) {
                count++;
            }
        }

        return count;
    }

    //this fails in terms of TIME EXCEEDED
    private static boolean isPrime(int n) {
        boolean prime = true;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        //dividing with j that is a prime will decrease... which will require to keep linkedlist of primes already found.
        for (int j = 3; j <= Math.sqrt(n); j+=2) {
            if (n % j == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        System.out.println("countPrimes(10) = " + countPrimes(1500000));
        System.out.println("countPrimes(10) = " + countPrimesOptimizedSoE(1500000));
    }

    //THIS OPTIMIZED SOLUTION NEEDS PRIOR KNOWLEDGE OF THE THEORY
    //The Sieve of Eratosthenes
    public static int countPrimesOptimizedSoE(int n) {
        int count = 0;
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }

//        System.out.println("Math.sqrt(n) = " + Math.sqrt(n));

        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) { //rejecting multiples of i where i*i <n
            if (!primes[i]) continue; //previously marked false... only for primes we want to find multiples to reject

//            System.out.println("i = " + i);

            for (int j = i * i; j < n; j = j + i) { //start with i*i and increment with i
                primes[j] = false;
            }
        }

        for (int i = 2; i < n; i++) {
            if (primes[i]) count++;
        }
        return count;
    }
}
